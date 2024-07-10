package spring.microservices.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.microservices.student.entity.Student;
import spring.microservices.student.model.response.StudentDetailResponse;
import spring.microservices.student.service.StudentService;

import java.util.List;

@RequestMapping("/api")
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/v1/student")
    public ResponseEntity<?> getAllStudent() {
        List<Student> students = studentService.getAllStudent();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/v1/student/school/{school-id}")
    public ResponseEntity<?> getAllStudentBySchool(@PathVariable("school-id") Integer schoolId) {
        List<Student> students = studentService.getAllStudentBySchool(schoolId);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/v1/student/detail/{student-id}")
    public ResponseEntity<?> getStudentDetail(@PathVariable("student-id") Integer studentId) {
        StudentDetailResponse response = studentService.getStudentDetail(studentId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/v1/student/create")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok("Create Student Successfully");
    }

}
