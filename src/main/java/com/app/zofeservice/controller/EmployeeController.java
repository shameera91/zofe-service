package com.app.zofeservice.controller;

import com.app.zofeservice.dto.EmployeeInputDTO;
import com.app.zofeservice.dto.QuestionInputDTO;
import com.app.zofeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Shameera.A on 1/29/2020
 */
@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/save-question")
    public ResponseEntity<Void> saveEmployee(@RequestBody EmployeeInputDTO employeeInputDTO) {
        employeeService.saveQuestion(employeeInputDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
