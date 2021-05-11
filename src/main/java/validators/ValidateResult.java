package main.java.validators;

import javafx.scene.control.Label;
import main.java.apps.*;

import java.util.ArrayList;

public class ValidateResult {
    public boolean signUpUser(
            String username, String firstName, String secondName,
            String email, String password, String confirmPassword,
            Label usernameError1, Label usernameError2, Label firstNameError1,
            Label firstNameError2, Label secondNameError1, Label secondNameError2,
            Label emailError1, Label emailError2, Label passwordError1,
            Label passwordError2, Label confirmPasswordError1, Label confirmPasswordError2) {

        Validate validate = new Validate();
        if (!password.equals(confirmPassword)) {
            ArrayList<String> error = new ArrayList<>();
            error.add("Passwords are incorrect");
            Validate.invalidData.put("password", error);
            Validate.invalidData.put("confirmPassword", error);
        }
        boolean validateRegistrationData =
                validate.validateForRegistration(username, firstName, secondName, email, password, confirmPassword);

        ErrorLabels errorLabels = new ErrorLabels(usernameError1, usernameError2, firstNameError1, firstNameError2,
                secondNameError1, secondNameError2, emailError1, emailError2, passwordError1, passwordError2,
                confirmPasswordError1, confirmPasswordError2);

        new ClearErrors().clearRegistrationErrors(errorLabels);

        if (!validateRegistrationData) {
            ShowErrors showErrors = new ShowErrors();
            showErrors.showErrors(errorLabels);
            return false;
        } else {
            User user = new User(username, firstName, secondName, email, password);

            DBHandler dbHandler = new DBHandler();
            dbHandler.signUpUserStatement(user);
            return true;
        }
    }

    public boolean loginUser(String username, String password,
                             Label error) {

        Validate validate = new Validate();
        boolean validateLoginData = validate.validateForLogin(username, password);

        DBHandler dbHandler = new DBHandler();
        User user = new User(username, password);
        ErrorLabels errorLabels = new ErrorLabels(error);
        new ClearErrors().clearLoginError(errorLabels);

        if (!validateLoginData || !dbHandler.loginUserStatement(user)) {
            ShowErrors showErrors = new ShowErrors();
            showErrors.showLoginError(errorLabels);
            return false;
        } else {
            ArrayList<String> userData = dbHandler.getUserDataStatement(user);
            new User(userData.get(0), userData.get(1), userData.get(2), userData.get(3), userData.get(4));
            return true;
        }
    }
}
