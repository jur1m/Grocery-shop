package com.test.demo.DatabaseManagement;

import com.test.demo.Models.Client;
import com.test.demo.Models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CModifyClient {

        private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
        private static final String usernameDB = "root";
        private static final String passwordDB = "CEN2b2023";

        public static void modifyData(Client modClient, int ID) throws ClassNotFoundException, SQLException {


            Class.forName("com.mysql.cj.jdbc.Driver");


            try (Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
                System.out.println("Connected to the database!");

                String insertQuery = "UPDATE clients SET first_name = ?, last_name = ?, address = ?, points = ? WHERE client_ID = ?;";

                // Creating a prepared statement to safely insert data and prevent SQL injection
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    // Set values for the parameters
                    preparedStatement.setString(1, modClient.getFirstName());
                    preparedStatement.setString(2, modClient.getLastName());
                    preparedStatement.setString(3, modClient.getAddress());
                    preparedStatement.setInt(4, modClient.getPoints());
                    preparedStatement.setInt(5,ID);

                    // Execute the insert statement
                    int rowsAffected = preparedStatement.executeUpdate();

                    // Check the number of rows affected to determine if  modify was successful
                    if (rowsAffected > 0) {
                        System.out.println("Data inserted successfully.");

                    } else {
                        System.out.println("Data insertion failed.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


}
