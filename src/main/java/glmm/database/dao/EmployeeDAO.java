package glmm.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import glmm.database.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAO implements IEmployeeDAO
{
    private EntityManager entityManager;

    public EmployeeDAO(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() 
    {
        TypedQuery<Employee> query = this.entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(int id) 
    {
        Employee employee = this.findById(id);

        if (employee != null) {
            this.entityManager.remove(employee);
        }
    }

    @Override
    public Employee findById(int id) 
    {
        return this.entityManager.find(Employee.class, id);    
    }

    @Override
    public Employee save(Employee employee) 
    {
        return this.entityManager.merge(employee);    
    }     
}
