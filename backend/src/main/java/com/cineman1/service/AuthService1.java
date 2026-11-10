package com.cineman1.service;

import com.cineman1.dto.LoginRequest1;
import com.cineman1.dto.LoginResponse1;
import com.cineman1.model.Employee1;
import com.cineman1.repository.EmployeeRepository1;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService1 {

    private final EmployeeRepository1 employeeRepository1;
    private final TokenService1 tokenService1;

    public AuthService1(EmployeeRepository1 employeeRepository1, TokenService1 tokenService1) {
        this.employeeRepository1 = employeeRepository1;
        this.tokenService1 = tokenService1;
    }

    public LoginResponse1 dangNhap(LoginRequest1 request) {
        Employee1 employee1 = employeeRepository1.findByTenDangNhap(request.getTenDangNhap())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                        "Tên đăng nhập hoặc mật khẩu không đúng"));
        if (!employee1.getMatKhau().equals(request.getMatKhau())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                    "Tên đăng nhập hoặc mật khẩu không đúng");
        }
        String token = tokenService1.taoToken(employee1);
        return new LoginResponse1(token, employee1.getHoTen(), employee1.getVaiTro());
    }
}
