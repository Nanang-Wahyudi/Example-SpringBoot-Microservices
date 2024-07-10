package spring.microservices.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import spring.microservices.school.client.StudentClient;
import spring.microservices.school.entity.School;
import spring.microservices.school.model.response.SchoolDetailResponse;
import spring.microservices.school.model.response.StudentResponse;
import spring.microservices.school.repository.SchoolRepository;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<School> getAllSchool() {
        return schoolRepository.findAll();
    }

    @Override
    public School getSchoolById(Integer schoolId) {
        return schoolRepository.findById(schoolId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "School with ID '" + schoolId + "' not found"));
    }

    @Override
    public SchoolDetailResponse getSchoolDetail(Integer schoolId) {
        School school = this.getSchoolById(schoolId);

        List<StudentResponse> students = studentClient.getAllStudentBySchool(schoolId);

        return SchoolDetailResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }

    @Override
    public void createSchool(School school) {
        schoolRepository.save(school);
    }

}
