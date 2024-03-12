package ru.nsu.ccfit.muratov.calculator.service;

import org.springframework.stereotype.Service;
import ru.nsu.ccfit.muratov.calculator.dto.EvaluatedResultDTO;
import ru.nsu.ccfit.muratov.calculator.dto.ExpressionDTO;
import ru.nsu.ccfit.muratov.calculator.model.Calculator;

import java.util.logging.Logger;

@Service
public class ExpressionRequestServiceImpl implements ExpressionRequestService {
    private static final Logger logger = Logger.getLogger(ExpressionRequestServiceImpl.class.getCanonicalName());

    @Override
    public EvaluatedResultDTO evaluate(ExpressionDTO request) {
        String strExpression = request.getExpression();
        Calculator calculator = new Calculator();
        double result = calculator.evaluate(strExpression);
        String status = calculator.getStatus();
        return new EvaluatedResultDTO(status, result);
    }
}
