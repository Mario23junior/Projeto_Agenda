package com.project.agenda.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.project.agenda.Exception.DuplicateBusinessRule;

@RestControllerAdvice
public class ControllerAdviceErros {
  	
	@ExceptionHandler(DuplicateBusinessRule.class)
 	public ErroResponse NotValueDuplicate(DuplicateBusinessRule ex, WebRequest request) {
		 ErroResponse message = new ErroResponse(
			HttpStatus.NO_CONTENT.value(),
			new Date(),
			ex.getMessage(),
			request.getDescription(false));
		 
		 return message;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErroResponse ErroResponse (Exception ex, WebRequest request) {
		ErroResponse erroGlobal = new ErroResponse(
				
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		
		return erroGlobal;
	}
}
