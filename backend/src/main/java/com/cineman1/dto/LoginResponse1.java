package com.cineman1.dto;

public class LoginResponse1 {

    private String token;
    private String hoTen;
    private String vaiTro;

    public LoginResponse1() {
    }

    public LoginResponse1(String token, String hoTen, String vaiTro) {
        this.token = token;
        this.hoTen = hoTen;
        this.vaiTro = vaiTro;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }
}
