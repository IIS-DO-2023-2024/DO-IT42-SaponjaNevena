package geometry;
import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	private int innerRadius;
	private Point getCenter;

	public Donut() {

	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		setInnerRadius(innerRadius);
	}
	
	public Donut(Point center, int radius, int innerRadius, Color outlineColor, Color fillColor) {
		this(center, radius, innerRadius);
		this.color = outlineColor;
		this.fillColor = fillColor;
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		/*
		 * setCenter(center); // ostalo je private this.radius = radius; // moze
		 * jer je protected setSelected(selected); this.innerRadius =
		 * innerRadius;
		 */
		super(center, radius, selected);
		this.innerRadius = innerRadius;
	}
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut pomocni = (Donut) obj;
			if (super.equals(pomocni) && this.innerRadius == pomocni.innerRadius) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void fill(Graphics g) {
		super.fill(g);
		g.setColor(Color.white);
		g.fillOval(this.getCenter().getX() - this.innerRadius + 1,
				this.getCenter().getY() - this.innerRadius + 1,
				this.innerRadius * 2 - 2,
				this.innerRadius * 2 - 2);
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		this.fill(g);
		g.setColor(color);
		g.drawOval(getCenter().getX() - innerRadius, 
				getCenter().getY() - innerRadius, 
				innerRadius * 2,
				innerRadius * 2);
		if (this.isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.getCenter().getX() - 2, this.getCenter().getY() - 2, 4, 4);
			g.drawRect(this.getCenter().getX() - this.innerRadius - 2, this.getCenter().getY() - 2, 4, 4);
			g.drawRect(this.getCenter().getX() + this.innerRadius - 2, this.getCenter().getY() - 2, 4, 4);
			g.drawRect(this.getCenter().getX() - 2, this.getCenter().getY() - this.innerRadius - 2, 4, 4);
			g.drawRect(this.getCenter().getX() - 2, this.getCenter().getY() + this.innerRadius - 2, 4, 4);
		}
	}
	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) throws IllegalArgumentException {
		if (innerRadius <= 0) {
			throw new IllegalArgumentException("Inner radius must be positive!");			
		}
		if (innerRadius >= radius) {
			throw new IllegalArgumentException("Outer radius must be bigger than inner radius!");
		}
		this.innerRadius = innerRadius;
	}

	public String toString() {
		// Center=(x,y), radius= radius, innerRadius= innerRadius
		return super.toString() + ", innerRadius=" + innerRadius;
	}

	public boolean contains(int x, int y) {
		return super.contains(x, y) && getCenter().distance(x, y) >= innerRadius;
	}

	public boolean contains(Point clickPoint) {
		return super.contains(clickPoint) && getCenter().distance(clickPoint.getX(), clickPoint.getY()) <= innerRadius;
	}

}