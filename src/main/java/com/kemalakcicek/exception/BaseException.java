package com.kemalakcicek.exception;

public class BaseException extends RuntimeException {

	public BaseException(ErrorMessage errorMessage) {
		super(errorMessage.preparedMessage());

	}

}
