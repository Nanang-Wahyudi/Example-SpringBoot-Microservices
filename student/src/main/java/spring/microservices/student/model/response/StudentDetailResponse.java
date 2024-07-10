package spring.microservices.student.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDetailResponse {

    private String firstname;

    private String lastname;

    private String email;

    private SchoolResponse school;

}
