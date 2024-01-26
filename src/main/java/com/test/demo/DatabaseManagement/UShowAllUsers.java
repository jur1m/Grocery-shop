package com.test.demo.DatabaseManagement;
import com.test.demo.Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UShowAllUsers {
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
    private static final String usernameDB = "root";
    private static final String passwordDB = "CEN2b2023";

    public static <Connection> ObservableList getUsers() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        ObservableList<User> list = FXCollections.observableArrayList();


        try (java.sql.Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
            System.out.println("Connected to the database!");

            final String employee_ID = "employee_ID";
            final String first_name = "first_name";
            final String last_name = "last_name";
            final String status_of_employee = "status_of_employee";
            final String usernameString = "username";
            final String passwordString = "password";

            String insertQuery = "SELECT * FROM employees;";

            // Creating a prepared statement to safely insert data and prevent SQL injection
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {

                    User temp = new User();
                    temp.setFirstName(resultSet.getString(first_name));
                    temp.setLastName(resultSet.getString(last_name));
                    temp.setUsername(resultSet.getString(usernameString));
                    temp.setPassword(resultSet.getString(passwordString));
                    temp.setID(resultSet.getInt(employee_ID));
                    temp.setIsAdmin(resultSet.getBoolean(status_of_employee));


                    list.add(temp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
