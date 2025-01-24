package glmm.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import glmm.database.dao.IEmployeeDAO;
import glmm.database.entity.Employee;
import glmm.service.IEmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class EmployeeRestController 
{
    private IEmployeeService employeeService;
    
    public EmployeeRestController(IEmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees()
    {
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id)
    {
        Employee employee = this.employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee id not found: " + id);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) 
    {
        employee.setId(0);
        
        return this.employeeService.save(employee);
    }
    
}
