package com.kodilla.patterns2.aop.calculator;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@EnableAspectJAutoProxy
public class Calculator {
    public double add(final double x, final double y) {
        return x + y;
    }

    public double sub(final double x, final double y) {
        return x - y;
    }

    public double mul(final double x, final double y) {
        return x * y;
    }

    /**
     * Submodule 20.3. Division.
     *
     * @param x x
     * @param y y
     * @return division
     */
    public double div(final double x, final double y) {
        if (y == 0) {
            throw new ArithmeticException("Divide by zero!");
        }
        return x / y;
    }

    /**
     * Submodule 20.3. Factorial.
     *
     * @param n n
     * @return factorial
     */
    public BigDecimal factorial(final BigDecimal n) {
        if (n.compareTo(BigDecimal.ONE) > 0) {
            return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
        } else if (n.equals(BigDecimal.ONE) || n.equals(BigDecimal.ZERO)) {
            return BigDecimal.ONE;
        } else {
            throw new ArithmeticException("Factorial argument is negative!");
        }
    }
}