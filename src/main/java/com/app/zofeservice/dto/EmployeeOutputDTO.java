package com.app.zofeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created By Shameera.A on 1/27/2020
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeOutputDTO {

    private long id;
    private String name;
    private String phone;
    private String email;
}
