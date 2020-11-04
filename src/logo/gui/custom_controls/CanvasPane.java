package logo.gui.custom_controls;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

public class CanvasPane extends Pane
{
	public final Canvas canvas;

    public CanvasPane(double width, double height) 
    {
        setWidth(width);
        setHeight(height);
        canvas = new Canvas(width, height);
        getChildren().add(canvas);

        canvas.widthProperty().bind(this.widthProperty());
        canvas.heightProperty().bind(this.heightProperty());
    }
}
