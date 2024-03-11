package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.operator.DivideOperator;
import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;

import java.util.List;

public class DivideRawToken implements RawToken {
    ExpressionToken divide = new DivideOperator();

    @Override
    public ExpressionToken convert(List<ExpressionToken> context, int position) {
        return divide;
    }
}
