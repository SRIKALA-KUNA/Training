package com.epam.engx.cleancode.comments.task1.thirdpartyjar;

public class InvalidInputException extends RuntimeException{
    String message;
    public InvalidInputException(String message) {
        super();
        this.message = message;

    }

    @Override
    public String getMessage() {
        return message;
    }

}
