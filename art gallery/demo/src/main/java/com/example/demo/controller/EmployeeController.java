package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.update(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sorted")
    public List<Employee> getsorted()
    {
        return employeeService.getsorted();
    }
    @GetMapping("/paginate/{p}/{s}")
    public Page<Employee> getP(@PathVariable int p,@PathVariable int s){
        return employeeService.getP(p,s);
    }
    @GetMapping("/ename/{name}")
    public List<Employee> getN(@PathVariable String name){
        return employeeService.getN(name);
    }



//     @GetMapping("/paginated")
// public Page<Employee> getAllPaginated(@RequestParam(defaultValue = "0") int page,
//                                       @RequestParam(defaultValue = "5") int size) {
//     return employeeService.getAllEmployees(page, size);
// }

}
