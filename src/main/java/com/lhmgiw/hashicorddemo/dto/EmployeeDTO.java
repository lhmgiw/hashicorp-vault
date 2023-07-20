package com.lhmgiw.hashicorddemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {

    private Long id;
    private String name;
    private String gender;
    private Date dob;
    private String status;

}
