package ru.nsu.ccfit.muratov.calculator.model.operator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PlusTest {

    @Test
    @DisplayName("test proper operand count")
    void testProperOperandCount() {
        final int PROPER_OPERAND_COUNT = 2;
        Operator operator = new PlusOperator();
        Assertions.assertEquals(PROPER_OPERAND_COUNT, operator.getProperOperandCount());
    }

    @Test
    @DisplayName("invalid parameter count test")
    void testInvalidParameterCount() {
        Operator operator = new PlusOperator();
        final int MAX_COUNT = 100;
        int properOperandCount = operator.getProperOperandCount();
        List<Double> operands = new ArrayList<>();
        for(int index = 0; index < MAX_COUNT; index++) {
            if(index != properOperandCount) {
                Assertions.assertThrows(IllegalArgumentException.class, () -> operator.evaluate(operands));
            }
            else {
                Assertions.assertDoesNotThrow(() -> operator.evaluate(operands));
            }

            operands.add(1.0);
        }
    }

    @Test
    @DisplayName("check evaluation")
    void testEvaluating() throws OperatorException {
        /*ExpressionToken operator = new PlusOperator();
        List<Double> values = new ArrayList<>();
        double a = 10.0;
        double b = -8.9;
        values.add(a);
        values.add(b);
        Assertions.assertEquals(a + b, operator.evaluate(values));
         */
    }
}
