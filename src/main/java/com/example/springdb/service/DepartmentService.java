package com.example.springdb.service;

import com.example.springdb.dto.DepartmentRequestDto;
import com.example.springdb.dto.DepartmentResponseDto;
import com.example.springdb.entity.Department;


public interface DepartmentService {
    DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto);

    Department getDepartmentById(Long id);
    DepartmentResponseDto updateDepartment(Long departmentId, DepartmentRequestDto departmentRequestDto);
}
