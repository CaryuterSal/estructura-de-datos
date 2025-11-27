package dev.utez.errorhandlerdemo.Controller;


import dev.utez.errorhandlerdemo.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralErrorHandleController {

    @ExceptionHandler(Exception.class)

    public ResponseEntity<?> generalErrorHandler(Exception e){

        ErrorResponse error = new ErrorResponse();
        error.setError("Error general de spring");
        error.setDetail(e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

}