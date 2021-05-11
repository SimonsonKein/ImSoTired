package main.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.*;

public class AccountFormController {

    @FXML
    private Label helloLabel;

    @FXML
    void initialize(){
//        helloLabel.setText(username);
    }

    public void setHelloLabel(String username) {
        helloLabel.setText("Hello, " + username);
    }
}
