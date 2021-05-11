package main.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.java.apps.FXMLPaths;
import main.java.apps.WindowCommands;
import main.java.validators.ValidateResult;

public class SignUpFormController {
    @FXML
    private TextField usernameField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField secondNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField confirmPasswordField;

    @FXML
    private Button signUpBtn;

    @FXML
    private Button toLogInBtn;

    @FXML
    private Label usernameError1;
    @FXML
    private Label usernameError2;

    @FXML
    private Label firstNameError1;
    @FXML
    private Label firstNameError2;

    @FXML
    private Label secondNameError1;
    @FXML
    private Label secondNameError2;

    @FXML
    private Label emailError1;
    @FXML
    private Label emailError2;

    @FXML
    private Label passwordError1;
    @FXML
    private Label passwordError2;

    @FXML
    private Label confirmPasswordError1;
    @FXML
    private Label confirmPasswordError2;

    @FXML
    void initialize() {

        toLogInBtn.setOnAction(event -> {
            toLogInBtn.getScene().getWindow().hide();
            new WindowCommands().openWindow(FXMLPaths.LoginFormPath);
        });

        signUpBtn.setOnAction(event -> {
            String username = usernameField.getText().trim();
            String firstName = firstNameField.getText().trim();
            String secondName = secondNameField.getText().trim();
            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();
            String confirmPassword = confirmPasswordField.getText().trim();

            ValidateResult validateResult = new ValidateResult();
            if (validateResult.signUpUser(username, firstName, secondName, email, password, confirmPassword,
                    usernameError1, usernameError2, firstNameError1, firstNameError2,
                    secondNameError1, secondNameError2, emailError1, emailError2,
                    passwordError1, passwordError2, confirmPasswordError1, confirmPasswordError2)) {
                signUpBtn.getScene().getWindow().hide();
                new WindowCommands().openWindow(FXMLPaths.LoginFormPath);
            }


        });
    }

}