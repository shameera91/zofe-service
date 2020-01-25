package com.app.zofeservice.repository;

import com.app.zofeservice.modal.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By Shameera.A on 1/25/2020
 */
public interface EmployerRepository extends JpaRepository<Employee, Long> {
}
