package ru.nsu.ccfit.muratov.calculator.model.operator;

import java.util.List;

public class NumberOperator extends Operator {
    private final double value;

    public NumberOperator(double value) {
        this.value = value;
    }

    @Override
    protected final double performEvaluation(List<Double> values) {
        return value;
    }

    @Override
    public final int getProperOperandCount() {
        return 0;
    }

    @Override
    public final Priority getPriority() {
        return Priority.NUMBER;
    }
}
