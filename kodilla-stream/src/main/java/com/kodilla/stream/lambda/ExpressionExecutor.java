package com.kodilla.stream.lambda;

public class ExpressionExecutor {
    public void executeExpression(final double a, final double b, final MathExpression mathExpression) {
        double result = mathExpression.calculateExpression(a, b);
        System.out.println("Result equals: " + result);
    }
}
