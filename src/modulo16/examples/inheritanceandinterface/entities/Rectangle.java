package modulo16.examples.inheritanceandinterface.entities;

import modulo16.examples.inheritanceandinterface.enums.Color;

public class Rectangle extends AbstractShape{
    private double width;
    private double height;

    public Rectangle(Color color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width *height;
    }
}
