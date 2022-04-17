package com.newAppointmentService.exceptions;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.newAppointmentService.model.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class DataAccessExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<ErrorResponse> handleCityNotFoundException(DataAccessException ex) {

		ErrorResponse re = new ErrorResponse();
		re.setErrorMessage(ex.getMessage());

		log.error("DataAccessException occured ", ex);
		return new ResponseEntity<>(re, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}