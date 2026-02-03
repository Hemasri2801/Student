package com.example.Student.controller;

import com.example.Student.model.Student;
import com.example.Student.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        return service.getStudentById(id);
    }
    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable int id,@RequestBody Student student){
        return service.updateStudent(id,student);
    }
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id){
        return service.deleteStudent(id);
    }
    @PatchMapping("/student/{id}/course")
    public Student updateCourse(@PathVariable int id,@RequestBody Student student){
        return service.patchStudentCourse(id, student.getCourse());
    }
}
