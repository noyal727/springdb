package com.example.springdb.controller;

import com.example.springdb.dto.DepartmentRequestDto;
import com.example.springdb.dto.DepartmentResponseDto;
import com.example.springdb.entity.Department;
import com.example.springdb.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public DepartmentResponseDto createDepartment
            (@RequestBody DepartmentRequestDto departmentRequestDto){
        return departmentService.createDepartment(departmentRequestDto);
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") Long id){
        return departmentService.getDepartmentById(id);
    }
    @PutMapping("/{id}")
    public DepartmentResponseDto updateDepartment
            (@PathVariable("id") Long departmentId,
             @RequestBody DepartmentRequestDto departmentRequestDto){
        return departmentService.updateDepartment(departmentId,departmentRequestDto);
    }
}
