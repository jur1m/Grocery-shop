package com.test.demo.DatabaseManagement;

import java.sql.*;

public class RDAddReceiptDetailsToDB {


        private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
        private static final String usernameDB = "root";
        private static final String passwordDB = "CEN2b2023";

        public static void addToDatabase(int productID, int quantity,int receiptID) throws ClassNotFoundException {


            Class.forName("com.mysql.cj.jdbc.Driver");


            try (Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
                System.out.println("Connected to the database!");

                String insertQuery = "INSERT INTO receipt_details (product_ID, quantity, receipt_ID ) VALUES (?,?,?)";

                // Creating a prepared statement to safely insert data and prevent SQL injection
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    // Set values for the parameters
                    preparedStatement.setInt(1, productID);
                    preparedStatement.setInt(2, quantity);
                    preparedStatement.setInt(3, receiptID);

                    // Execute the insert statement
                    int rowsAffected = preparedStatement.executeUpdate();

                    // Check the number of rows affected to determine if the insert was successful
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
