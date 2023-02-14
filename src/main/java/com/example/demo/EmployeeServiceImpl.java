package com.example.demo;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl {

    @Autowired
    private EmployeeMapper employeeMapper;
    public void convertDTOTODAO(){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmail("balubommisetti@gmail.com");
        employeeDTO.setName("balu");
        employeeDTO.setDepartment("CSE");
        Employee employee = employeeMapper.EmployeeDTOToEmployee(employeeDTO);
        System.out.println(employee.getId());
    }
}
