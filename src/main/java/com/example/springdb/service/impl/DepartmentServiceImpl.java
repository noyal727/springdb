package com.example.springdb.service.impl;

import com.example.springdb.dto.DepartmentRequestDto;
import com.example.springdb.dto.DepartmentResponseDto;
import com.example.springdb.entity.Department;
import com.example.springdb.entity.Employee;
import com.example.springdb.repository.DepartmentRepository;
import com.example.springdb.repository.EmployeeRepository;
import com.example.springdb.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto) {
        Department department = new Department();

        BeanUtils.copyProperties(departmentRequestDto, department);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentResponseDto responseDto = new DepartmentResponseDto();
        BeanUtils.copyProperties(savedDepartment, responseDto);

        return responseDto;
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public DepartmentResponseDto updateDepartment(Long departmentId,
                                                  DepartmentRequestDto departmentRequestDto) {
        Department department = departmentRepository.findById(departmentId).get();
        List<Employee> employeeList = employeeRepository.findByDepartment_Id(departmentId);

        //update department
        department.setName(departmentRequestDto.getName());
        Department savedDepartment = departmentRepository.save(department);

        //append departmentCode to employee code

        employeeList.forEach(employee -> {
            employee.setCode(departmentRequestDto.getDepartmentCode());
        });
        employeeRepository.saveAll(employeeList);


        DepartmentResponseDto responseDto = new DepartmentResponseDto();
        BeanUtils.copyProperties(savedDepartment, responseDto);
        return responseDto;
    }
}

