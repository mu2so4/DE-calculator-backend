package ru.nsu.ccfit.muratov.calculator.model.operator;

public class Plus implements Operator {
    private static final int OPERAND_COUNT = 2;
    @Override
    public double evaluate(double... values) {
        //check if we got proper count of operands for addition
        if(values.length != OPERAND_COUNT) {
            throw new IllegalArgumentException(
                String.format("expected %d operands, got %d", OPERAND_COUNT, values.length)
            );
        }
        return values[0] + values[1];
    }

    @Override
    public int getOperandCount() {
        return OPERAND_COUNT;
    }
}
