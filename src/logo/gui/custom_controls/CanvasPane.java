package logo.gui.custom_controls;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import logo.gui.Turtle;
import logo.util.Vector2;

public class CanvasPane extends Pane
{
	public final Canvas canvas;
	public final Turtle turtle;

	public CanvasPane(double width, double height)
	{
		setWidth(width);
		setHeight(height);
		canvas = new Canvas(width, height);
		turtle = new Turtle(this);
		getChildren().addAll(canvas, turtle);
		
		canvas.widthProperty().bind(this.widthProperty());
		canvas.heightProperty().bind(this.heightProperty());
	}

	public static Vector2 canvasToTurtleCoords(double x, double y, Canvas canvas)
	{
		return new Vector2(x - (canvas.getWidth() / 2), (canvas.getHeight() / 2) + y);
	}

	public static Vector2 turtleToCanvasCoords(double x, double y, Canvas canvas)
	{
		return new Vector2(x + (canvas.getWidth() / 2), (canvas.getHeight() / 2) - y);
	}

	public static Vector2 canvasToTurtleCoords(Vector2 coords, Canvas canvas)
	{
		return canvasToTurtleCoords(coords.x, coords.y, canvas);
	}

	public static Vector2 turtleToCanvasCoords(Vector2 coords, Canvas canvas)
	{
		return turtleToCanvasCoords(coords.x, coords.y, canvas);
	}
}
