package ru.nsu.ccfit.muratov.calculator.service;

import ru.nsu.ccfit.muratov.calculator.model.EvaluatedResponse;
import ru.nsu.ccfit.muratov.calculator.model.ExpressionRequest;

public interface ExpressionRequestService {
    EvaluatedResponse evaluate(ExpressionRequest request);
}
