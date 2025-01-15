package glmm.database.dao;

import java.util.List;
import glmm.database.entity.Student;

public interface StudentDAO 
{
    void save(Student student);

    Student findById(int id);

    List<Student> findAll();
}
