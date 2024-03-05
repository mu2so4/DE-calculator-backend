package ru.nsu.ccfit.muratov.calculator.model.operator;

public class Plus extends Operator {
    @Override
    protected double performEvaluation(double[] values) {
        return values[0] + values[1];
    }

    @Override
    public int getOperandCount() {
        return 2;
    }
}
