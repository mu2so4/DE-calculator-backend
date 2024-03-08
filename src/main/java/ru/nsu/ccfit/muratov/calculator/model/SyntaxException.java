package ru.nsu.ccfit.muratov.calculator.model;

public class SyntaxException extends Exception {
    public SyntaxException() {
        super();
    }


    public SyntaxException(String message) {
        super(message);
    }


    public SyntaxException(Throwable cause) {
        super(cause);
    }
}
