package glmm.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import glmm.database.dao.StudentDAO;
import glmm.database.entity.Student;
import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class StudentRestController 
{
    private StudentDAO studentDAO;
    private List<Student> students;

    public StudentRestController(StudentDAO studentDAO)
    {
        this.studentDAO = studentDAO;
    }

    @PostConstruct
    public void loadStudents()
    {
        this.students = this.studentDAO.findAll();
    }

    @GetMapping("/students")
    public List<Student> getStudents() 
    {
        return this.students;
    } 

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) 
    {
        return this.studentDAO.findById(id);
    }
}
