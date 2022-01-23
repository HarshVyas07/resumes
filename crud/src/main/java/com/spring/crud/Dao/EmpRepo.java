package com.spring.crud.Dao;
import com.spring.crud.Model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpRepo extends JpaRepository<Employee, Integer> {
    
}
