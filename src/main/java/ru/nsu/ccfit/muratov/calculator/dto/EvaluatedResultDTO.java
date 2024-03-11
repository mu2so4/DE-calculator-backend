package ru.nsu.ccfit.muratov.calculator.dto;

public class EvaluatedResultDTO {
    private double result;

    public EvaluatedResultDTO(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
