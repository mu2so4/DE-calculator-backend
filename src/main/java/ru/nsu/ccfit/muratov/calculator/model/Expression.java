package ru.nsu.ccfit.muratov.calculator.model;

import ru.nsu.ccfit.muratov.calculator.model.raw.RawToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Expression {
    private final List<RawToken> rawTokens;

    public Expression(Collection<RawToken> expressionTokens) {
        this.rawTokens = new ArrayList<>(expressionTokens);
    }

    public List<RawToken> getRawTokens() {
        return rawTokens;
    }
}
