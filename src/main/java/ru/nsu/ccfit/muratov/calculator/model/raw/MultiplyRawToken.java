package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.Expression;
import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;
import ru.nsu.ccfit.muratov.calculator.model.operator.MultiplyOperator;

public class MultiplyRawToken implements RawToken {
    private final ExpressionToken multiply = new MultiplyOperator();
    @Override
    public ExpressionToken convert(Expression context, int position) {
        return multiply;
    }
}
