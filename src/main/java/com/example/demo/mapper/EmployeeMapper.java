package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "id",
                expression = "java(setEmployeeDAO(employeeDTO.getId()))")
    Employee EmployeeDTOToEmployee(EmployeeDTO employeeDTO);
    default long setEmployeeDAO(Long id){
        if(id==null){
            return 0;
        }
        else{
            return id;
        }
    }
}
