package com.app.main.exception;

import lombok.Data;

@Data
public class ItemServiceException extends RuntimeException{
	
	private String errorCode;
	
	public ItemServiceException(String message,String errorCode) {
		super(message);
		this.errorCode=errorCode;
	}

}
