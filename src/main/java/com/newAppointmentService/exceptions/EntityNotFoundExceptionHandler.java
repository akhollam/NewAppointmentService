package com.newAppointmentService.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.newAppointmentService.model.ErrorResponse;

@ControllerAdvice
public class EntityNotFoundExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException exception) {

		ErrorResponse error = new ErrorResponse();
		error.setErrorMessage(exception.getMessage());

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

}