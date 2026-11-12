package com.cineman1.repository;

import com.cineman1.dto.InvoiceStatistics1;
import com.cineman1.dto.MovieRevenueStatistics1;
import com.cineman1.dto.ShowtimeStatistics1;
import com.cineman1.model.Ticket1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MovieStatisticsRepository1 extends JpaRepository<Ticket1, Long> {

    @Query("""
            SELECT new com.cineman1.dto.MovieRevenueStatistics1(
                m.id, m.movieName, COUNT(t), SUM(t.ticketPrice))
            FROM Ticket1 t
            JOIN t.invoice1 i
            JOIN t.showtime1 s
            JOIN s.movie1 m
            WHERE t.status = :status
              AND i.issuedAt >= :from
              AND i.issuedAt <= :to
            GROUP BY m.id, m.movieName
            ORDER BY SUM(t.ticketPrice) DESC
            """)
    List<MovieRevenueStatistics1> getMovieStatistics(@Param("status") String status,
                                                          @Param("from") LocalDateTime from,
                                                          @Param("to") LocalDateTime to);

    @Query("""
            SELECT new com.cineman1.dto.ShowtimeStatistics1(
                s.id, s.showDate, s.startTime, r.roomName, COUNT(t), SUM(t.ticketPrice))
            FROM Ticket1 t
            JOIN t.invoice1 i
            JOIN t.showtime1 s
            JOIN s.screeningRoom1 r
            WHERE t.status = :status
              AND s.movie1.id = :movieId
              AND i.issuedAt >= :from
              AND i.issuedAt <= :to
            GROUP BY s.id, s.showDate, s.startTime, r.roomName
            ORDER BY s.showDate ASC, s.startTime ASC
            """)
    List<ShowtimeStatistics1> getShowtimesOfMovie(@Param("status") String status,
                                                      @Param("movieId") Long movieId,
                                                      @Param("from") LocalDateTime from,
                                                      @Param("to") LocalDateTime to);

    @Query("""
            SELECT new com.cineman1.dto.InvoiceStatistics1(
                i.id, i.issuedAt,
                CASE WHEN c IS NULL THEN 'Khách vãng lai' ELSE c.fullName END,
                COUNT(t), i.totalAmount)
            FROM Ticket1 t
            JOIN t.invoice1 i
            LEFT JOIN i.customer1 c
            WHERE t.showtime1.id = :showtimeId
            GROUP BY i.id, i.issuedAt, c.fullName, i.totalAmount
            ORDER BY i.issuedAt ASC
            """)
    List<InvoiceStatistics1> getInvoicesOfShowtime(@Param("showtimeId") Long showtimeId);
}
