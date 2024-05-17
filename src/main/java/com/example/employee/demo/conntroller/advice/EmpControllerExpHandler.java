package com.example.employee.demo.conntroller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.employee.demo.exception.EmployeeNotFoundException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmpControllerExpHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> empNotFound(EmployeeNotFoundException exp){
		log.error("Employee not found, err is {}",exp);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Not Found");
	}
}
