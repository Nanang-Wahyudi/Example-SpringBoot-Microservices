package spring.microservices.school.service;

import spring.microservices.school.entity.School;
import spring.microservices.school.model.response.SchoolDetailResponse;

import java.util.List;

public interface SchoolService {

    List<School> getAllSchool();

    School getSchoolById(Integer schoolId);

    SchoolDetailResponse getSchoolDetail(Integer schoolId);

    void createSchool(School school);

}
