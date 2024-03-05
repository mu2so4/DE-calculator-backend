package ru.nsu.ccfit.muratov.calculator.model.operator;

import ru.nsu.ccfit.muratov.calculator.model.Context;

public interface Operator {
    double evaluate(double... values);

    int getOperandCount();
}
