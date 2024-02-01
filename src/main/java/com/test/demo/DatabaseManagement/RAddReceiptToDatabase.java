package com.test.demo.DatabaseManagement;

import com.test.demo.Models.Receipt;

import java.sql.*;

public class RAddReceiptToDatabase {

    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
    private static final String usernameDB = "root";
    private static final String passwordDB = "CEN2b2023";

    public static int addToDatabase(Receipt newReceipt) throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        int lastInsertedId = -1;

        try (Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
            System.out.println("Connected to the database!");

            String insertQuery = "INSERT INTO receipts (employee_ID, client_ID, total_value, date_of_sale ) VALUES (?,?,?,?)";

            // Creating a prepared statement to safely insert data and prevent SQL injection
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                // Set values for the parameters
                preparedStatement.setInt(1, newReceipt.getEmployeeID());
                preparedStatement.setInt(2, newReceipt.getClientID());
                preparedStatement.setInt(3, newReceipt.getReceiptValue());
                Date date = Date.valueOf(newReceipt.getDate());
                preparedStatement.setDate(4, date);

                // Execute the insert statement
                int rowsAffected = preparedStatement.executeUpdate();

                // Check the number of rows affected to determine if the insert was successful
                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully.");
                    try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            lastInsertedId = generatedKeys.getInt(1);
                        } else {
                            System.out.println("ID not retrieved.");
                        }
                    }

                } else {
                    System.out.println("Data insertion failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastInsertedId;
    }
}
