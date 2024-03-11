package ru.nsu.ccfit.muratov.calculator.service;

import ru.nsu.ccfit.muratov.calculator.dto.EvaluatedResultDTO;
import ru.nsu.ccfit.muratov.calculator.dto.ExpressionDTO;

public interface ExpressionRequestService {
    EvaluatedResultDTO evaluate(ExpressionDTO request);
}
