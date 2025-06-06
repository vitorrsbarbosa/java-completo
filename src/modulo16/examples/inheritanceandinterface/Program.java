package modulo16.examples.inheritanceandinterface;

import modulo16.examples.inheritanceandinterface.entities.AbstractShape;
import modulo16.examples.inheritanceandinterface.entities.Circle;
import modulo16.examples.inheritanceandinterface.entities.Rectangle;
import modulo16.examples.inheritanceandinterface.enums.Color;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of the circle: ");
        double radius = sc.nextDouble();
        System.out.print("Enter color of the circle between Black and White: ");
        Color circleColor = Color.valueOf(sc.next().toUpperCase());
        System.out.println();
        System.out.print("Now, input the width of the rectangle: ");
        double width = sc.nextDouble();
        System.out.print("And after that, input the height of the rectangle: ");
        double height = sc.nextDouble();
        System.out.print("Finally, please choose a color for the rectanagle: ");
        Color rectangleColor = Color.valueOf(sc.next().toUpperCase());
        AbstractShape s1 = new Circle(circleColor,radius);
        AbstractShape s2 = new Rectangle(rectangleColor,width,height);

        System.out.println("Circle color: "+ s1.getColor());
        System.out.println("Circle area: "+ String.format("%.3f",s1.area()));
        System.out.println("Rectangle color: "+ s2.getColor());
        System.out.println("Rectangle area: "+ String.format("%.3f",s2.area()));
    }
}