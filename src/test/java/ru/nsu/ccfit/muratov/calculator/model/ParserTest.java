package ru.nsu.ccfit.muratov.calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.nsu.ccfit.muratov.calculator.model.operator.*;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {
    @Test
    @DisplayName("brace-free test")
    void simpleTest() {
        List<Operator> operators = new ArrayList<>();
        operators.add(new NumberOperator(2));
        operators.add(new PlusOperator());
        operators.add(new NumberOperator(6));
        operators.add(new MultiplyOperator());
        operators.add(new NumberOperator(8));
        operators.add(new MinusOperator());
        operators.add(new NumberOperator(4));
        operators.add(new MultiplyOperator());
        operators.add(new NumberOperator(2));
        operators.add(new PowerOperator());
        operators.add(new NumberOperator(3));

        List<Operator> parsed = ExpressionParser.parse(operators);
        for(Operator operator: parsed) {
            System.out.println(operator.getClass().getName());
        }
    }
}
