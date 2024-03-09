package ru.nsu.ccfit.muratov.calculator.model;

import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;

import java.util.*;

public class Expression {
    private final List<ExpressionToken> expressionTokens;

    public Expression(Collection<ExpressionToken> expressionTokens) {
        this.expressionTokens = new ArrayList<>(expressionTokens);
    }

    public List<ExpressionToken> getOperators() {
        return expressionTokens;
    }
}
