package ru.nsu.ccfit.muratov.calculator.model.operator;

import java.util.List;

public abstract class Operator extends ExpressionToken {
    public final double evaluate(List<Double> values) throws OperatorException {
        //check if we got proper count of operands for some action
        if(values.size() != getProperOperandCount()) {
            throw new IllegalArgumentException(
                    String.format("expected %d operands, got %d", getProperOperandCount(), values.size())
            );
        }
        return performEvaluation(values);
    }

    protected abstract double performEvaluation(List<Double> values) throws OperatorException;

    public abstract int getProperOperandCount();
}
