package ru.nsu.ccfit.muratov.calculator.model.operator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.nsu.ccfit.muratov.calculator.model.Calculator;

public class EvaluationTest {
    private final Calculator calculator = new Calculator();
    @Test
    @DisplayName("simple evaluation test")
    public void simpleTest() {
        String str = "e * 4.27";
        double result = calculator.evaluate(str);
        double expected = Math.E * 4.27;
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("plus multiply order")
    public void plusMultiplyOrder() {
        String str = "2 + 2 * 2";
        double result = calculator.evaluate(str);
        double expected = 2 + 2 * 2;
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("unary minus test")
    public void unaryMinusTest() {
        String str = "- (2 * 99) * .8 * -1 - 5";
        double result = calculator.evaluate(str);
        double expected = - (2 * 99) * .8 * -1 - 5;
        Assertions.assertEquals(expected, result);
    }
}
