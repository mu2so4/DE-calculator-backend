package ru.nsu.ccfit.muratov.calculator.model.operator;

import java.util.List;

public class NumberToken extends ExpressionToken {
    private final double value;

    public NumberToken(double value) {
        this.value = value;
    }

    @Override
    public final Priority getPriority() {
        return Priority.NUMBER;
    }

    public final double getValue() {
        return value;
    }
}
