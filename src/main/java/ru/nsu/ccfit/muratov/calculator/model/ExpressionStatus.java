package ru.nsu.ccfit.muratov.calculator.model;

public enum ExpressionStatus {
    OK("ok"),
    SYNTAX_ERROR("syntax error"),
    DIVISION_BY_ZERO("division by zero"),
    NAN("NaN"),
    INFINITY("infinity");

    private final String message;

    ExpressionStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
