package spring.microservices.student.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import spring.microservices.student.model.response.SchoolResponse;

@FeignClient(name = "school-service",
        url = "${application.config.school-url}")
public interface SchoolClient {

    @GetMapping("/{school-id}")
    SchoolResponse getSchoolById(@PathVariable("school-id") Integer schoolId);

}
