package glmm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import glmm.database.dao.StudentDAO;
import glmm.database.entity.Student;

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
				System.out.println("trying to save student");
				this.createStudent(studentDAO);	
			};
	}

	private void createStudent(StudentDAO studentDAO)
	{
		Student tmpStudent = new Student("Paul", "Doe", "paul.doe@test.com");

		System.out.println("Save the student");

		studentDAO.save(tmpStudent);

		System.out.println("Student saved, id = " + tmpStudent.getId());
	}
}
