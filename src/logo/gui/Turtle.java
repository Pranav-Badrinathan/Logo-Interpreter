package logo.gui;

import javafx.scene.canvas.Canvas;
import logo.util.Vector2;

public class Turtle
{
	public boolean visible = true;
	public Vector2 position = new Vector2();
	
	public Pen currentPen = new Pen();
	
	public Turtle(Canvas canvas)
	{
		drawTurtle(canvas);
	}
	
	private void drawTurtle(Canvas canvas) 
	{
		
	}
}
