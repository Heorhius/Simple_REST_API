package com.kaptsiug.exception;

public class IllegalIDException extends Exception {
    public IllegalIDException() {
        super();
    }

    public IllegalIDException(String message) {
        System.out.println(message);
    }
}
