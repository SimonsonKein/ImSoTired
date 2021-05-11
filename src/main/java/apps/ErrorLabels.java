package main.java.apps;

import javafx.scene.control.Label;

public class ErrorLabels {
    private Label usernameError1;
    private Label usernameError2;

    private Label firstNameError1;
    private Label firstNameError2;

    private Label secondNameError1;
    private Label secondNameError2;

    private Label emailError1;
    private Label emailError2;

    private Label passwordError1;
    private Label passwordError2;

    private Label confirmPasswordError1;
    private Label confirmPasswordError2;

    private Label loginError;

    public ErrorLabels(Label loginError) {
        this.loginError = loginError;
    }

    public ErrorLabels(Label usernameError1, Label usernameError2,
                       Label firstNameError1, Label firstNameError2,
                       Label secondNameError1, Label secondNameError2,
                       Label emailError1, Label emailError2,
                       Label passwordError1, Label passwordError2,
                       Label confirmPasswordError1, Label confirmPasswordError2) {
        this.usernameError1 = usernameError1;
        this.usernameError2 = usernameError2;
        this.firstNameError1 = firstNameError1;
        this.firstNameError2 = firstNameError2;
        this.secondNameError1 = secondNameError1;
        this.secondNameError2 = secondNameError2;
        this.emailError1 = emailError1;
        this.emailError2 = emailError2;
        this.passwordError1 = passwordError1;
        this.passwordError2 = passwordError2;
        this.confirmPasswordError1 = confirmPasswordError1;
        this.confirmPasswordError2 = confirmPasswordError2;
    }


    public Label getUsernameError1() {
        return usernameError1;
    }

    public Label getUsernameError2() {
        return usernameError2;
    }

    public Label getFirstNameError1() {
        return firstNameError1;
    }

    public Label getFirstNameError2() {
        return firstNameError2;
    }

    public Label getSecondNameError1() {
        return secondNameError1;
    }

    public Label getSecondNameError2() {
        return secondNameError2;
    }

    public Label getEmailError1() {
        return emailError1;
    }

    public Label getEmailError2() {
        return emailError2;
    }

    public Label getPasswordError1() {
        return passwordError1;
    }

    public Label getPasswordError2() {
        return passwordError2;
    }

    public Label getConfirmPasswordError1() {
        return confirmPasswordError1;
    }

    public Label getConfirmPasswordError2() {
        return confirmPasswordError2;
    }

    public Label getLoginError() {
        return loginError;
    }

}
