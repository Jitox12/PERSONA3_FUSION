package com.example.FusionPersona.exception;

import com.example.FusionPersona.exception.exceptions.BadRequestException;
import com.example.FusionPersona.exception.exceptions.ConflictException;
import com.example.FusionPersona.exception.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({
            NotFoundException.class
    })
    @ResponseBody
    public ResponseEntity<ApiException> notFoundException(Exception e) {
        List<String> message = new ArrayList<>();
        message.add(e.getMessage());

        ApiException apiException = new ApiException(
                message,
                HttpStatus.NOT_FOUND);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiException);
    }

    @ExceptionHandler({
            BadRequestException.class,
            org.springframework.web.HttpRequestMethodNotSupportedException.class,
            org.springframework.web.bind.MissingRequestHeaderException.class,
            java.lang.StringIndexOutOfBoundsException.class,
            org.springframework.web.bind.MissingServletRequestParameterException.class,
            org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class,
            org.springframework.http.converter.HttpMessageNotReadableException.class,
            org.springframework.dao.DataIntegrityViolationException.class,
            org.hibernate.exception.ConstraintViolationException.class
    })
    @ResponseBody
    public ResponseEntity<ApiException> badRequestException(Exception e) {
        List<String> message = new ArrayList<>();
        message.add(e.getMessage());

        ApiException apiException = new ApiException(
                message,
                HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiException);
    }

    @ExceptionHandler({
            org.springframework.web.bind.MethodArgumentNotValidException.class,
    })
    @ResponseBody
    public ResponseEntity<ApiException> argumentException(MethodArgumentNotValidException e) {
        List<String> errorList = new ArrayList<>();

        e.getBindingResult().getAllErrors().forEach((errorBinding) -> {
            errorList.add(errorBinding.getDefaultMessage());
        });

        ApiException apiException = new ApiException(errorList, HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiException);
    }

    @ExceptionHandler({ConflictException.class,
            org.springframework.dao.DuplicateKeyException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ApiException> conflictException(Exception e) {
        List<String> message = new ArrayList<>();
        message.add(e.getMessage());

        ApiException apiException = new ApiException(
                message,
                HttpStatus.CONFLICT);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiException);
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiException> fatalErrorUnexpectedException(Exception e) {
        List<String> message = new ArrayList<>();
        message.add(e.getMessage());

        ApiException apiException = new ApiException(
                message,
                HttpStatus.INTERNAL_SERVER_ERROR);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiException);
    }
}