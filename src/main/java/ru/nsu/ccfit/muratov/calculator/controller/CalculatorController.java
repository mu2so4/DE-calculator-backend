package ru.nsu.ccfit.muratov.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.muratov.calculator.model.EvaluatedResponse;
import ru.nsu.ccfit.muratov.calculator.model.ExpressionRequest;
import ru.nsu.ccfit.muratov.calculator.service.ExpressionRequestService;

@RestController
public class CalculatorController {
    @Autowired
    private ExpressionRequestService service;

    @CrossOrigin
    @PostMapping(value = "/evaluate", consumes = "application/json", produces = "application/json")
    public EvaluatedResponse evaluate(@RequestBody ExpressionRequest request) {
        return service.evaluate(request);
    }
}
