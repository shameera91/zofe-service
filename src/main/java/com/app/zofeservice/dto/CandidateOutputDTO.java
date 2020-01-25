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

}
