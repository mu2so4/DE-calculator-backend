package ru.nsu.ccfit.muratov.calculator.model.operator;

public class RightBracketOperator implements ExpressionToken {

    @Override
    public Priority getPriority() {
        return Priority.BRACKET;
    }
}
