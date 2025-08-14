package com.codeShuttleCourse.week21.dtoandJpa.repositories;

import com.codeShuttleCourse.week21.dtoandJpa.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
