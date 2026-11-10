package com.cineman1.service;

import com.cineman1.model.Employee1;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Quan li token dang nhap don gian trong bo nho (demo, khong dung JWT).
 */
@Service
public class TokenService1 {

    private final Map<String, Employee1> tokens = new ConcurrentHashMap<>();

    public String taoToken(Employee1 employee1) {
        String token = UUID.randomUUID().toString();
        tokens.put(token, employee1);
        return token;
    }

    public boolean tokenHopLe(String token) {
        return token != null && tokens.containsKey(token);
    }

    public Employee1 layNhanVien(String token) {
        return token == null ? null : tokens.get(token);
    }
}
