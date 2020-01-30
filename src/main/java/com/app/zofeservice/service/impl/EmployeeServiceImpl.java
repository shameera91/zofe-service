package com.app.zofeservice.service.impl;

import com.app.zofeservice.dto.EmployeeInputDTO;
import com.app.zofeservice.modal.Employee;
import com.app.zofeservice.repository.EmployerRepository;
import com.app.zofeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * Created By Shameera.A on 1/29/2020
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployerRepository employerRepository;

    public EmployeeServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public void saveQuestion(EmployeeInputDTO employeeInputDTO) {
        this.employerRepository.save(Employee.builder().name(employeeInputDTO.getName())
                .email(employeeInputDTO.getEmail()).phone(employeeInputDTO.getPhone()).build());
    }
}
