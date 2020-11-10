package com.kafka.producer.exception;

public class InternalServerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private int errorCode;

	
	public InternalServerException(Throwable errorMessage,String errorCode ) {
		super(errorCode,errorMessage);
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public int getErrorCode() {
		return errorCode;
	}
}
