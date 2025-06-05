package modulo16.examples.inheritanceandinterface.entities;

import modulo16.examples.inheritanceandinterface.enums.Color;

public class Circle extends AbstractShape implements Shape {
    private double radius;

    public Circle(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area(){
        return Math.PI * radius * radius;
    }
}
