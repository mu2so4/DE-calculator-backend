package ru.nsu.ccfit.muratov.calculator.model.operator;

import ru.nsu.ccfit.muratov.calculator.model.SyntaxException;

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

    public ExpressionToken getOperator(String text) throws SyntaxException {
        ExpressionToken token = denotes.get(text);
        if(token == null) {
            throw new SyntaxException(String.format("'%s': no such operator", text));
        }
        return token;
    }
}
