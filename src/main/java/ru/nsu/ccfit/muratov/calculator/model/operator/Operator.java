package ru.nsu.ccfit.muratov.calculator.model.operator;

import ru.nsu.ccfit.muratov.calculator.model.Context;

public abstract class Operator {
    public final double evaluate(double[] values) {
        //check if we got proper count of operands for some action
        if(values.length != getOperandCount()) {
            throw new IllegalArgumentException(
                String.format("expected %d operands, got %d", getOperandCount(), values.length)
            );
        }
        return performEvaluation(values);
    }

    protected abstract double performEvaluation(double[] values);

    public abstract int getOperandCount();
}
