package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.Expression;
import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;
import ru.nsu.ccfit.muratov.calculator.model.operator.PlusOperator;

public class PlusRawToken implements RawToken {
    private final PlusOperator operator = new PlusOperator();


    @Override
    public ExpressionToken convert(Expression context, int position) {
        return operator;
    }
}
