package ru.nsu.ccfit.muratov.calculator.model.operator;

public class LeftBracketOperator implements ExpressionToken {

    @Override
    public Priority getPriority() {
        return Priority.BRACKET;
    }
}
