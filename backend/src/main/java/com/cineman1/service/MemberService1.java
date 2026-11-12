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

    // Tuong ung MemberDAO1.checkDuplicate() trong bieu do lop thiet ke:
    // trung so dien thoai hoac email thi nem DuplicateMemberException1 voi dung field loi.
    public void checkDuplicate(String phoneNumber, String email) {
        if (memberRepository1.existsByPhoneNumber(phoneNumber)) {
            throw new DuplicateMemberException1("phoneNumber", "Số điện thoại đã được đăng kí");
        }
        if (memberRepository1.existsByEmail(email)) {
            throw new DuplicateMemberException1("email", "Email đã được đăng kí");
        }
    }

    // Tuong ung MemberDAO1.addMember(): ghi tblCustomer1 + tblMember1.
    public Member1 addMember(RegisterMemberRequest1 request) {
        LocalDate today = LocalDate.now();
        Customer1 customer1 = new Customer1(
                request.getFullName(),
                request.getDateOfBirth(),
                request.getGender(),
                request.getPhoneNumber(),
                request.getEmail(),
                request.getAddress());
        customer1 = memberRepository1.save(customer1);

        Member1 member1 = new Member1(customer1, today, "Thường", 0);
        return memberInfoRepository1.save(member1);
    }

    // Tuong ung MembershipCardDAO1.addCard(): ghi tblMembershipCard1,
    // ma the theo dinh dang CM + 8 chu so (zero-padded theo id cua the).
    public MembershipCard1 addCard(Member1 member1) {
        LocalDate today = LocalDate.now();
        MembershipCard1 card1 = new MembershipCard1(member1, "TEMP", today, today.plusYears(1), "Đang dùng");
        card1 = membershipCardRepository1.save(card1);
        card1.setCardNumber(String.format("CM%08d", card1.getId()));
        return membershipCardRepository1.save(card1);
    }

    @Transactional
    public RegisterMemberResponse1 registerMember(RegisterMemberRequest1 request) {
        checkDuplicate(request.getPhoneNumber(), request.getEmail());
        Member1 member1 = addMember(request);
        MembershipCard1 card1 = addCard(member1);

        Customer1 customer1 = member1.getCustomer1();
        RegisterMemberResponse1 response = new RegisterMemberResponse1();
        response.setCustomerId(customer1.getId());
        response.setFullName(customer1.getFullName());
        response.setDateOfBirth(customer1.getDateOfBirth());
        response.setGender(customer1.getGender());
        response.setPhoneNumber(customer1.getPhoneNumber());
        response.setEmail(customer1.getEmail());
        response.setAddress(customer1.getAddress());
        response.setMemberId(member1.getId());
        response.setRegistrationDate(member1.getRegistrationDate());
        response.setMembershipTier(member1.getMembershipTier());
        response.setLoyaltyPoints(member1.getLoyaltyPoints());
        response.setCardNumber(card1.getCardNumber());
        response.setIssueDate(card1.getIssueDate());
        response.setExpiryDate(card1.getExpiryDate());
        response.setCardStatus(card1.getStatus());
        return response;
    }
}
