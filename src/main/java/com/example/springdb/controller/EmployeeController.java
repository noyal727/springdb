package com.example.springdb.controller;

import com.example.springdb.dto.EmployeeRequestDto;
import com.example.springdb.dto.EmployeeResponseDto;
import com.example.springdb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  //POST - /employee
  @PostMapping
  public EmployeeResponseDto createEmployee
  (@RequestBody EmployeeRequestDto employeeRequestDto){
    return employeeService.createEmployee(employeeRequestDto);
  }

  //GET - /employee/{id}

  @GetMapping("/{id}")
  public EmployeeResponseDto getEmployeeById(@PathVariable("id") Long id){
    return employeeService.getEmployeeById(id);
  }

  //PUT - /employee/{id}
  @PutMapping("/{id}")
  public EmployeeResponseDto
  updateEmployee(@PathVariable("id") Long id,
                 @RequestBody EmployeeRequestDto employeeRequestDto){
    return employeeService.updateEmployeeById(id, employeeRequestDto);
  }

  //DELETE - /employee/{id}
  @DeleteMapping("/{id}")
  public EmployeeResponseDto deleteEmployeeById(@PathVariable("id") Long id){
    return employeeService.deleteEmployeeById(id);
  }

  //GET - /employee/department/{id}
  @GetMapping("/department/{id}")
  public List<EmployeeResponseDto> getEmployeeListByDepartment(
          @PathVariable("id") Long departmentId) {
    return employeeService.getEmployeeListByDepartment(departmentId);
  }
}