package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.Expression;
import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;
import ru.nsu.ccfit.muratov.calculator.model.operator.PowerOperator;

public class PowerRawToken implements RawToken {
    private final ExpressionToken power = new PowerOperator();

    @Override
    public ExpressionToken convert(Expression context, int position) {
        return power;
    }
}
