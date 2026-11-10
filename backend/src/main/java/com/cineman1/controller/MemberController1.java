package com.cineman1.controller;

import com.cineman1.dto.RegisterMemberRequest1;
import com.cineman1.dto.RegisterMemberResponse1;
import com.cineman1.service.MemberService1;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
public class MemberController1 {

    private final MemberService1 memberService1;

    public MemberController1(MemberService1 memberService1) {
        this.memberService1 = memberService1;
    }

    @PostMapping("/register1")
    public ResponseEntity<RegisterMemberResponse1> dangKiThanhVien(@Valid @RequestBody RegisterMemberRequest1 request) {
        RegisterMemberResponse1 response = memberService1.dangKiThanhVien(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
