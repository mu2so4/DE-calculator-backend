package ru.nsu.ccfit.muratov.calculator.model;

import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;
import ru.nsu.ccfit.muratov.calculator.model.operator.LeftBracketOperator;
import ru.nsu.ccfit.muratov.calculator.model.raw.Priority;
import ru.nsu.ccfit.muratov.calculator.model.operator.RightBracketOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ExpressionConverter {
    public ExpressionConverter() {}

    public RPNExpression convert(Expression expression) throws SyntaxException {
        List<ExpressionToken> result = new ArrayList<>();
        Stack<ExpressionToken> stack = new Stack<>();

        for(ExpressionToken expressionToken : expression.getOperators()) { //TODO Demetra rule
            Priority currentPriority = expressionToken.getPriority();
            if(currentPriority == Priority.NUMBER) {
                result.add(expressionToken);
                continue;
            }
            if(expressionToken instanceof LeftBracketOperator) {
                stack.push(expressionToken);
                continue;
            }
            if(expressionToken instanceof RightBracketOperator) {
                while(!stack.isEmpty() && stack.peek().getPriority() != Priority.BRACKET) {
                    result.add(stack.pop());
                }
                if(stack.empty()) {
                    throw new SyntaxException("missed left bracket");
                }
                stack.pop();
                continue;
            }
            while(!stack.isEmpty()) {
                Priority peekPriority = stack.peek().getPriority();
                if(peekPriority.compareTo(currentPriority) < 0 || peekPriority == Priority.BRACKET) {
                    break;
                }
                result.add(stack.pop());
            }
            stack.add(expressionToken);
        }
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return new RPNExpression(result);
    }
}
