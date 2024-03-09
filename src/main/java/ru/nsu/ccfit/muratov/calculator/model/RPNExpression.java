package ru.nsu.ccfit.muratov.calculator.model;

import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class RPNExpression {
    private final List<ExpressionToken> expressionTokens;

    public RPNExpression(Collection<ExpressionToken> expressionTokens) {
        this.expressionTokens = new ArrayList<>(expressionTokens);
    }

    public List<ExpressionToken> getOperators() {
        return expressionTokens;
    }
}
