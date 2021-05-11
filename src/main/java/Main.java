package main.java;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.apps.FXMLPaths;
import main.java.apps.WindowCommands;

public class Main extends Application {
    public static void main(String[] args)  {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        WindowCommands windowCommands = new WindowCommands();
        windowCommands.openWindow(FXMLPaths.LoginFormPath);
    }
}
