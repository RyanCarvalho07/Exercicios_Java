package entities;

import entities_enum.Color;

public class Rectangle extends Shape {

	private Double whidth;
	private Double height;

	public Rectangle() {
		super();
	}

	public Rectangle(Color color, Double whidth, Double height) {
		super(color);
		this.whidth = whidth;
		this.height = height;
	}

	public Double getWhidth() {
		return whidth;
	}

	public void setWhidth(Double whidth) {
		this.whidth = whidth;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Override
	public Double area() {
		return whidth * height;
	}

}
