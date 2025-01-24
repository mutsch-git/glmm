package glmm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import glmm.database.entity.Employee;
import glmm.database.repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService 
{
    private IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() 
    {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) 
    {
        Optional<Employee> result = this.employeeRepository.findById(id);

        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Employee not found, id - " + id);
        }

        return employee;
    }

    @Override
    //@Transactional --> no need -> Jpa handles it
    public void deleteById(int id) 
    {
        this.employeeRepository.deleteById(id);
    }

    @Override
    //@Transactional --> no need -> Jpa handles it
    public Employee save(Employee employee) 
    {
        return this.employeeRepository.save(employee);
    }
}
