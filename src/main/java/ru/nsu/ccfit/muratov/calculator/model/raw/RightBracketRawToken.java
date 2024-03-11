package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.Expression;
import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;
import ru.nsu.ccfit.muratov.calculator.model.operator.RightBracketOperator;

public class RightBracketRawToken implements RawToken {
    private final ExpressionToken rightBracket = new RightBracketOperator();

    @Override
    public ExpressionToken convert(Expression context, int position) {
        return rightBracket;
    }
}
