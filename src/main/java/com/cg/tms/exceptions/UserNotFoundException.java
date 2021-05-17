package com.cg.tms.exceptions;

public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(String msg)
	{
		super(msg);
	}

}
