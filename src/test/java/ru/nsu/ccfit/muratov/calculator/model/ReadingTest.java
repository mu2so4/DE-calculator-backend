package ru.nsu.ccfit.muratov.calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadingTest {
    @Test
    @DisplayName("simple test")
    void simpleTest() throws IOException {
        String exp = "2 + 6*8 - 4 *2^3";
        InputStream targetStream = new ByteArrayInputStream(exp.getBytes());

        ExpressionReader reader = new ExpressionReader(targetStream);
        Expression operators = reader.extractExpression();
        for(ExpressionToken expressionToken : operators.getOperators()) { //TODO Demetra rule
            System.out.println(expressionToken.getClass().getName());
        }
    }
}
