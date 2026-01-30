package com.example.Student.service;
import com.example.Student.model.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();

    public Student addStudent(Student stu) {
        students.add(stu);
        return stu;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id){
                return s;
        }
    }
    return null;
}
public String deleteStudent(int id){
    students.removeIf(s->s.getId()==id);
    return "Student deleted";
}

    public Student updateStudent(int id, Student updateStudent) {
        for (Student s:students){
            if(s.getId()==id){
                s.setName(updateStudent.getName());
                s.setAge(updateStudent.getAge());
                s.setCourse(updateStudent.getCourse());
                return s;
            }
        }
        return null;
    }
}
