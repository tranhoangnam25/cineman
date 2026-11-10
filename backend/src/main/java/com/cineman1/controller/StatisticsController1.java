package com.cineman1.controller;

import com.cineman1.dto.InvoiceStatistics1;
import com.cineman1.dto.MovieStatisticsResponse1;
import com.cineman1.dto.ShowtimeStatistics1;
import com.cineman1.service.StatisticsService1;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController1 {

    private final StatisticsService1 statisticsService1;

    public StatisticsController1(StatisticsService1 statisticsService1) {
        this.statisticsService1 = statisticsService1;
    }

    @GetMapping("/movies1")
    public ResponseEntity<MovieStatisticsResponse1> thongKePhim(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return ResponseEntity.ok(statisticsService1.getTKPhim(startDate, endDate));
    }

    @GetMapping("/movies1/{movieId}/showtimes1")
    public ResponseEntity<List<ShowtimeStatistics1>> thongKeSuatChieu(
            @PathVariable("movieId") Long movieId,
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return ResponseEntity.ok(statisticsService1.getSuatChieuCuaPhim(movieId, startDate, endDate));
    }

    @GetMapping("/showtimes1/{showtimeId}/invoices1")
    public ResponseEntity<List<InvoiceStatistics1>> thongKeHoaDon(
            @PathVariable("showtimeId") Long showtimeId) {
        return ResponseEntity.ok(statisticsService1.getHoaDonCuaSuatChieu(showtimeId));
    }
}
