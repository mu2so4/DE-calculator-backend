package ru.nsu.ccfit.muratov.calculator.model;

import ru.nsu.ccfit.muratov.calculator.model.operator.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Calculator {
    private final RPNExpression expression;
    private ExpressionStatus status = ExpressionStatus.OK;

    public Calculator(Expression expression) throws SyntaxException {
        this.expression = ExpressionConverter.convert(expression);
    }

    public double evaluate() {
        Stack<NumberToken> numbers = new Stack<>();

        for(ExpressionToken expressionToken : expression.getOperators()) { //TODO Demetra rule
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
        return numbers.pop().getValue();
    }

    private void nextSubEvaluation(Stack<NumberToken> numbers, Operator operator) {
        int count = operator.getProperOperandCount();
        List<Double> operands = new ArrayList<>(count);
        for(int index = 0; index < count; index++) {
            NumberToken token = numbers.pop();
            operands.add(token.getValue());
        }
        Collections.reverse(operands);
        try {
            double evaluationResult = operator.evaluate(operands);
            numbers.push(new NumberToken(evaluationResult));
        }
        catch(DivisionByZeroException e) {
            status = ExpressionStatus.DIVISION_BY_ZERO;
        }
        catch(OperatorException e) {
            throw new RuntimeException(e);
        }
    }
}
