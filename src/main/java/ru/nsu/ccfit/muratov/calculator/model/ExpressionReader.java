package ru.nsu.ccfit.muratov.calculator.model;

import ru.nsu.ccfit.muratov.calculator.model.operator.NumberOperator;
import ru.nsu.ccfit.muratov.calculator.model.operator.Operator;
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
        List<Operator> operators = new ArrayList<>();
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
                        operators.add(factory.getOperator(Character.toString(symbol)));
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
                        operators.add(new NumberOperator(Double.parseDouble(builder.toString())));
                        builder = new StringBuilder();
                        operators.add(factory.getOperator(Character.toString(symbol)));
                    }
                    else if(!isWhitespace) {
                        status = CurrentStatus.READING_FUNCTION_NAME;
                        operators.add(new NumberOperator(Double.parseDouble(builder.toString())));
                        builder = new StringBuilder();
                        builder.append(symbol);
                    }
                }
                case READING_FUNCTION_NAME -> {
                    if(isDigitSymbol) {
                        status = CurrentStatus.READING_NUMBER;
                        operators.add(factory.getOperator(builder.toString()));
                        builder = new StringBuilder();
                        builder.append(symbol);
                    }
                    else if(isBracket) {
                        status = CurrentStatus.IDLE;
                        operators.add(factory.getOperator(builder.toString()));
                        builder = new StringBuilder();
                        operators.add(factory.getOperator(Character.toString(symbol)));
                    }
                    else if(!isWhitespace) {
                        builder.append(symbol);
                    }
                }
            }
        }
        switch(status) {
            case READING_NUMBER -> {
                operators.add(new NumberOperator(Double.parseDouble(builder.toString())));
            }
            case READING_FUNCTION_NAME -> {
                operators.add(factory.getOperator(builder.toString()));
            }
        }
        return new Expression(operators);
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}
