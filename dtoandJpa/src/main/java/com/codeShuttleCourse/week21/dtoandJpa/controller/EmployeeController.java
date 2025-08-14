package com.codeShuttleCourse.week21.dtoandJpa.controller;


import com.codeShuttleCourse.week21.dtoandJpa.dto.EmployeeDto;
import com.codeShuttleCourse.week21.dtoandJpa.entities.EmployeeEntity;
import com.codeShuttleCourse.week21.dtoandJpa.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private final  EmployeeRepository employeeRepository;

    @GetMapping("/{employeeID}")
    public EmployeeEntity getEmployeeById(@PathVariable(name="employeeID")  Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping("/getAll")
    public List<EmployeeEntity> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee){

        return employeeRepository.save(employee);

    }
}
