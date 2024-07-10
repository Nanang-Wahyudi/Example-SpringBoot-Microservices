package spring.microservices.school.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentResponse {

    private String firstname;

    private String lastname;

    private String email;

}
