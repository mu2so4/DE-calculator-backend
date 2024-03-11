package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.SyntaxException;

import java.util.Map;
import java.util.logging.Logger;

public class RawTokenFactory {
    private static final Logger logger = Logger.getLogger(RawTokenFactory.class.getCanonicalName());

    private static final RawTokenFactory factory = new RawTokenFactory();

    private final Map<String, RawToken> denotes;
    private RawTokenFactory() {
        try(RawTokenFactoryLoader loader = new RawTokenFactoryLoader("operators.fact")) {
            denotes = loader.loadClasses();
        }
        logger.info("OperatorFactory loaded");
    }

    public static RawTokenFactory getInstance() {
        return factory;
    }

    public RawToken getRawToken(String text) throws SyntaxException {
        RawToken token = denotes.get(text);
        if(token == null) {
            throw new SyntaxException(String.format("'%s': no such operator", text));
        }
        return token;
    }
}
