package ru.nsu.ccfit.muratov.calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.nsu.ccfit.muratov.calculator.model.operator.Operator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ReadingTest {
    @Test
    @DisplayName("simple test")
    void simpleTest() throws IOException {
        String exp = "2 + 6*8 - 4 *2^3";
        InputStream targetStream = new ByteArrayInputStream(exp.getBytes());

        ExpressionReader reader = new ExpressionReader(targetStream);
        List<Operator> operators = reader.extractExpression();
        for(Operator operator: operators) {
            System.out.println(operator.getClass().getName());
        }
    }
}
