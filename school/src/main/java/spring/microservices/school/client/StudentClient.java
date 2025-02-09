package spring.microservices.school.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import spring.microservices.school.model.response.StudentResponse;

import java.util.List;

@FeignClient(name = "student-service",
             url = "${application.config.student-url}")
public interface StudentClient {

    @GetMapping("/school/{school-id}")
    List<StudentResponse> getAllStudentBySchool(@PathVariable("school-id") Integer schoolId);

}
