package main.java.apps;

import java.sql.*;
import java.util.ArrayList;

public class DBHandler extends Config {
    Connection conn;

    public Connection getConn() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        conn = DriverManager.getConnection(url, dbUser, dbPass);

        return conn;
    }

    public void signUpUserStatement(User user) {
        String insert = "INSERT INTO " + Const.USERS_TABLE + "(" + Const.USERS_USERNAME + "," + Const.USERS_FIRSTNAME +
                "," + Const.USERS_SECONDNAME + "," + Const.USERS_EMAIL + "," + Const.USERS_PASSWORD + ")" +
                "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getConn().prepareStatement(insert);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getSecondName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public boolean loginUserStatement(User user) {
        String selectUsername = "SELECT * " +
                " FROM " + Const.USERS_TABLE +
                " WHERE " + Const.USERS_USERNAME + "='" + user.getUsername() + "' AND " +
                Const.USERS_PASSWORD + "='" + user.getPassword() + "'";
        try {
            Statement statement = getConn().createStatement();
            ResultSet rs = statement.executeQuery(selectUsername);
            return rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<String> getUserDataStatement(User user) {
        String selectData = "SELECT * " +
                " FROM " + Const.USERS_TABLE +
                " WHERE " + Const.USERS_USERNAME + "='" + user.getUsername() + "' AND " +
                Const.USERS_PASSWORD + "='" + user.getPassword() + "'";
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Statement statement = getConn().createStatement();
            ResultSet rs = statement.executeQuery(selectData);
            if (rs.next()) {
                arrayList.add(user.getUsername());
                arrayList.add(user.getFirstName());
                arrayList.add(user.getSecondName());
                arrayList.add(user.getEmail());
                arrayList.add(user.getPassword());
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return arrayList;
    }
}