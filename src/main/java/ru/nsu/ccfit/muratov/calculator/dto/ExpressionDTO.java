package ru.nsu.ccfit.muratov.calculator.dto;

public class ExpressionDTO {
    private String expression;

    public ExpressionDTO() {}

    public ExpressionDTO(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
