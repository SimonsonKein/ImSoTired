package main.java.validators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static HashMap<String, String> validData = new HashMap();
    public static HashMap<String, ArrayList<String>> invalidData = new HashMap();

    private ArrayList<String> errorList = new ArrayList();

    private boolean checkForAnySpecialSymbol(String string) {
        String specialSymbols = "[`!@#$%^&*()_+\\-=\\[\\]\\{};':\\\"\\\\|,.<>\\/?~]+";
        Pattern pattern = Pattern.compile(specialSymbols);
        Matcher matcher = pattern.matcher(string);

        return matcher.find();
    }

    private boolean checkForAnyDecimals(String string) {
        String numbers = "\\d+";
        Pattern pattern = Pattern.compile(numbers);
        Matcher matcher = pattern.matcher(string);

        return matcher.find();
    }

    private boolean checkEmailPattern(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }


    private void validateUsername(String username) {
        if (username.isEmpty()) {
            errorList.add("Text Field is Empty");
            invalidData.put("username", new ArrayList<>(errorList));
        } else if (username.length() <= 4 || username.length() >= 30 ||
                checkForAnySpecialSymbol(username)) {

            if (username.length() <= 4 || username.length() >= 30) {
                errorList.add("Username should be longer than 4 symbols and shorter than 30");
            }
            if (checkForAnySpecialSymbol(username)) {
                errorList.add("Username shouldn't contain symbols");
            }

            invalidData.put("username", new ArrayList<>(errorList));
        } else {
            validData.put("username", username);
        }

        errorList.clear();
    }

    private void validateFirstName(String firstName) {
        if (firstName.isEmpty()) {
            errorList.add("Text Field is Empty");
            invalidData.put("firstName", new ArrayList<>(errorList));
        } else if (firstName.length() <= 1 || firstName.length() >= 30 ||
                checkForAnySpecialSymbol(firstName) || checkForAnyDecimals(firstName)) {

            if (firstName.length() <= 1 || firstName.length() >= 30) {
                errorList.add("First Name must be longer than 1 symbols and shorter than 30");
            }
            if (checkForAnySpecialSymbol(firstName) || checkForAnyDecimals(firstName)) {
                errorList.add("First Name shouldn't contain symbols and decimals");
            }

            invalidData.put("firstName", new ArrayList<>(errorList));
        } else {
            validData.put("firstName", firstName);
        }

        errorList.clear();
    }

    private void validateSecondName(String secondName) {
        if (secondName.isEmpty()) {
            errorList.add("Text Field is Empty");
            invalidData.put("secondName", new ArrayList<>(errorList));
        } else if (secondName.length() <= 1 || secondName.length() >= 30 ||
                checkForAnySpecialSymbol(secondName) || checkForAnyDecimals(secondName)) {

            if (secondName.length() <= 1 || secondName.length() >= 30) {
                errorList.add("Second Name must be longer than 1 symbols and shorter than 30");
            }
            if (checkForAnySpecialSymbol(secondName) || checkForAnyDecimals(secondName)) {
                errorList.add("Second Name shouldn't contain symbols and decimals");
            }

            invalidData.put("secondName", new ArrayList<>(errorList));
        } else {
            validData.put("secondName", secondName);
        }

        errorList.clear();
    }

    private void validateEmail(String email) {
        if (email.isEmpty()) {
            errorList.add("Text Field is Empty");
            invalidData.put("email", new ArrayList<>(errorList));
        } else if (email.length() <= 5 || email.length() >= 50 ||
                !checkEmailPattern(email)) {

            if (email.length() <= 5 || email.length() >= 50) {
                errorList.add("Email must be longer than 5 symbols and shorter than 50");
            }
            if (!checkEmailPattern(email)) {
                errorList.add("Email is incorrect");
            }

            invalidData.put("email", new ArrayList<>(errorList));
        } else {
            validData.put("email", email);
        }

        errorList.clear();
    }

    private void validatePassword(String password) {
        if (password.isEmpty()) {
            errorList.add("Text Field is Empty");
            invalidData.put("password", new ArrayList<>(errorList));
        } else if (password.length() <= 5 || password.length() >= 20 ||
                checkForAnySpecialSymbol(password)) {

            if (password.length() <= 5 || password.length() >= 20) {
                errorList.add("Password must be longer than 5 symbols and shorter than 20");
            }
            if (checkForAnySpecialSymbol(password)) {
                errorList.add("Password shouldn't contain symbols");
            }

            invalidData.put("password", new ArrayList<>(errorList));
        } else {
            validData.put("password", password);
        }

        errorList.clear();
    }

    private void validateConfirmPassword(String password) {
        if (password.isEmpty()) {
            errorList.add("Text Field is Empty");
            invalidData.put("confirmPassword", new ArrayList<>(errorList));
        } else if (password.length() <= 5 || password.length() >= 20 ||
                checkForAnySpecialSymbol(password)) {

            if (password.length() <= 5 || password.length() >= 20) {
                errorList.add("Confirm Password must be longer than 5 symbols and shorter than 20");
            }
            if (checkForAnySpecialSymbol(password)) {
                errorList.add("Confirm Password shouldn't contain symbols");
            }

            invalidData.put("confirmPassword", new ArrayList<>(errorList));
        } else {
            validData.put("confirmPassword", password);
        }

        errorList.clear();
    }

    public boolean validateForLogin(String username, String password) {
        validData.clear();
        invalidData.clear();

        validateUsername(username);
        validatePassword(password);

        return invalidData.size() == 0;
    }

    public boolean validateForRegistration(
            String username, String firstName, String secondName,
            String email, String password, String confirmPassword) {

        validData.clear();
        invalidData.clear();

        validateUsername(username);
        validateFirstName(firstName);
        validateSecondName(secondName);
        validateEmail(email);
        validatePassword(password);
        validateConfirmPassword(confirmPassword);

        return invalidData.size() == 0;
    }

}
