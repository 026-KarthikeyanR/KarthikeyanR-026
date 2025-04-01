package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Repository.EmployeeRepo;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.getById(id);
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
    public List<Employee> getsorted()
    {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC,"employeeName"));
    }
    public Page<Employee>getP(int p,int s){
        Pageable page= PageRequest.of(p,s);
        return employeeRepository.findAll(page);
    }
    public List<Employee> getN(@PathVariable String name){
        return employeeRepository.findByE(name);
    }
    //   Pageable pageable = PageRequest.of(page, size);
    // return employeeRepository.findAll(pageable);
}
