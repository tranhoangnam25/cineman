package com.cineman1.service;

import com.cineman1.dto.InvoiceStatistics1;
import com.cineman1.dto.MovieRevenueStatistics1;
import com.cineman1.dto.MovieStatisticsResponse1;
import com.cineman1.dto.ShowtimeStatistics1;
import com.cineman1.repository.MovieStatisticsRepository1;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class StatisticsService1 {

    private static final String VE_DA_BAN = "Đã bán";

    private final MovieStatisticsRepository1 movieStatisticsRepository1;

    public StatisticsService1(MovieStatisticsRepository1 movieStatisticsRepository1) {
        this.movieStatisticsRepository1 = movieStatisticsRepository1;
    }

    public MovieStatisticsResponse1 getTKPhim(LocalDate startDate, LocalDate endDate) {
        kiemTraKhoangNgay(startDate, endDate);
        LocalDateTime from = startDate.atStartOfDay();
        LocalDateTime to = endDate.atTime(LocalTime.of(23, 59, 59));

        List<MovieRevenueStatistics1> danhSach =
                movieStatisticsRepository1.getTKPhim(VE_DA_BAN, from, to);

        long tongSoVe = danhSach.stream().mapToLong(MovieRevenueStatistics1::getSoVeDaBan).sum();
        BigDecimal tongDoanhThu = danhSach.stream()
                .map(MovieRevenueStatistics1::getDoanhThu)
                .filter(java.util.Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new MovieStatisticsResponse1(danhSach, tongSoVe, tongDoanhThu);
    }

    public List<ShowtimeStatistics1> getSuatChieuCuaPhim(Long movieId, LocalDate startDate, LocalDate endDate) {
        kiemTraKhoangNgay(startDate, endDate);
        LocalDateTime from = startDate.atStartOfDay();
        LocalDateTime to = endDate.atTime(LocalTime.of(23, 59, 59));
        return movieStatisticsRepository1.getSuatChieuCuaPhim(VE_DA_BAN, movieId, from, to);
    }

    public List<InvoiceStatistics1> getHoaDonCuaSuatChieu(Long showtimeId) {
        return movieStatisticsRepository1.getHoaDonCuaSuatChieu(showtimeId);
    }

    private void kiemTraKhoangNgay(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Phải chọn ngày bắt đầu và ngày kết thúc");
        }
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("Ngày kết thúc phải lớn hơn hoặc bằng ngày bắt đầu");
        }
    }
}
