package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;
import ru.nsu.ccfit.muratov.calculator.model.operator.PowerOperator;

import java.util.List;

public class PowerRawToken implements RawToken {
    private final ExpressionToken power = new PowerOperator();

    @Override
    public ExpressionToken convert(List<ExpressionToken> context, int position) {
        return power;
    }
}
