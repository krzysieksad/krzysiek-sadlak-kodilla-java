package com.kodilla.spring.shape;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Square implements Shape {
    @Override
    public String getShapeName() {
        return "This is a square.";
    }
}
