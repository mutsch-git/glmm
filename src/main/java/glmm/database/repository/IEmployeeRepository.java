package glmm.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import glmm.database.entity.Employee;

@RepositoryRestResource(path="members")
public interface IEmployeeRepository extends JpaRepository<Employee,Integer>
{
    // add additional methods here
}