package ru.nsu.ccfit.muratov.calculator.model.operator;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {
    private static final OperatorFactory factory = new OperatorFactory();

    private final Map<String, Operator> denotes = new HashMap<>();
    private OperatorFactory() {
        //TODO importing
    }

    public static OperatorFactory getInstance() {
        return factory;
    }

    public Operator getOperator(String text) {
        return denotes.get(text);
    }
}
