package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;

import java.util.List;

public interface RawToken {
    ExpressionToken convert(List<ExpressionToken> context, int position);
}
