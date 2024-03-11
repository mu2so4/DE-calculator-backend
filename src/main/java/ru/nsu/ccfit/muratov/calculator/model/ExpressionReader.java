package ru.nsu.ccfit.muratov.calculator.model;

import ru.nsu.ccfit.muratov.calculator.model.raw.NumberRawToken;
import ru.nsu.ccfit.muratov.calculator.model.raw.RawToken;
import ru.nsu.ccfit.muratov.calculator.model.raw.RawTokenFactory;

import java.util.ArrayList;
import java.util.List;

public class ExpressionReader {

    public Expression extractExpression(String rawExpression) throws SyntaxException {
        enum CurrentStatus {
            READING_NUMBER,
            READING_FUNCTION_NAME,
            IDLE
        }

        RawTokenFactory factory = RawTokenFactory.getInstance();
        List<RawToken> expressionTokens = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        CurrentStatus status = CurrentStatus.IDLE;
        for(char symbol: rawExpression.toCharArray()) {
            boolean isDigitSymbol = Character.isDigit(symbol) || symbol == '.';
            boolean isBracket = symbol == '(' || symbol == ')';
            boolean isWhitespace = Character.isWhitespace(symbol);

            switch(status) {
                case IDLE -> {
                    if(isDigitSymbol) {
                        status = CurrentStatus.READING_NUMBER;
                        builder.append(symbol);
                    }
                    else if(isBracket) {
                        expressionTokens.add(factory.getRawToken(Character.toString(symbol)));
                    }
                    else if(!isWhitespace) {
                        status = CurrentStatus.READING_FUNCTION_NAME;
                        builder.append(symbol);
                    }
                }
                case READING_NUMBER -> {
                    if(isDigitSymbol) {
                        builder.append(symbol);
                    }
                    else if(isBracket) {
                        status = CurrentStatus.IDLE;
                        expressionTokens.add(new NumberRawToken(Double.parseDouble(builder.toString())));
                        builder = new StringBuilder();
                        expressionTokens.add(factory.getRawToken(Character.toString(symbol)));
                    }
                    else if(isWhitespace) {
                        status = CurrentStatus.IDLE;
                        expressionTokens.add(new NumberRawToken(Double.parseDouble(builder.toString())));
                        builder = new StringBuilder();
                    }
                    else {
                        status = CurrentStatus.READING_FUNCTION_NAME;
                        expressionTokens.add(new NumberRawToken(Double.parseDouble(builder.toString())));
                        builder = new StringBuilder();
                        builder.append(symbol);
                    }
                }
                case READING_FUNCTION_NAME -> {
                    if(isDigitSymbol) {
                        status = CurrentStatus.READING_NUMBER;
                        expressionTokens.add(factory.getRawToken(builder.toString()));
                        builder = new StringBuilder();
                        builder.append(symbol);
                    }
                    else if(isBracket) {
                        status = CurrentStatus.IDLE;
                        expressionTokens.add(factory.getRawToken(builder.toString()));
                        builder = new StringBuilder();
                        expressionTokens.add(factory.getRawToken(Character.toString(symbol)));
                    }
                    else if(isWhitespace) {
                        status = CurrentStatus.IDLE;
                        expressionTokens.add(factory.getRawToken(builder.toString()));
                        builder = new StringBuilder();
                    }
                    else {
                        builder.append(symbol);
                    }
                }
            }
        }
        switch(status) {
            case READING_NUMBER ->
                    expressionTokens.add(new NumberRawToken(Double.parseDouble(builder.toString())));
            case READING_FUNCTION_NAME ->
                    expressionTokens.add(factory.getRawToken(builder.toString()));
        }
        return new Expression(expressionTokens);
    }
}
