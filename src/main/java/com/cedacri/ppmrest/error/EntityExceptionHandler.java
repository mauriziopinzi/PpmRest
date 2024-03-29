package com.cedacri.ppmrest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class EntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CedacriException.class)
    public final ResponseEntity<ErrorDetail> handleUserNotFoundException(CedacriException ex, WebRequest request) {
        ErrorDetail error = new ErrorDetail(ex);
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<ErrorDetail> handleUserNotFoundException(IllegalArgumentException ex, WebRequest request) {
        ErroreGenericoException ex2 = new ErroreGenericoException();
        ErrorDetail error = new ErrorDetail(ex2);
        return new ResponseEntity<>(error, ex2.getHttpStatus());
    }


}
