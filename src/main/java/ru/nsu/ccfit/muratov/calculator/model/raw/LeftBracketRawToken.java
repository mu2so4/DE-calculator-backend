package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;
import ru.nsu.ccfit.muratov.calculator.model.operator.LeftBracketOperator;

import java.util.List;

public class LeftBracketRawToken implements RawToken {
    private final ExpressionToken leftBracket = new LeftBracketOperator();

    @Override
    public ExpressionToken convert(List<ExpressionToken> context, int position) {
        return leftBracket;
    }
}
