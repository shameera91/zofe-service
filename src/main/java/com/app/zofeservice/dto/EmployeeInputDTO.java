package com.app.zofeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created By Shameera.A on 1/29/2020
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInputDTO {

    private String name;
    private String phone;
    private String email;
}
