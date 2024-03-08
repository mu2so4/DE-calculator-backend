package ru.nsu.ccfit.muratov.calculator.model.operator;

public class RightBracketOperator extends ExpressionToken {

    @Override
    public Priority getPriority() {
        return Priority.BRACKET;
    }
}
