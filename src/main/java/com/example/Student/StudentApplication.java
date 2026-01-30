package com.example.Student;

import com.example.Student.model.Student;
import com.example.Student.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(StudentApplication.class, args);
		StudentService service = context.getBean(StudentService.class);
		System.out.println("Adding Student:");
		service.addStudent(new Student(1,"Hema",20,"Java"));
		service.addStudent(new Student(2,"Iniya",20,"Java"));
		service.addStudent(new Student(3,"Rithu",20,"C++"));

		System.out.println("Get all student:");
		System.out.println(service.getAllStudents());

		System.out.println("Get by Id:");
		System.out.println(service.getStudentById(1));

		System.out.println("Update Student:");
		service.updateStudent(1,new Student(0,"Hema update",23,"Spring"));
		System.out.println(service.getStudentById(1));

		System.out.println("Delete student:");
		service.deleteStudent(2);

		System.out.println("All student after delete:");
		System.out.println(service.getAllStudents());

	}

}
