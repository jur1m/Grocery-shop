package com.test.demo.DatabaseManagement;

import com.test.demo.Models.Category;
import com.test.demo.Models.Supplier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SModifySupplier {
        private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
        private static final String usernameDB = "root";
        private static final String passwordDB = "CEN2b2023";

        public static void modifyData(Supplier modSupplier, int ID) throws ClassNotFoundException, SQLException {


            Class.forName("com.mysql.cj.jdbc.Driver");


            try (Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
                System.out.println("Connected to the database!");

                String insertQuery = "UPDATE supplier SET supplier_name = ? WHERE supplier_ID = ?;";

                // Creating a prepared statement to safely insert data and prevent SQL injection
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    // Set values for the parameters
                    preparedStatement.setString(1, modSupplier.getSupplierName());
                    preparedStatement.setInt(2,ID);

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
