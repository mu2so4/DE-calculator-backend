package ru.nsu.ccfit.muratov.calculator.model.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.nsu.ccfit.muratov.calculator.model.Calculator;

public class EvaluationTest {
    @Test
    @DisplayName("simple evaluation test")
    public void simpleTest() {
        //String str = "2 + 6 * 8 - 4 * 2 ^ 3";
        String str = "e * 4.27";
        Calculator calculator = new Calculator();
        double result = calculator.evaluate(str);
        System.out.println(result);
    }
}
