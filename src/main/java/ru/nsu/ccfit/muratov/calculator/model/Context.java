package ru.nsu.ccfit.muratov.calculator.model;

import ru.nsu.ccfit.muratov.calculator.model.operator.DivisionByZeroException;
import ru.nsu.ccfit.muratov.calculator.model.operator.Operator;
import ru.nsu.ccfit.muratov.calculator.model.operator.OperatorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Context {
    private final Stack<Double> numberStack = new Stack<>();
    private ExpressionStatus status = ExpressionStatus.OK;

    public void push(double value) {
        numberStack.push(value);
    }


    public double pop() {
        return numberStack.pop();
    }

    public double getLast() {
        return numberStack.peek();
    }

    public void evaluate(Operator operator) {
        int count = operator.getProperOperandCount();
        List<Double> operands = new ArrayList<>(count);
        for(int index = 0; index < count; index++) {
            operands.add(this.pop());
        }
        try {
            double evaluationResult = operator.evaluate(operands);
            this.push(evaluationResult);
        }
        catch(DivisionByZeroException e) {
            status = ExpressionStatus.DIVISION_BY_ZERO;
        }
        catch(OperatorException e) {
            throw new RuntimeException(e);
        }
    }
}
