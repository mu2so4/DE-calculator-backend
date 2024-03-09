package ru.nsu.ccfit.muratov.calculator.model.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.nsu.ccfit.muratov.calculator.model.Calculator;
import ru.nsu.ccfit.muratov.calculator.model.Expression;
import ru.nsu.ccfit.muratov.calculator.model.ExpressionReader;
import ru.nsu.ccfit.muratov.calculator.model.SyntaxException;

public class EvaluationTest {
    @Test
    @DisplayName("simple evaluation test")
    public void simpleTest() throws SyntaxException {
        //String str = "2 + 6 * 8 - 4 * 2 ^ 3";
        String str = "e * 4.27";
        ExpressionReader reader = new ExpressionReader(str);
        Expression expression = reader.extractExpression();
        Calculator calculator = new Calculator(expression);
        double result = calculator.evaluate();
        System.out.println(result);
    }
}
