package com.cineman1.service;

import com.cineman1.dto.RegisterMemberRequest1;
import com.cineman1.dto.RegisterMemberResponse1;
import com.cineman1.model.Customer1;
import com.cineman1.model.Member1;
import com.cineman1.model.MembershipCard1;
import com.cineman1.repository.MemberInfoRepository1;
import com.cineman1.repository.MemberRepository1;
import com.cineman1.repository.MembershipCardRepository1;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class MemberService1 {

    private final MemberRepository1 memberRepository1;
    private final MemberInfoRepository1 memberInfoRepository1;
    private final MembershipCardRepository1 membershipCardRepository1;

    public MemberService1(MemberRepository1 memberRepository1,
                          MemberInfoRepository1 memberInfoRepository1,
                          MembershipCardRepository1 membershipCardRepository1) {
        this.memberRepository1 = memberRepository1;
        this.memberInfoRepository1 = memberInfoRepository1;
        this.membershipCardRepository1 = membershipCardRepository1;
    }

    // Tuong ung MemberDAO1.kiemTraTrungLap() trong bieu do lop thiet ke:
    // trung so dien thoai hoac email thi nem DuplicateMemberException1 voi dung field loi.
    public void kiemTraTrungLap(String soDienThoai, String email) {
        if (memberRepository1.existsBySoDienThoai(soDienThoai)) {
            throw new DuplicateMemberException1("soDienThoai", "Số điện thoại đã được đăng kí");
        }
        if (memberRepository1.existsByEmail(email)) {
            throw new DuplicateMemberException1("email", "Email đã được đăng kí");
        }
    }

    // Tuong ung MemberDAO1.themThanhVien(): ghi tblCustomer1 + tblMember1.
    public Member1 themThanhVien(RegisterMemberRequest1 request) {
        LocalDate today = LocalDate.now();
        Customer1 customer1 = new Customer1(
                request.getHoTen(),
                request.getNgaySinh(),
                request.getGioiTinh(),
                request.getSoDienThoai(),
                request.getEmail(),
                request.getDiaChi());
        customer1 = memberRepository1.save(customer1);

        Member1 member1 = new Member1(customer1, today, "Thường", 0);
        return memberInfoRepository1.save(member1);
    }

    // Tuong ung MembershipCardDAO1.themThe(): ghi tblMembershipCard1,
    // ma the theo dinh dang CM + 8 chu so (zero-padded theo id cua the).
    public MembershipCard1 themThe(Member1 member1) {
        LocalDate today = LocalDate.now();
        MembershipCard1 card1 = new MembershipCard1(member1, "TEMP", today, today.plusYears(1), "Đang dùng");
        card1 = membershipCardRepository1.save(card1);
        card1.setMaThe(String.format("CM%08d", card1.getId()));
        return membershipCardRepository1.save(card1);
    }

    @Transactional
    public RegisterMemberResponse1 dangKiThanhVien(RegisterMemberRequest1 request) {
        kiemTraTrungLap(request.getSoDienThoai(), request.getEmail());
        Member1 member1 = themThanhVien(request);
        MembershipCard1 card1 = themThe(member1);

        Customer1 customer1 = member1.getCustomer1();
        RegisterMemberResponse1 response = new RegisterMemberResponse1();
        response.setCustomerId(customer1.getId());
        response.setHoTen(customer1.getHoTen());
        response.setNgaySinh(customer1.getNgaySinh());
        response.setGioiTinh(customer1.getGioiTinh());
        response.setSoDienThoai(customer1.getSoDienThoai());
        response.setEmail(customer1.getEmail());
        response.setDiaChi(customer1.getDiaChi());
        response.setMemberId(member1.getId());
        response.setNgayDangKi(member1.getNgayDangKi());
        response.setHangMember1(member1.getHangMember1());
        response.setDiemTichLuy(member1.getDiemTichLuy());
        response.setMaThe(card1.getMaThe());
        response.setNgayCap(card1.getNgayCap());
        response.setNgayHetHan(card1.getNgayHetHan());
        response.setTrangThaiThe(card1.getTrangThai());
        return response;
    }
}
