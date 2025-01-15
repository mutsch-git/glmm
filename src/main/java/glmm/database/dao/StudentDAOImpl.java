package glmm.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import glmm.database.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


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

    @Override
    @Transactional
    public Student findById(int id)
    {
        return this.entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public List<Student> findAll()
    {
        TypedQuery<Student> query = this.entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }
}
