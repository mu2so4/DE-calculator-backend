package ru.nsu.ccfit.muratov.calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;

public class ReadingTest {
    @Test
    @DisplayName("simple test")
    void simpleTest() throws SyntaxException {
        String exp = "2 + 6*8 - 4 *2^3";

        ExpressionReader reader = new ExpressionReader(exp);
        Expression operators = reader.extractExpression();
        for(ExpressionToken expressionToken : operators.getOperators()) { //TODO Demetra rule
            System.out.println(expressionToken.getClass().getName());
        }
    }
}
