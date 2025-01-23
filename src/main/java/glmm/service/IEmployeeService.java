package glmm.service;

import java.util.List;

import glmm.database.entity.Employee;

public interface IEmployeeService 
{
    List<Employee> findAll();    

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
