package main.java.apps;

public class ClearErrors {
    public void clearRegistrationErrors(ErrorLabels errorLabels) {
        errorLabels.getUsernameError1().setText("");
        errorLabels.getUsernameError2().setText("");
        errorLabels.getFirstNameError1().setText("");
        errorLabels.getFirstNameError2().setText("");
        errorLabels.getSecondNameError1().setText("");
        errorLabels.getSecondNameError2().setText("");
        errorLabels.getEmailError1().setText("");
        errorLabels.getEmailError2().setText("");
        errorLabels.getPasswordError1().setText("");
        errorLabels.getPasswordError2().setText("");
        errorLabels.getConfirmPasswordError1().setText("");
        errorLabels.getConfirmPasswordError2().setText("");
    }

    public void clearLoginError(ErrorLabels errorLabels) {
        errorLabels.getLoginError().setText("");
    }
}
