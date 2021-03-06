package com.prueba.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//Class where you can create a controllable exceptions if the responseBody is incomplete or the client not exists.
public class ControlErrors {

	@ResponseBody
	@ExceptionHandler(ErrorMessageClient.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
			String errorMessageClient(ErrorMessageClient em) {
			
		return em.getMessage();
	}
}
