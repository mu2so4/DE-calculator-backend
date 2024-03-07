package ru.nsu.ccfit.muratov.calculator.model.operator;

public class DivisionByZeroException extends OperatorException {
    public DivisionByZeroException() {
        super();
    }


    public DivisionByZeroException(String message) {
        super(message);
    }


    public DivisionByZeroException(Throwable cause) {
        super(cause);
    }
}
