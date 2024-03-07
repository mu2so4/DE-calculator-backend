package ru.nsu.ccfit.muratov.calculator.model.operator;

import java.util.List;

public class PowerOperator extends Operator {
    @Override
    protected double performEvaluation(List<Double> values) throws OperatorException {
        double base = values.get(0);
        double exponent = values.get(1);
        return Math.pow(base, exponent);
    }

    @Override
    public int getProperOperandCount() {
        return 2;
    }
}
