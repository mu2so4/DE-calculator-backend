package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;
import ru.nsu.ccfit.muratov.calculator.model.operator.RightBracketOperator;

import java.util.List;

public class RightBracketRawToken implements RawToken {
    private final ExpressionToken rightBracket = new RightBracketOperator();

    @Override
    public ExpressionToken convert(List<ExpressionToken> context, int position) {
        return rightBracket;
    }
}
