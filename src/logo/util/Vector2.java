package logo.util;

import javafx.geometry.Point2D;

public class Vector2
{
	public double x;
	public double y;

	public Vector2(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public Vector2()
	{
		this.x = (this.y = 0);
	}

	public double distance(Vector2 endPoint)
	{
		// √((x_2-x_1)²+(y_2-y_1)²)
		return Math.sqrt(Math.pow((endPoint.x - this.x), 2) + Math.pow((endPoint.y - this.y), 2));
	}

	public Point2D getToPoint2D()
	{
		return new Point2D(x, y);
	}
	
	public void setFromPoint2D(Point2D point)
	{
		this.x = point.getX();
		this.y = point.getY();
	}
	
	public static Vector2 fromPoint2D(Point2D point)
	{
		return new Vector2(point.getX(), point.getY());
	}
	
	@Override
	public String toString()
	{
		return "Vector2 " + "[x = " + x + ", " + "y = " + y + "]";
	}
}
