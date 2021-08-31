package com.prueba.exceptions;

public class ErrorMessageClient extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ErrorMessageClient(Long id) {
		super("Client Not Found or not Exist!, id: " + id);
	}
}
