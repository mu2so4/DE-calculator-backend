package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.Expression;
import ru.nsu.ccfit.muratov.calculator.model.operator.DivideOperator;
import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;

public class DivideRawToken implements RawToken {
    ExpressionToken divide = new DivideOperator();

    @Override
    public ExpressionToken convert(Expression context, int position) {
        return divide;
    }
}
