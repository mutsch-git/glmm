package glmm.database.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import glmm.database.entity.Student;
import jakarta.persistence.EntityManager;


@Repository
public class StudentDAOImpl implements StudentDAO
{
    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) 
    {
        this.entityManager.persist(student);
    }
}
