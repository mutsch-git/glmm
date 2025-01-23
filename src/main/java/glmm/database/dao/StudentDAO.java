package glmm.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import glmm.database.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class StudentDAO implements IStudentDAO
{
    private EntityManager entityManager;

    public StudentDAO(EntityManager entityManager)
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
    public Student findById(int id)
    {
        return this.entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll()
    {
        TypedQuery<Student> query = this.entityManager.createQuery("from Student order by lastName", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) 
    {
        
        TypedQuery<Student> query = this.entityManager.createQuery("from Student where lastName=:lastname", Student.class);
        query.setParameter("lastname", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) 
    {
        this.entityManager.merge(student);    
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student student = this.findById(id);

        if (student != null) {
            this.entityManager.remove(student);
        }
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = this.entityManager.createQuery("delete from Student").executeUpdate();
        return numRowsDeleted;
    }    
}
