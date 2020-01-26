package com.app.zofeservice.dto;

import com.app.zofeservice.modal.Employee;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created By Shameera.A on 1/25/2020
 */

@Getter
@RequiredArgsConstructor
public class CandidateOutputDTO {

    private final int matchLevel;
    private final String serial;
    private final Employee employee;

    public CandidateOutputDTO(int matchLevel, String serial, Employee employee) {
        this.matchLevel = matchLevel;
        this.serial = serial;
        this.employee = employee;
    }

    public int getMatchLevel() {
        return matchLevel;
    }

    public String getSerial() {
        return serial;
    }

    public Employee getEmployee() {
        return employee;
    }
}
