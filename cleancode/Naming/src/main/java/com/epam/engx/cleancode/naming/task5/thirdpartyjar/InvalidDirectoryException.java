package com.epam.engx.cleancode.naming.task5.thirdpartyjar;

public class InvalidDirectoryException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
    public InvalidDirectoryException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
