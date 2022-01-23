package com.spring.crud.Service;

import java.util.List;

import com.spring.crud.Dao.EmpRepo;
import com.spring.crud.Model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
    
    @Autowired
    private EmpRepo empRepo;

    public void save(Employee employee){
        this.empRepo.save(employee);
    }

    public List<Employee> getAllEmployee(){
        List<Employee> list=this.empRepo.findAll();
        return list;
    }

    public Employee findContact(int id){
        return this.empRepo.findById(id).get();
    }

    public void deleteEmployee(int id){
        this.empRepo.deleteById(id);
    }

}
