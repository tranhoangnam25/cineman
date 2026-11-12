package com.cineman1.repository;

import com.cineman1.model.Customer1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository1 extends JpaRepository<Customer1, Long> {

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);

    Optional<Customer1> findByPhoneNumber(String phoneNumber);

    Optional<Customer1> findByEmail(String email);
}
