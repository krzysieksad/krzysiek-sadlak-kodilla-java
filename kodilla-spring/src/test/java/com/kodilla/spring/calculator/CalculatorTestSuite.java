package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Display.class)
public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //when
        double addResult = calculator.add(6,15.1);
        double subResult = calculator.sub(48.2, 65.88);
        double mulResult = calculator.mul(12.63, 10);
        double divResult = calculator.div(486, 20);

        //then
        Assert.assertEquals(21.1, addResult, 0);
        Assert.assertEquals(-17.68, subResult, 5);
        Assert.assertEquals(126.3, mulResult, 5);
        Assert.assertEquals(24.3, divResult, 0);
    }
}
