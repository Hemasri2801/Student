package com.example.Student.service;
import com.example.Student.model.Student;
import com.example.Student.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;


    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Student updateStudent(int id, Student student) {
        Student s = repository.findById(id).orElse(null);
        if (s != null) {
            s.setName(student.getName());
            s.setAge(student.getAge());
            s.setCourse(student.getCourse());
            return repository.save(s);
        }
        return null;
    }

    public Student patchStudentCourse(int id, String course) {
        Student s = repository.findById(id).orElse(null);
        if (s != null) {
            s.setCourse(course);
            return repository.save(s);
        }
        return null;
    }

    public String deleteStudent(int id) {
        repository.deleteById(id);
        return "Student deleted";
    }

}
