package glmm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import glmm.database.dao.IEmployeeDAO;
import glmm.database.entity.Employee;
import jakarta.transaction.Transactional;


@Service
public class EmployeeService implements IEmployeeService 
{
    private IEmployeeDAO employeeDAO;

    public EmployeeService(IEmployeeDAO employeeDAO)
    {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() 
    {
        return this.employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) 
    {
        return this.employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) 
    {
        this.employeeDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) 
    {
        return this.employeeDAO.save(employee);
    }
}
