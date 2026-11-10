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
                m.id, m.tenMovie1, COUNT(t), SUM(t.giaVe))
            FROM Ticket1 t
            JOIN t.invoice1 i
            JOIN t.showtime1 s
            JOIN s.movie1 m
            WHERE t.trangThai = :trangThai
              AND i.ngayLap >= :from
              AND i.ngayLap <= :to
            GROUP BY m.id, m.tenMovie1
            ORDER BY SUM(t.giaVe) DESC
            """)
    List<MovieRevenueStatistics1> getTKPhim(@Param("trangThai") String trangThai,
                                                          @Param("from") LocalDateTime from,
                                                          @Param("to") LocalDateTime to);

    @Query("""
            SELECT new com.cineman1.dto.ShowtimeStatistics1(
                s.id, s.ngayChieu, s.gioBatDau, r.tenPhong, COUNT(t), SUM(t.giaVe))
            FROM Ticket1 t
            JOIN t.invoice1 i
            JOIN t.showtime1 s
            JOIN s.screeningRoom1 r
            WHERE t.trangThai = :trangThai
              AND s.movie1.id = :movieId
              AND i.ngayLap >= :from
              AND i.ngayLap <= :to
            GROUP BY s.id, s.ngayChieu, s.gioBatDau, r.tenPhong
            ORDER BY s.ngayChieu ASC, s.gioBatDau ASC
            """)
    List<ShowtimeStatistics1> getSuatChieuCuaPhim(@Param("trangThai") String trangThai,
                                                      @Param("movieId") Long movieId,
                                                      @Param("from") LocalDateTime from,
                                                      @Param("to") LocalDateTime to);

    @Query("""
            SELECT new com.cineman1.dto.InvoiceStatistics1(
                i.id, i.ngayLap,
                CASE WHEN c IS NULL THEN 'Khách vãng lai' ELSE c.hoTen END,
                COUNT(t), i.tongTien)
            FROM Ticket1 t
            JOIN t.invoice1 i
            LEFT JOIN i.customer1 c
            WHERE t.showtime1.id = :showtimeId
            GROUP BY i.id, i.ngayLap, c.hoTen, i.tongTien
            ORDER BY i.ngayLap ASC
            """)
    List<InvoiceStatistics1> getHoaDonCuaSuatChieu(@Param("showtimeId") Long showtimeId);
}
