package com.springboot.learn.api;

import com.springboot.learn.exception.ApplicationError;
import com.springboot.learn.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @Value("${my_api_url}")
    private  String details;
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApplicationError>
    handnleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest webRequest){
    ApplicationError applicationError=new ApplicationError();
    applicationError.setErrorCode(101);
    applicationError.setErrorMessage(ex.getMessage());
    applicationError.setDetails(details);
    return  new ResponseEntity<>(applicationError, HttpStatus.NOT_FOUND);
    }
}
