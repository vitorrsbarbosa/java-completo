package modulo16.interfaces.exercise02.model;

import modulo16.interfaces.exercise02.services.Shape;

public class Circle extends AbstractShape {
	private double radius;
	public Circle() {}
	public Circle(double radius) {
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	@Override
	public double area( ) {
		return Math.PI * getRadius() * getRadius();
	}
}
