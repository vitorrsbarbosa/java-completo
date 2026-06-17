package modulo16.interfaces.exercise02;

import modulo16.interfaces.exercise02.enums.Color;
import modulo16.interfaces.exercise02.model.AbstractShape;
import modulo16.interfaces.exercise02.model.Circle;
import modulo16.interfaces.exercise02.model.Rectangle;

public class Program {
    public static void main(String[] args) {
     
        AbstractShape circle = new Circle(Color.BLACK, 2.0);
        AbstractShape rectangle = new Rectangle(Color.WHITE, 3.0, 4.0);

        System.out.println("Circle color: " + circle.getColor());
        System.out.println("Circle area: " + String.format("%.3f",circle.area()));
        System.out.println("Rectangle color: " + rectangle.getColor());
        System.out.println("Rectangle area: " + String.format("%.3f",rectangle.area()));
    }
}
