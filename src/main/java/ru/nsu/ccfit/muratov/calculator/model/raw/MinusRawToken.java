package ru.nsu.ccfit.muratov.calculator.model.raw;

import ru.nsu.ccfit.muratov.calculator.model.operator.*;

import java.util.List;

public class MinusRawToken implements RawToken {
    private final ExpressionToken unaryMinus = new MinusUnaryOperator();
    private final ExpressionToken binaryMinus = new MinusBinaryOperator();

    @Override
    public ExpressionToken convert(List<ExpressionToken> tokens, int position) {
        int bracketNestingLevel = 0;
        int operatorCount = 0;
        int numberCount = 0;

        int index = position - 1;
        while(index >= 0 && bracketNestingLevel >= 0) {
            ExpressionToken token = tokens.get(index);

            if(token instanceof LeftBracketOperator) {
                bracketNestingLevel--;
                if(bracketNestingLevel == 0) {
                    numberCount++;
                }
            }
            else if (token instanceof RightBracketOperator) {
                bracketNestingLevel++;
            }
            else if(bracketNestingLevel == 0) {
                if (token instanceof NumberToken) {
                    numberCount++;
                } else if(token instanceof Operator oper && oper.getProperOperandCount() == 2) {
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
