package main.java.apps;

import main.java.validators.Validate;

public class ShowErrors {
    public void showErrors(ErrorLabels errorLabels) {
        if (Validate.invalidData.containsKey("username")) {
            switch (Validate.invalidData.get("username").size()) {
                case 1 -> errorLabels.getUsernameError1().setText(Validate.invalidData.get("username").get(0));
                case 2 -> {
                    errorLabels.getUsernameError1().setText(Validate.invalidData.get("username").get(0));
                    errorLabels.getUsernameError2().setText(Validate.invalidData.get("username").get(1));
                }
            }
        }
        if (Validate.invalidData.containsKey("firstName")) {
            switch (Validate.invalidData.get("firstName").size()) {
                case 1 -> errorLabels.getFirstNameError1().setText(Validate.invalidData.get("firstName").get(0));
                case 2 -> {
                    errorLabels.getFirstNameError1().setText(Validate.invalidData.get("firstName").get(0));
                    errorLabels.getFirstNameError2().setText(Validate.invalidData.get("firstName").get(1));
                }
            }
        }
        if (Validate.invalidData.containsKey("secondName")) {
            switch (Validate.invalidData.get("secondName").size()) {
                case 1 -> errorLabels.getSecondNameError1().setText(Validate.invalidData.get("secondName").get(0));
                case 2 -> {
                    errorLabels.getSecondNameError1().setText(Validate.invalidData.get("secondName").get(0));
                    errorLabels.getSecondNameError2().setText(Validate.invalidData.get("secondName").get(1));
                }
            }
        }
        if (Validate.invalidData.containsKey("email")) {
            switch (Validate.invalidData.get("email").size()) {
                case 1 -> errorLabels.getEmailError1().setText(Validate.invalidData.get("email").get(0));
                case 2 -> {
                    errorLabels.getEmailError1().setText(Validate.invalidData.get("email").get(0));
                    errorLabels.getEmailError2().setText(Validate.invalidData.get("email").get(1));
                }
            }
        }
        if (Validate.invalidData.containsKey("password")) {
            switch (Validate.invalidData.get("password").size()) {
                case 1 -> errorLabels.getPasswordError1().setText(Validate.invalidData.get("password").get(0));
                case 2 -> {
                    errorLabels.getPasswordError1().setText(Validate.invalidData.get("password").get(0));
                    errorLabels.getPasswordError2().setText(Validate.invalidData.get("password").get(1));
                }
            }
        }
        if (Validate.invalidData.containsKey("confirmPassword")) {
            switch (Validate.invalidData.get("confirmPassword").size()) {
                case 1 -> errorLabels.getConfirmPasswordError1().setText(Validate.invalidData.get("confirmPassword").get(0));
                case 2 -> {
                    errorLabels.getConfirmPasswordError1().setText(Validate.invalidData.get("confirmPassword").get(0));
                    errorLabels.getConfirmPasswordError2().setText(Validate.invalidData.get("confirmPassword").get(1));
                }
            }
        }
    }

    public void showLoginError(ErrorLabels errorLabels) {
            errorLabels.getLoginError().setText("Username or password are incorrect");
            if (Validate.invalidData.get("username").toString().equals("Text Field is Empty") ||
                    Validate.invalidData.get("password").toString().equals("Text Field is Empty")){
                errorLabels.getLoginError().setText("Username or password are empty");
            }
    }
}
