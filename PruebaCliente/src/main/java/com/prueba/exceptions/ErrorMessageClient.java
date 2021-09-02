package com.prueba.exceptions;

//Class where you create a message of the exception.
public class ErrorMessageClient extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ErrorMessageClient(Long id) {
		super("Client Not Found or not Exist!, id: " + id);
	}
}
