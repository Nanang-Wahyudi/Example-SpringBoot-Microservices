package spring.microservices.student.service;

import spring.microservices.student.entity.Student;
import spring.microservices.student.model.response.StudentDetailResponse;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();

    List<Student> getAllStudentBySchool(Integer schoolId);

    StudentDetailResponse getStudentDetail(Integer studentId);

    void createStudent(Student student);

}
