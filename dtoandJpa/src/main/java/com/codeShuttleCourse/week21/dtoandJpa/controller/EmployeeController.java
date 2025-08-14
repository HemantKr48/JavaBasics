package com.codeShuttleCourse.week21.dtoandJpa.controller;


import com.codeShuttleCourse.week21.dtoandJpa.dto.EmployeeDto;
import com.codeShuttleCourse.week21.dtoandJpa.entities.EmployeeEntity;
import com.codeShuttleCourse.week21.dtoandJpa.repositories.EmployeeRepository;
import com.codeShuttleCourse.week21.dtoandJpa.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    public EmployeeController(EmployeeRepository employeeRepository,EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService=employeeService;
    }

    private final  EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    @GetMapping("/{employeeID}")
    public EmployeeDto getEmployeeById(@PathVariable(name="employeeID")  Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getAll")
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employee){

        return employeeService.createEmployee(employee);

    }
}
