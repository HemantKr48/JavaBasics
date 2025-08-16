package com.codeShuttleCourse.week21.dtoandJpa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Long id;
    @NotBlank(message = "Employee name can not be blank")
    private String name;
    private String address;
    @Max(value = 45,message = "Employee age can not be greater than 45")
    @Min(value=4,message="Employee age can not be less than 4")
    private Integer age;
    @Email(message="Employee email is not in the right format")
    private String email;
    private LocalDate date;
    private Boolean isActive;


}
