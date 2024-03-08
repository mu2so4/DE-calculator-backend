package ru.nsu.ccfit.muratov.calculator.model.operator;

public class LeftBracketOperator extends ExpressionToken {

    @Override
    public Priority getPriority() {
        return Priority.BRACKET;
    }
}
