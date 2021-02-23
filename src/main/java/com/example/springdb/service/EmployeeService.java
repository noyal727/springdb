package com.example.springdb.service;

import com.example.springdb.dto.EmployeeRequestDto;
import com.example.springdb.dto.EmployeeResponseDto;

public interface EmployeeService {
    EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto getEmployeeById(Long id);
    EmployeeResponseDto updateEmployeeById(Long id,EmployeeRequestDto employeeRequestDTO);
    EmployeeResponseDto deleteEmployeeById(Long id);
}
