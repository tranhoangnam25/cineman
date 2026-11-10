package com.cineman1.dto;

import java.math.BigDecimal;
import java.util.List;

public class MovieStatisticsResponse1 {

    private List<MovieRevenueStatistics1> danhSach;
    private long tongSoVe;
    private BigDecimal tongDoanhThu;

    public MovieStatisticsResponse1() {
    }

    public MovieStatisticsResponse1(List<MovieRevenueStatistics1> danhSach, long tongSoVe, BigDecimal tongDoanhThu) {
        this.danhSach = danhSach;
        this.tongSoVe = tongSoVe;
        this.tongDoanhThu = tongDoanhThu;
    }

    public List<MovieRevenueStatistics1> getDanhSach() {
        return danhSach;
    }

    public void setDanhSach(List<MovieRevenueStatistics1> danhSach) {
        this.danhSach = danhSach;
    }

    public long getTongSoVe() {
        return tongSoVe;
    }

    public void setTongSoVe(long tongSoVe) {
        this.tongSoVe = tongSoVe;
    }

    public BigDecimal getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(BigDecimal tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }
}
