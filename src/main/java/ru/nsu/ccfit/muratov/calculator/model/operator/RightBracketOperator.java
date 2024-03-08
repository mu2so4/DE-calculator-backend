package ru.nsu.ccfit.muratov.calculator.model.operator;

import java.util.List;

public class RightBracketOperator extends Operator {
    @Override
    protected double performEvaluation(List<Double> values) throws OperatorException {
        return 0;
    }

    @Override
    public int getProperOperandCount() {
        return 0;
    }

    @Override
    public Priority getPriority() {
        return Priority.BRACKET;
    }
}
