package ru.nsu.ccfit.muratov.calculator.service;

import org.springframework.stereotype.Service;
import ru.nsu.ccfit.muratov.calculator.model.*;

import java.util.logging.Logger;

@Service
public class ExpressionRequestServiceImpl implements ExpressionRequestService {
    private static final Logger logger = Logger.getLogger(ExpressionRequestServiceImpl.class.getCanonicalName());

    @Override
    public EvaluatedResponse evaluate(ExpressionRequest request) {
        String strExpression = request.getExpression();
        ExpressionReader reader = new ExpressionReader(strExpression);
        Calculator calculator;
        try {
            Expression expression = reader.extractExpression();
            calculator = new Calculator(expression);
        }
        catch(SyntaxException e) {
            logger.severe(e::getMessage);
            return new EvaluatedResponse(-1); //TODO replace
        }
        double result = calculator.evaluate();
        return new EvaluatedResponse(result);
    }
}
