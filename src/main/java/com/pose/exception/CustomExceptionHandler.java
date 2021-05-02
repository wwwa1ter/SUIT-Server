package com.pose.exception;

import com.pose.exception.guidance.GuidanceNotFoundException;
import com.pose.exception.guidance.HtmlNotFoundException;
import com.pose.exception.plan.AddFailException;
import com.pose.exception.plan.GeneratePlanFailException;
import com.pose.exception.plan.ReportNotFoundException;
import com.pose.exception.plan.UpdatePlanException;
import com.pose.exception.user.LoginFailException;
import com.pose.exception.user.RegisterFailException;
import com.pose.utils.ServerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class CustomExceptionHandler{

    @ExceptionHandler({LoginFailException.class, RegisterFailException.class})
    public ResponseEntity<ServerResponse> handleUserException(Exception e){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (e instanceof LoginFailException){
            status = HttpStatus.UNAUTHORIZED;
        }else if (e instanceof RegisterFailException){
            status = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(new ServerResponse(e.getMessage()), status);
    }

    @ExceptionHandler({UpdatePlanException.class, AddFailException.class, GeneratePlanFailException.class, ReportNotFoundException.class})
    public ResponseEntity<ServerResponse> handlePlanException(Exception e){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (e instanceof UpdatePlanException){
            status = HttpStatus.NOT_ACCEPTABLE;
        }else if (e instanceof AddFailException || e instanceof GeneratePlanFailException){
            status = HttpStatus.NOT_ACCEPTABLE;
        }else if (e instanceof ReportNotFoundException){
            status = HttpStatus.PRECONDITION_FAILED;
        }
        return new ResponseEntity<>(new ServerResponse(e.getMessage()), status);
    }

    @ExceptionHandler({GuidanceNotFoundException.class, HtmlNotFoundException.class})
    public ResponseEntity<ServerResponse> handleGuidanceException(Exception e){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (e instanceof GuidanceNotFoundException || e instanceof HtmlNotFoundException){
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(new ServerResponse(e.getMessage()), status);
    }
    
}
