package spring.microservices.student.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import spring.microservices.student.model.response.ErrorResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ResponseStatusException.class)
    protected ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex, WebRequest request) {
        List<String> details = new ArrayList<>();

        String message = ex.getReason();
        if (message != null) {
            details.add(message);
        } else {
            details.add(ex.getMessage());
        }

        ErrorResponse errorResponse = ErrorResponse.builder()
                .url(request.getDescription(false).replace("uri=", ""))
                .status(ex.getStatusCode().toString())
                .details(details)
                .build();
        errorResponse.setTimestamp(new Date());

        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }

}
