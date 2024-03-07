package ru.nsu.ccfit.muratov.calculator.model.operator;

import java.util.List;

public class DivideOperator extends Operator {
    private static final double TOLERANCE = 0.00000001;

    @Override
    protected double performEvaluation(List<Double> values) throws DivisionByZeroException {
        double numerator = values.get(0);
        double denominator = values.get(1);
        if(Math.abs(denominator) < TOLERANCE) {
            throw new DivisionByZeroException();
        }
        return numerator / denominator;
    }

    @Override
    public int getProperOperandCount() {
        return 2;
    }
}
