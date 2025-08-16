package com.codeShuttleCourse.week21.dtoandJpa.controller;


import com.codeShuttleCourse.week21.dtoandJpa.dto.EmployeeDto;
import com.codeShuttleCourse.week21.dtoandJpa.entities.EmployeeEntity;
import com.codeShuttleCourse.week21.dtoandJpa.repositories.EmployeeRepository;
import com.codeShuttleCourse.week21.dtoandJpa.services.EmployeeService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name="employeeID")  Long id){
        EmployeeDto employee=employeeService.getEmployeeById(id);
        if(employee==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(employee);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
       List<EmployeeDto> employee=  employeeService.getAllEmployees();
       if(employee==null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }

       return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody @Valid  EmployeeDto employee){

        EmployeeDto savedEmployee= employeeService.createEmployee(employee);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedEmployee);

    }
}
