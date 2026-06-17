package modulo16.interfaces.exercise02.model;

import modulo16.interfaces.exercise02.enums.Color;
import modulo16.interfaces.exercise02.services.Shape;

public abstract class AbstractShape implements Shape {
	private Color color;

	public AbstractShape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
