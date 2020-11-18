package logo.gui;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logo.gui.custom_controls.CanvasPane;

public class MainWindow
{
	int i = 1;
	
	public void createWindow(Stage primaryStage)
	{
		primaryStage.setTitle("Logo Interpreter");		
		BorderPane root = new BorderPane();
		
		//Set the top part of the screen to the menu bar
		root.setTop(makeMenuBar());
		root.setCenter(makeWorkArea());
		root.setBottom(makeStatusBar());
		
		primaryStage.setScene(new Scene(root, 960, 540));
		primaryStage.show();
	}

	private MenuBar makeMenuBar()
	{
		MenuBar menu = new MenuBar();
		
		Menu file = new Menu("File");
		Menu edit = new Menu("Edit");
		
		menu.getMenus().add(file);
		menu.getMenus().add(edit);
		
		return menu;
	}

	private HBox makeStatusBar() 
	{
		HBox statusBar = new HBox();
		
		Label status = new Label("OK");
		
		statusBar.getChildren().add(status);
		return statusBar;
	}
	
	private SplitPane makeWorkArea()
	{
		ScrollPane scrollpane = new ScrollPane();
		CanvasPane drawArea = new CanvasPane(800,600);
		TextArea codeArea = new TextArea();
		SplitPane centre = new SplitPane();
		
		scrollpane.setContent(drawArea);
		
		centre.getItems().addAll(scrollpane, codeArea);
		centre.setOrientation(Orientation.HORIZONTAL);
		return centre;
	}
}
