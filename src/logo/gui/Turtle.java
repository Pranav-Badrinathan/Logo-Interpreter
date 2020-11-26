package logo.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import logo.gui.custom_controls.CanvasPane;
import logo.util.Vector2;

public class Turtle extends Polygon
{
	public boolean visible = true;
	
	public double rotation;
	public Vector2 position;
	private Rotate rotate;
	
	public Pen currentPen;
	public static final Pen defaultPen = new Pen();
	
	private CanvasPane pane;

	public Turtle(Vector2 position, double rotation, Pen pen, CanvasPane pane)
	{
		this.currentPen = pen;
		this.position = position;
		this.rotation = rotation;
		this.pane = pane;
		
		drawTurtle();
	}
	
	public Turtle(CanvasPane pane)
	{
		this(new Vector2(), 45, new Pen(), pane);
	}
	
	public void reDraw() 
	{
		rotate.setAngle(rotation);
	}
	
	private void drawTurtle() 
	{	
		this.setFill(Color.TRANSPARENT);
		this.setStroke(Color.BLACK);
		
		Vector2[] vertices = new Vector2[3];
		vertices[0] = new Vector2(position.x, position.y + 25);
		vertices[1] = new Vector2(position.x - 25, position.y);
		vertices[2] = new Vector2(position.x + 25, position.y);
		
		for (int i = 0; i < vertices.length; i++)
		{
			Vector2 vert = vertices[i];
			vertices[i] = CanvasPane.turtleToCanvasCoords(vert, pane.canvas);
		}
		
		rotate = new Rotate();
		rotate.setPivotY(CanvasPane.turtleToCanvasCoords(position, pane.canvas).y);
		rotate.setPivotX(CanvasPane.turtleToCanvasCoords(position, pane.canvas).x);
		rotate.setAngle(rotation);
		
		this.getTransforms().add(rotate);
		
		addV2Points(vertices);
	}
	
	private void addV2Points(Vector2[] verts) 
	{
		this.getPoints().addAll(new Double[] {
				verts[0].x, verts[0].y,
				verts[1].x, verts[1].y,
				verts[2].x, verts[2].y
				});
	}
}
