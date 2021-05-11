package main.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.apps.FXMLPaths;
import main.java.apps.WindowCommands;
import main.java.validators.ValidateResult;

public class LoginFormController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginBtn;

    @FXML
    private Button toSignUpBtn;

    @FXML
    private Label loginError;


    @FXML
    void initialize() {
        loginBtn.setOnAction(event -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            ValidateResult validateResult = new ValidateResult();
            if (validateResult.loginUser(username, password, loginError)){
                loginBtn.getScene().getWindow().hide();
                WindowCommands windowCommands = new WindowCommands();
                windowCommands.openWindow(FXMLPaths.AccountFormPath);
            }

        });

        toSignUpBtn.setOnAction(event -> {
            toSignUpBtn.getScene().getWindow().hide();
            WindowCommands windowCommands = new WindowCommands();
            windowCommands.openWindow(FXMLPaths.SignUpFormPath);
        });
    }
}
