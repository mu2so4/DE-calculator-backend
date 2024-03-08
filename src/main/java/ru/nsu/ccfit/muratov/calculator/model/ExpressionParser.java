package ru.nsu.ccfit.muratov.calculator.model;

import ru.nsu.ccfit.muratov.calculator.model.operator.Operator;
import ru.nsu.ccfit.muratov.calculator.model.operator.Priority;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionParser {
    private ExpressionParser() {}

    public static RPNExpression parse(Expression expression) {
        List<Operator> result = new ArrayList<>();
        Stack<Operator> stack = new Stack<>();

        for(Operator operator: expression.getOperators()) { //TODO Demetra rule
            Priority currentPriority = operator.getPriority();
            if(currentPriority == Priority.NUMBER) {
                result.add(operator);
                continue;
            }
           while(!stack.isEmpty() && stack.peek().getPriority().compareTo(currentPriority) >= 0) {
               result.add(stack.pop());
           }
           stack.add(operator);
        }
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return new RPNExpression(result);
    }
}
