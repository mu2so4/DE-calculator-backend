package ru.nsu.ccfit.muratov.calculator.model;

import ru.nsu.ccfit.muratov.calculator.model.operator.*;

import java.util.*;

public class Calculator {
    private final ExpressionReader reader = new ExpressionReader();

    private final ExpressionConverter converter = new ExpressionConverter();

    private ExpressionStatus status = ExpressionStatus.OK;

    public double evaluate(String strExpression) {
        RPNExpression expression;
        try {
            Expression rawExpression = reader.extractExpression(strExpression);
            expression = converter.convert(rawExpression);
        }
        catch(SyntaxException e) {
            status = ExpressionStatus.SYNTAX_ERROR;
            return 0;
        }
        Stack<NumberToken> numbers = new Stack<>();
        status = ExpressionStatus.OK;

        for(ExpressionToken expressionToken : expression.getOperators()) {
            if(status != ExpressionStatus.OK) {
                break;
            }
            if(expressionToken instanceof NumberToken) {
                numbers.add((NumberToken) expressionToken);
            }
            else if(expressionToken instanceof Operator) {
                nextSubEvaluation(numbers, (Operator) expressionToken);
            }
            else {
                throw new IllegalStateException("got a token with unknown type");
            }
        }
        if(status != ExpressionStatus.OK) {
            return 0;
        }
        return numbers.pop().getValue();
    }

    private void nextSubEvaluation(Stack<NumberToken> numbers, Operator operator) {
        int count = operator.getProperOperandCount();
        List<Double> operands = new ArrayList<>(count);
        try {
            for (int index = 0; index < count; index++) {
                NumberToken token = numbers.pop();
                operands.add(token.getValue());
            }
        }
        catch(EmptyStackException e) {
            status = ExpressionStatus.SYNTAX_ERROR;
        }
        Collections.reverse(operands);
        double evaluationResult;
        try {
            evaluationResult = operator.evaluate(operands);
        }
        catch(DivisionByZeroException e) {
            status = ExpressionStatus.DIVISION_BY_ZERO;
            return;
        }
        catch(OperatorException e) {
            throw new RuntimeException(e);
        }
        if(Double.isNaN(evaluationResult)) {
            status = ExpressionStatus.NAN;
        }
        else if(Double.isInfinite(evaluationResult)) {
            status = ExpressionStatus.INFINITY;
        }
        else {
            numbers.push(new NumberToken(evaluationResult));
        }
    }

    public String getStatus() {
        return status.getMessage();
    }
}
