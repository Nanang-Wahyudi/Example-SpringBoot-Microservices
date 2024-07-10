package spring.microservices.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import spring.microservices.student.client.SchoolClient;
import spring.microservices.student.entity.Student;
import spring.microservices.student.model.response.SchoolResponse;
import spring.microservices.student.model.response.StudentDetailResponse;
import spring.microservices.student.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolClient schoolClient;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getAllStudentBySchool(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }

    @Override
    public StudentDetailResponse getStudentDetail(Integer studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with ID '" + studentId + "' not found"));

        SchoolResponse school = schoolClient.getSchoolById(student.getSchoolId());

        return StudentDetailResponse.builder()
                .firstname(student.getFirstname())
                .lastname(student.getLastname())
                .email(student.getEmail())
                .school(school)
                .build();
    }

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

}
