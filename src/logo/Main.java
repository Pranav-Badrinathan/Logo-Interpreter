package logo;

import javafx.application.Application;
import javafx.stage.Stage;
import logo.gui.MainWindow;
import logo.interpreter.Lexer;

public class Main extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		new MainWindow().createWindow(primaryStage);
	}
}
