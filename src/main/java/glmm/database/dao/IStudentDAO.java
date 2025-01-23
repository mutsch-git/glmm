package glmm.database.dao;

import java.util.List;
import glmm.database.entity.Student;

public interface IStudentDAO 
{
    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(int id);

    int deleteAll();
}
