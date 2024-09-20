package exercicio05.entities;

import exercicio05.entities.enums.Color;

public abstract class Shape {
	private Color color;

	public Shape( ) {
	}

	public Shape( Color color ) {
		this.color = color;
	}

	public Color getColor( ) {
		return color;
	}

	public void setColor( String color ) {
		this.color = Color.valueOf( color );
	}

	public abstract double area( );

}
