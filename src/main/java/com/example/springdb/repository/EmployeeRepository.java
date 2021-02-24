package com.example.springdb.repository;

import com.example.springdb.entity.Department;
import com.example.springdb.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository
        extends CrudRepository<Employee, Long> {


    //by method name
    List<Employee> findByDepartment(Department department);

    List<Employee> findByDepartment_Id(Long departmentId);

    //by @Query annotation
    @Query("SELECT e FROM Employee e WHERE e.department.id = ?1")
//  @Query("FROM Employee e WHERE e.department.id = ?1")
    List<Employee> getEmployeeListByDepartmentId(Long departmentId);

    @Query("SELECT e FROM Employee e WHERE e.department.id = :departmentId")
        //  @Query("FROM Employee e WHERE e.department.id = ?1")
    List<Employee> getEmployeeListByDepartmentIdParam(@Param("departmentId") Long departmentId);


    //by native query

    @Query(value = "SELECT * FROM employee e WHERE e.department_id = ?1",
            nativeQuery = true)
    List<Employee> getEmployeeListByNativeQuery(Long departmentId);

}
