package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    /**
     * Class for submodule 7.1
     * @param args just args
     */
    public static void main(final String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("");

        //Task 7.1
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("my poem is beautiful", (poem) -> poem + ", but now is pretty.");
        System.out.println("");
        poemBeautifier.beautify("Violets are blue", (poem) -> "Roses are red\n" + poem + "\nActually violets are violet\nBut who cares");
        System.out.println("");
        poemBeautifier.beautify("Magic growth", String::toUpperCase);
        System.out.println("");
        poemBeautifier.beautify("Creating Haiku\nIs harder than it appears\nThis may take a while",
                                (poem) -> ("try reading that: " + poem).replaceAll("[\n :]", "").toLowerCase());
        System.out.println("");
        poemBeautifier.beautify("Raindrops on this page\nWind blows my paper away\nOh crap! I need that...\n", (poem) -> "I hate poems!");
    }
}
