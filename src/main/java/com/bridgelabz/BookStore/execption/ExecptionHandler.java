package com.bridgelabz.BookStore.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExecptionHandler {

    //---------------------------Method arguments invalid exception--------------------------//
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> methodArgumentException(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(errors ->{
            errorMap.put(errors.getField(), errors.getDefaultMessage());
        });
        return errorMap;
    }

    //-------------------------Book not found exception-------------------------------------//
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BookNotFoundExecption.class)
    public Map<String, String> handleBusinessException(BookNotFoundExecption e) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Error Message", e.getMessage());
        return errorMap;
    }
}
