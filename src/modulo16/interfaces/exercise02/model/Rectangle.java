package modulo16.interfaces.exercise02.model;

public class Rectangle extends AbstractShape {
	private double width;
	private double height;
	public Rectangle() {}
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	@Override
	public double area( ) {
		return getWidth() * getHeight();
	}
}
