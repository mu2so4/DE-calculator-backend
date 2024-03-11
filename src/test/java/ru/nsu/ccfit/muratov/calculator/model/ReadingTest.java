package ru.nsu.ccfit.muratov.calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;
import ru.nsu.ccfit.muratov.calculator.model.raw.RawToken;

public class ReadingTest {
    @Test
    @DisplayName("simple test")
    void simpleTest() throws SyntaxException {
        String exp = "2 + 6*8 - 4 *2^3";

        ExpressionReader reader = new ExpressionReader();
        Expression expression = reader.extractExpression(exp);
        for(RawToken expressionToken : expression.getRawTokens()) {
            System.out.println(expressionToken.getClass().getName());
        }
    }
}
