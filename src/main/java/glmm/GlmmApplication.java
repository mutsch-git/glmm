package glmm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import glmm.database.dao.StudentDAO;
import glmm.database.entity.Student;

import java.util.List;;

@SpringBootApplication
public class GlmmApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(GlmmApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		 	 return runner -> {
				System.out.println("delete student with id 1");
				this.deleteStudent(1, studentDAO);
			};
	}

	private void createStudent(StudentDAO studentDAO)
	{
		Student tmpStudent = new Student("Hank", "Hazzard", "hank.hazzard@test.com");

		System.out.println("Save the student");

		studentDAO.save(tmpStudent);

		System.out.println("Student saved, id = " + tmpStudent.getId());

		System.out.println("Read the student from DB: " + studentDAO.findById(tmpStudent.getId()));
	}

	private void getAllStudents(StudentDAO studentDAO) 
	{
		List<Student> students = studentDAO.findAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void getStudentByLastName(String lastName, StudentDAO studentDAO)
	{
		List<Student> students = studentDAO.findByLastName(lastName);

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDAO studentDAO)
	{
		Student student = studentDAO.findById(2);
		student.setFirstName("Henry");
		studentDAO.update(student);

		System.out.println(studentDAO.findById(2));
	}

	private void deleteStudent(int id, StudentDAO studentDAO)
	{
		studentDAO.delete(id);
	}
}
