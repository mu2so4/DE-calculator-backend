package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.Expression;
import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;
import ru.nsu.ccfit.muratov.calculator.model.operator.MinusBinaryOperator;
import ru.nsu.ccfit.muratov.calculator.model.operator.MinusUnaryOperator;

import java.util.List;

public class MinusRawToken implements RawToken {
    private final ExpressionToken unaryMinus = new MinusUnaryOperator();
    private final ExpressionToken binaryMinus = new MinusBinaryOperator();

    @Override
    public ExpressionToken convert(Expression context, int position) {
        int bracketNestingLevel = 0;
        int operatorCount = 0;
        int numberCount = 0;
        List<RawToken> tokens = context.getRawTokens();

        int index = position - 1;
        while(index >= 0 && bracketNestingLevel >= 0) {
            RawToken token = tokens.get(index);

            if(token instanceof LeftBracketRawToken) {
                bracketNestingLevel--;
            }
            else if (token instanceof RightBracketRawToken) {
                bracketNestingLevel++;
            }
            else if(bracketNestingLevel == 0) {
                if (token instanceof NumberRawToken) {
                    numberCount++;
                } else {
                    operatorCount++;
                }
            }
            index--;
        }
        if(operatorCount >= numberCount) {
            return unaryMinus;
        }
        return binaryMinus;
    }
}
