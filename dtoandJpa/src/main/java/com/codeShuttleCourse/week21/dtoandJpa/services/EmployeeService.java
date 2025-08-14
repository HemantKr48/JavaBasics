package com.codeShuttleCourse.week21.dtoandJpa.services;

import com.codeShuttleCourse.week21.dtoandJpa.dto.EmployeeDto;
import com.codeShuttleCourse.week21.dtoandJpa.entities.EmployeeEntity;
import com.codeShuttleCourse.week21.dtoandJpa.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeDto getEmployeeById(Long id){
        EmployeeEntity employeeEntity=employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employeeEntity,EmployeeDto.class);
    }

    public List<EmployeeDto> getAllEmployees(){
        List<EmployeeEntity> employeeEntities=employeeRepository.findAll();

        return employeeEntities.stream().
                map(employeeEntity->modelMapper.map(employeeEntity,EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeDto createEmployee(EmployeeDto employee) {
        EmployeeEntity employeeEntity=modelMapper.map(employee,EmployeeEntity.class);
        employeeRepository.save(employeeEntity);
        return modelMapper.map(employeeEntity,EmployeeDto.class);
    }
}
