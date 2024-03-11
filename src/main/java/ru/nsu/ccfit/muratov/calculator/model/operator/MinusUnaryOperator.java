package ru.nsu.ccfit.muratov.calculator.model.operator;

import java.util.List;

public class MinusUnaryOperator extends Operator {
    @Override
    public Priority getPriority() {
        return Priority.UNARY;
    }

    @Override
    protected double performEvaluation(List<Double> values) {
        return -values.get(0);
    }

    @Override
    public int getProperOperandCount() {
        return 1;
    }
}
