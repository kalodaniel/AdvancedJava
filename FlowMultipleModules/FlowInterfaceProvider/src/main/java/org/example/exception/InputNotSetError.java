package org.example.exception;

public class InputNotSetError extends RuntimeException{
    public InputNotSetError(){
        super("Input not set!");
    }
}
