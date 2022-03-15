package com.revature.exception;

public class AcctNotFoundException extends Exception{

    public AcctNotFoundException() {
    }

    public AcctNotFoundException(String message) {
        super(message);
    }
}
