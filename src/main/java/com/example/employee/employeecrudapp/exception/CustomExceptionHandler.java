// package com.example.employee.employeecrudapp.exception;

// import java.util.ArrayList;
// import java.util.List;

// import com.example.employee.employeecrudapp.entities.ErrorResponse;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.context.request.WebRequest;
// import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// @ControllerAdvice
// public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
//     @ExceptionHandler(Exception.class)
//     public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
//         List<String> details = new ArrayList<>();
//         details.add(ex.getLocalizedMessage());
//         ErrorResponse error = new ErrorResponse("Server Error", details);
//         return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
//     }

//     @ExceptionHandler(RecordNotFoundException.class)
//     public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException ex,
//             WebRequest request) {
//         List<String> details = new ArrayList<>();
//         details.add(ex.getLocalizedMessage());
//         ErrorResponse error = new ErrorResponse("Record Not Found", details);
//         return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
//     }
// }