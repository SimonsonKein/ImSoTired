package main.java.apps;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.io.IOException;

public class WindowCommands {
    public void openWindow(String filePath){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(filePath));

        try {
            loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    public void hideWindow(Button btn){
        btn.getScene().getWindow().hide();

    }

    public void closeWindow(String filePath){

    }
}
