package ru.nsu.ccfit.muratov.calculator.model;

import ru.nsu.ccfit.muratov.calculator.model.operator.ExpressionToken;
import ru.nsu.ccfit.muratov.calculator.model.operator.NumberToken;
import ru.nsu.ccfit.muratov.calculator.model.operator.OperatorFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExpressionReader implements AutoCloseable {

    private final BufferedInputStream inputStream;

    public ExpressionReader(InputStream inputStream) {
        this.inputStream = new BufferedInputStream(inputStream);
    }

    public Expression extractExpression() throws IOException {
        enum CurrentStatus {
            READING_NUMBER,
            READING_FUNCTION_NAME,
            IDLE
        }

        OperatorFactory factory = OperatorFactory.getInstance();
        List<ExpressionToken> expressionTokens = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        CurrentStatus status = CurrentStatus.IDLE;
        while(true) {
            int currentCodepoint = inputStream.read();
            if(currentCodepoint < 0) {
                break;
            }
            char symbol = (char) currentCodepoint;
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
                        expressionTokens.add(factory.getOperator(Character.toString(symbol)));
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
                        expressionTokens.add(new NumberToken(Double.parseDouble(builder.toString())));
                        builder = new StringBuilder();
                        expressionTokens.add(factory.getOperator(Character.toString(symbol)));
                    }
                    else if(!isWhitespace) {
                        status = CurrentStatus.READING_FUNCTION_NAME;
                        expressionTokens.add(new NumberToken(Double.parseDouble(builder.toString())));
                        builder = new StringBuilder();
                        builder.append(symbol);
                    }
                }
                case READING_FUNCTION_NAME -> {
                    if(isDigitSymbol) {
                        status = CurrentStatus.READING_NUMBER;
                        expressionTokens.add(factory.getOperator(builder.toString()));
                        builder = new StringBuilder();
                        builder.append(symbol);
                    }
                    else if(isBracket) {
                        status = CurrentStatus.IDLE;
                        expressionTokens.add(factory.getOperator(builder.toString()));
                        builder = new StringBuilder();
                        expressionTokens.add(factory.getOperator(Character.toString(symbol)));
                    }
                    else if(!isWhitespace) {
                        builder.append(symbol);
                    }
                }
            }
        }
        switch(status) {
            case READING_NUMBER -> {
                expressionTokens.add(new NumberToken(Double.parseDouble(builder.toString())));
            }
            case READING_FUNCTION_NAME -> {
                expressionTokens.add(factory.getOperator(builder.toString()));
            }
        }
        return new Expression(expressionTokens);
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}
