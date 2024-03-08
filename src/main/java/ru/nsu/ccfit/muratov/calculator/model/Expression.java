package ru.nsu.ccfit.muratov.calculator.model;

import ru.nsu.ccfit.muratov.calculator.model.operator.Operator;

import java.util.*;

public class Expression {
    private final List<Operator> operators;

    public Expression(Collection<Operator> operators) {
        this.operators = new ArrayList<>(operators);
    }

    public Operator at(int index) {
        return operators.get(index);
    }

    public List<Operator> getOperators() {
        return operators;
    }
}
