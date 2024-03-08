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
        List<ExpressionToken> operators = new ArrayList<>();
        operators.add(new NumberToken(2));
        operators.add(new PlusOperator());
        operators.add(new NumberToken(6));
        operators.add(new MultiplyOperator());
        operators.add(new NumberToken(8));
        operators.add(new MinusOperator());
        operators.add(new NumberToken(4));
        operators.add(new MultiplyOperator());
        operators.add(new NumberToken(2));
        operators.add(new PowerOperator());
        operators.add(new NumberToken(3));

        Expression rpn = new Expression(operators);

        RPNExpression parsed = ExpressionParser.parse(rpn);
        for(ExpressionToken expressionToken : parsed.getOperators()) { //TODO Demetra rule
            System.out.println(expressionToken.getClass().getName());
        }
    }
}
