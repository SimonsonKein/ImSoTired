package main.java.apps;

public class User {
    private String username;
    private String firstName;
    private String secondName;
    private String email;
    private String password;

    public User(String username, String firstName, String secondName, String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
