package spring.microservices.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.microservices.school.entity.School;
import spring.microservices.school.model.response.SchoolDetailResponse;
import spring.microservices.school.service.SchoolService;

import java.util.List;

@RequestMapping("/api")
@RestController
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("/v1/school")
    public ResponseEntity<?> getAllSchool() {
       List<School> schools = schoolService.getAllSchool();
       return ResponseEntity.ok(schools);
    }

    @GetMapping("/v1/school/{school-id}")
    public ResponseEntity<?> getSchoolById(@PathVariable("school-id") Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return ResponseEntity.ok(school);
    }

    @GetMapping("/v1/school/detail/{school-id}")
    public ResponseEntity<?> getSchoolDetail(@PathVariable("school-id") Integer schoolId) {
        SchoolDetailResponse response = schoolService.getSchoolDetail(schoolId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/v1/school/create")
    public ResponseEntity<?> createSchool(@RequestBody School school) {
        schoolService.createSchool(school);
        return ResponseEntity.ok("Create School Successfully");
    }

}
