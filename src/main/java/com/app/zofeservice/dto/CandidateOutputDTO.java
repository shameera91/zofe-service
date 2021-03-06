package com.app.zofeservice.dto;

import com.app.zofeservice.modal.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created By Shameera.A on 1/25/2020
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateOutputDTO {

    private int matchLevel;
    private String serial;
    private EmployeeOutputDTO employee;
}
