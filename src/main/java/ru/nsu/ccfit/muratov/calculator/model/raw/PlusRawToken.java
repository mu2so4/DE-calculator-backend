package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;
import ru.nsu.ccfit.muratov.calculator.model.operator.PlusOperator;

import java.util.List;

public class PlusRawToken implements RawToken {
    private final PlusOperator operator = new PlusOperator();


    @Override
    public ExpressionToken convert(List<ExpressionToken> context, int position) {
        return operator;
    }
}
