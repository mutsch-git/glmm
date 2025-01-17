package glmm.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import glmm.database.dao.StudentDAO;
import glmm.database.entity.Student;
import glmm.rest.exception.StudentNotFoundException;
import glmm.rest.response.StudentErrorResponse;
import jakarta.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
        Student student = this.studentDAO.findById(id);

        if (student == null) {
            throw new StudentNotFoundException("Student id " + id + " not found");
        }

        return student;
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)
    {
        StudentErrorResponse error = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());
        
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
