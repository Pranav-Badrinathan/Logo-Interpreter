package logo.gui;

import javafx.scene.paint.Color;

public class Pen
{
	public double penSize;
	public Color penColor;
	public Color fillColor;
	public boolean isDrawing;
	
	public Pen(double size, Color penColor, Color fillColor)
	{
		this.penSize = size;
		this.penColor = penColor;
		this.fillColor = fillColor;
		this.isDrawing = true;
	}
	
	public Pen() 
	{
		defaultPen();
	}
	
	public void defaultPen() 
	{
		this.penSize = 1;
		this.penColor = Color.BLACK;
		this.fillColor = Color.BLACK;
		this.isDrawing = true;
	}
}
