package com.test.demo.DatabaseManagement;

import com.test.demo.Models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UAddUserToDatabase {


    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
    private static final String usernameDB = "root";
    private static final String passwordDB = "CEN2b2023";

    public static void addToDatabase(User newUser) throws ClassNotFoundException, SQLException {

        boolean addedToDatabase = false;
        Class.forName("com.mysql.cj.jdbc.Driver");


            try (Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
                System.out.println("Connected to the database!");

                String insertQuery = "INSERT INTO employees (first_name, last_name, username, password,status_of_employee ) VALUES (?,?, ?, ?, ?)";

                // Creating a prepared statement to safely insert data and prevent SQL injection
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    // Set values for the parameters
                    preparedStatement.setString(1, newUser.getFirstName());
                    preparedStatement.setString(2, newUser.getLastName());
                    preparedStatement.setString(3, newUser.getUsername());
                    preparedStatement.setString(4, newUser.getPassword());
                    preparedStatement.setBoolean(5, newUser.getIsAdmin());
                    // Execute the insert statement
                    int rowsAffected = preparedStatement.executeUpdate();

                    // Check the number of rows affected to determine if the insert was successful
                    if (rowsAffected > 0) {
                        System.out.println("Data inserted successfully.");
                        addedToDatabase = true;

                    } else {
                        System.out.println("Data insertion failed.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


    }
}
