package com.cineman1.repository;

import com.cineman1.model.Employee1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository1 extends JpaRepository<Employee1, Long> {

    Optional<Employee1> findByUsername(String username);
}
