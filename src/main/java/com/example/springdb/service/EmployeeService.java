package com.example.springdb.service;

import com.example.springdb.dto.EmployeeRequestDto;
import com.example.springdb.dto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto);

    EmployeeResponseDto getEmployeeById(Long id);

    EmployeeResponseDto updateEmployeeById(Long id, EmployeeRequestDto employeeRequestDto);

    EmployeeResponseDto deleteEmployeeById(Long id);

    List<EmployeeResponseDto> getEmployeeListByDepartment(Long departmentId);
}
