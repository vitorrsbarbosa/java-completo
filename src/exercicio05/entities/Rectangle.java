package exercicio05.entities;

import exercicio05.entities.enums.Color;

public class Rectangle extends Shape {
	private double width;
	private double height;

	public Rectangle( ) {
	}

	public Rectangle( Color color, double width, double height ) {
		super( );
		this.width = width;
		this.height = height;
	}

	public double getWidth( ) {
		return width;
	}

	public void setWidth( double width ) {
		this.width = width;
	}

	@Override
	public double area( ) {
		return width * height;
	}
}
