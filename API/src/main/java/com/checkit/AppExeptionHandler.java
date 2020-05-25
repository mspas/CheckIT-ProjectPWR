package com.checkit;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.checkit.response.entity.ErrorMessage;

@ControllerAdvice
public class AppExeptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyExeption(Exception ex, WebRequest request) {

		String errorMesStringDescription = ex.getLocalizedMessage();

		if (errorMesStringDescription == null)
			errorMesStringDescription = ex.toString();

		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMesStringDescription);

		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
	}

}
