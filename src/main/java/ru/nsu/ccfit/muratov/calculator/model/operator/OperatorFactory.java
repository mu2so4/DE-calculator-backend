package ru.nsu.ccfit.muratov.calculator.model.operator;

import java.util.Map;
import java.util.logging.Logger;

public class OperatorFactory {
    private static final Logger logger = Logger.getLogger(OperatorFactory.class.getCanonicalName());

    private static final OperatorFactory factory = new OperatorFactory();

    private final Map<String, ExpressionToken> denotes;
    private OperatorFactory() {
        try(OperatorFactoryLoader loader = new OperatorFactoryLoader("operators.fact")) {
            denotes = loader.loadClasses();
        }
        logger.info("OperatorFactory loaded");
    }

    public static OperatorFactory getInstance() {
        return factory;
    }

    public ExpressionToken getOperator(String text) {
        return denotes.get(text);
    }
}
