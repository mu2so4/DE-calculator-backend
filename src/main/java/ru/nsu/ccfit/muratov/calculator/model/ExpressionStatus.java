package ru.nsu.ccfit.muratov.calculator.model;

public enum ExpressionStatus {
    INVALID_FIRST(0),
    FIRST(1),
    OK(1),
    SYNTAX_ERROR(2),
    DIVISION_BY_ZERO(3),
    NAN(4),
    LAST(5);

    private int value;

    ExpressionStatus(int value) {
        this.value = value;
    }
}
