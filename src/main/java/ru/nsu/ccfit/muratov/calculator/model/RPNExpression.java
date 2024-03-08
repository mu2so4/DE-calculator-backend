package ru.nsu.ccfit.muratov.calculator.model;

import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RPNExpression {
    private final List<ExpressionToken> expressionTokens;

    public RPNExpression(Collection<ExpressionToken> expressionTokens) {
        this.expressionTokens = new ArrayList<>(expressionTokens);
    }

    public ExpressionToken at(int index) {
        return expressionTokens.get(index);
    }

    public List<ExpressionToken> getOperators() {
        return expressionTokens;
    }
}
