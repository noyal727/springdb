package com.example.springdb.service.impl;

import com.example.springdb.dto.EmployeeRequestDto;
import com.example.springdb.dto.EmployeeResponseDto;
import com.example.springdb.entity.Employee;
import com.example.springdb.repository.EmployeeRepository;
import com.example.springdb.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto){
        Employee employee = new Employee();
        //copy fields from dto to employee
        BeanUtils.copyProperties(employeeRequestDto, employee);

        //save employee to db
        Employee savedEmployee = employeeRepository.save(employee);

        // copy from employee to response dto
        EmployeeResponseDto responseDto = new EmployeeResponseDto();
        BeanUtils.copyProperties(savedEmployee, responseDto);


        return responseDto;
    }

    @Override
    public EmployeeResponseDto getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            //copy from employee to response dto
            EmployeeResponseDto responseDTO = new EmployeeResponseDto();
            BeanUtils.copyProperties(employeeOptional.get(), responseDTO);
            return responseDTO;
        }
        return null;
    }

    @Override
    public EmployeeResponseDto updateEmployeeById(Long id, EmployeeRequestDto employeeRequestDTO) {
        Optional<Employee> employeeOptional=employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            Employee employeeFromDb=employeeOptional.get();
            employeeFromDb.setName(employeeRequestDTO.getName());
            employeeFromDb.setDepartment(employeeRequestDTO.getDepartment());
            Employee savedEmployee=employeeRepository.save(employeeFromDb);
            EmployeeResponseDto responseDTO=new EmployeeResponseDto();
            BeanUtils.copyProperties(savedEmployee,responseDTO);
            return responseDTO;
    }
        return null;
}

    @Override
    public EmployeeResponseDto deleteEmployeeById(Long id) {

        Optional<Employee> employeeOptional=employeeRepository.findById(id);
        if(employeeOptional.isPresent()){


            EmployeeResponseDto responseDTO=new EmployeeResponseDto();
            BeanUtils.copyProperties(employeeOptional.get(),responseDTO);
            employeeRepository.deleteById(id);
            return responseDTO;
        }
        return null;
    }
}
