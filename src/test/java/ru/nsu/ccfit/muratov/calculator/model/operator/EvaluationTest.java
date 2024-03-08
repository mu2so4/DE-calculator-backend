package ru.nsu.ccfit.muratov.calculator.model.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.nsu.ccfit.muratov.calculator.model.Calculator;
import ru.nsu.ccfit.muratov.calculator.model.Expression;
import ru.nsu.ccfit.muratov.calculator.model.ExpressionReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EvaluationTest {
    @Test
    @DisplayName("simple evaluation test")
    public void simpleTest() throws IOException {
        String str = "2 + 6 * 8 - 4 * 2 ^ 3";
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        ExpressionReader reader = new ExpressionReader(inputStream);
        Expression expression = reader.extractExpression();
        Calculator calculator = new Calculator(expression);
        double result = calculator.evaluate();
        System.out.println(result);
    }
}
