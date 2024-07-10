package spring.microservices.school.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchoolDetailResponse {

    private String name;

    private String email;

    private List<StudentResponse> students;

}
