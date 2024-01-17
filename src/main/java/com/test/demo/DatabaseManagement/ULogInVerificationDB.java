package com.test.demo.DatabaseManagement;
import com.test.demo.Models.User;

import java.sql.*;


public class ULogInVerificationDB {

    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
    private static final String usernameDB = "root";
    private static final String passwordDB = "CEN2b2023";

    public static User checkUser(String username, String password) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        User temp = new User();

        try (Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
            System.out.println("Connected to the database!");



            String insertQuery = "SELECT * FROM employees WHERE username = ? AND password = ?;";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                preparedStatement.setString(1,username);
                preparedStatement.setString(2,password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {


                        temp.setUsername(resultSet.getString(("username")));
                        temp.setPassword(resultSet.getString("password"));

                    }
                    else{
                        temp.setUsername("N404");
                    }
                }}
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }

}
