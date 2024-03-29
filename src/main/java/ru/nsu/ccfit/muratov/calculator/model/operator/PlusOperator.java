package ru.nsu.ccfit.muratov.calculator.model.operator;

import java.util.List;

public class PlusOperator extends Operator {
    @Override
    protected double performEvaluation(List<Double> values) {
        return values.get(0) + values.get(1);
    }

    @Override
    public int getProperOperandCount() {
        return 2;
    }

    @Override
    public Priority getPriority() {
        return Priority.ADD;
    }
}
