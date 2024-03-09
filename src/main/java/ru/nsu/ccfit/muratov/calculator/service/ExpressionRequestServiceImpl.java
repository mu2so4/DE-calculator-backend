package ru.nsu.ccfit.muratov.calculator.service;

import org.springframework.stereotype.Service;
import ru.nsu.ccfit.muratov.calculator.model.*;

@Service
public class ExpressionRequestServiceImpl implements ExpressionRequestService {
    @Override
    public EvaluatedResponse evaluate(ExpressionRequest request) {
        String strExpression = request.getExpression();
        ExpressionReader reader = new ExpressionReader(strExpression);
        Expression expression = reader.extractExpression();
        Calculator calculator;
        try {
            calculator = new Calculator(expression);
        }
        catch(SyntaxException e) {
            return new EvaluatedResponse(-1); //TODO replace
        }
        double result = calculator.evaluate();
        return new EvaluatedResponse(result);
    }
}
