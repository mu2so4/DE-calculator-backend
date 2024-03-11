package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;
import ru.nsu.ccfit.muratov.calculator.model.operator.MultiplyOperator;

import java.util.List;

public class MultiplyRawToken implements RawToken {
    private final ExpressionToken multiply = new MultiplyOperator();
    @Override
    public ExpressionToken convert(List<ExpressionToken> context, int position) {
        return multiply;
    }
}
