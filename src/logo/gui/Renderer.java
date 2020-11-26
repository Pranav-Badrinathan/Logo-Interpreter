package logo.gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import logo.gui.custom_controls.CanvasPane;
import logo.util.Vector2;

public class Renderer
{
	private static GraphicsContext gc;
	private static Canvas canvas;
	
	public static void initializeRenderer(Canvas canvas) 
	{
		Renderer.canvas = canvas;
		Renderer.gc = canvas.getGraphicsContext2D();
	}
	
	public static void drawLine(Vector2 startPoint, Vector2 endPoint, Pen pen) 
	{
		startPoint = CanvasPane.turtleToCanvasCoords(startPoint, Renderer.canvas);
		endPoint = CanvasPane.turtleToCanvasCoords(endPoint, Renderer.canvas);
		
		gc.setStroke(pen.penColor);
		gc.setLineWidth(pen.penSize);
		gc.strokeLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
	}
	
	// This is not used... for now. Probably will be reused for something else.
	public static Vector2 rotatePoint(Vector2 toRotate, Vector2 toRotateAround, double rotation)
	{	
		Vector2 rotatedPoint = new Vector2();
		double distBetweenPoints = toRotateAround.distance(toRotate) * Math.signum(toRotate.x);
		
		// hyp * cos(θ)
		rotatedPoint.x = (distBetweenPoints * Math.cos(Math.toRadians(rotation)));
		// hyp * sin(θ)
		rotatedPoint.y = (distBetweenPoints * Math.sin(Math.toRadians(rotation)));
		
		System.out.println(rotatedPoint);
		
		return rotatedPoint;
	}
}
