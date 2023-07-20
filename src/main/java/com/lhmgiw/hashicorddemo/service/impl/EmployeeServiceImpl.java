package com.lhmgiw.hashicorddemo.service.impl;

import com.lhmgiw.hashicorddemo.dto.EmployeeDTO;
import com.lhmgiw.hashicorddemo.dto.ResponseDTO;
import com.lhmgiw.hashicorddemo.repository.EmployeeRepository;
import com.lhmgiw.hashicorddemo.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeServiceImpl implements EmployeeService {
    private static final String SUCCESS = "Success";

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Override
    public Object getAllEmployees() {
        try {
            log.info("EmployeeService - getAllEmployees() called");
            List<EmployeeDTO> employeeList = employeeRepository.findAll()
                            .stream()
                            .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                            .collect(Collectors.toList());

            log.info("EmployeeService - getAllEmployees() completed");
            return new ResponseDTO<>(SUCCESS, "Employees found success",
                    employeeList);

        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
