package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;
import ru.nsu.ccfit.muratov.calculator.model.operator.NumberToken;

import java.util.List;

public class NumberRawToken implements RawToken {
    private final double value;

    public NumberRawToken(double value) {
        this.value = value;
    }

    @Override
    public final ExpressionToken convert(List<ExpressionToken> context, int position) {
        return new NumberToken(value);
    }
}
