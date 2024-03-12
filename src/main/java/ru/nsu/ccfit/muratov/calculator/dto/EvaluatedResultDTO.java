package ru.nsu.ccfit.muratov.calculator.dto;

public class EvaluatedResultDTO {
    private String status;
    private double value;

    public EvaluatedResultDTO() {}

    public EvaluatedResultDTO(String status, double value) {
        this.value = value;
        this.status = status;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
