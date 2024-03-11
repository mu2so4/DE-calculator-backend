package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.Expression;
import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;
import ru.nsu.ccfit.muratov.calculator.model.operator.LeftBracketOperator;

public class LeftBracketRawToken implements RawToken {
    private final ExpressionToken leftBracket = new LeftBracketOperator();

    @Override
    public ExpressionToken convert(Expression context, int position) {
        return leftBracket;
    }
}
