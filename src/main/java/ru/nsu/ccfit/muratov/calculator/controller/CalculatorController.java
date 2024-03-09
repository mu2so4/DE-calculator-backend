package ru.nsu.ccfit.muratov.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.muratov.calculator.model.EvaluatedResponse;
import ru.nsu.ccfit.muratov.calculator.model.ExpressionRequest;
import ru.nsu.ccfit.muratov.calculator.service.ExpressionRequestService;

@RestController
public class CalculatorController {
    @Autowired
    private ExpressionRequestService service;

    @PostMapping(value = "/evaluate", consumes = "application/json", produces = "application/json")
    public EvaluatedResponse evaluate(@RequestBody ExpressionRequest request) {
        return service.evaluate(request);
    }
}
