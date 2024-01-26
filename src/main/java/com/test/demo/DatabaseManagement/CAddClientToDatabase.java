package com.test.demo.DatabaseManagement;

import com.test.demo.Models.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CAddClientToDatabase {


    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
    private static final String usernameDB = "root";
    private static final String passwordDB = "CEN2b2023";

    public static void addToDatabase(Client newClient) throws ClassNotFoundException {

        boolean addedToDatabase = false;
        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("DATABASE");
        try (Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
            System.out.println("Connected to the database!");

            String insertQuery = "INSERT INTO clients (first_name, last_name, points, address ) VALUES (?,?, ?, ?)";

            // Creating a prepared statement to safely insert data and prevent SQL injection
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set values for the parameters
                preparedStatement.setString(1, newClient.getFirstName());
                preparedStatement.setString(2, newClient.getLastName());
                preparedStatement.setInt(3, newClient.getPoints());
                preparedStatement.setString(4, newClient.getAddress());

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
