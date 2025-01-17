package glmm.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import glmm.database.dao.StudentDAO;
import glmm.database.entity.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class StudentRestController 
{
    private StudentDAO studentDAO;

    public StudentRestController(StudentDAO studentDAO)
    {
        this.studentDAO = studentDAO;
    }

    @GetMapping("/students")
    public List<Student> getStudents() 
    {
        return this.studentDAO.findAll();
    } 

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) 
    {
        return this.studentDAO.findById(id);
    }
}
