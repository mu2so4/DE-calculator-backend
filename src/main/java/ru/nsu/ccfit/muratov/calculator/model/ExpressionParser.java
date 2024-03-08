package ru.nsu.ccfit.muratov.calculator.model;

import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;
import ru.nsu.ccfit.muratov.calculator.model.operator.Priority;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionParser {
    private ExpressionParser() {}

    public static RPNExpression parse(Expression expression) {
        List<ExpressionToken> result = new ArrayList<>();
        Stack<ExpressionToken> stack = new Stack<>();

        for(ExpressionToken expressionToken : expression.getOperators()) { //TODO Demetra rule
            Priority currentPriority = expressionToken.getPriority();
            if(currentPriority == Priority.NUMBER) {
                result.add(expressionToken);
                continue;
            }
           while(!stack.isEmpty() && stack.peek().getPriority().compareTo(currentPriority) >= 0) {
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
