package com.example.springdb.dto;

import com.example.springdb.entity.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDto {

    private Long id;

    private String name;

    private String code;

    private DepartmentResponseDto department;

    public void setDepartmentFromEntity(Department departmentEntity){
        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        departmentResponseDto.setId(departmentEntity.getId());
        departmentResponseDto.setName(departmentEntity.getName());
        this.department = departmentResponseDto;
    }

}