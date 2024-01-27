package com.test.demo.DatabaseManagement;


import com.test.demo.Models.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PAddProductDB {
        private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
        private static final String usernameDB = "root";
        private static final String passwordDB = "CEN2b2023";

        public static void addToDatabase(Product newProduct) throws ClassNotFoundException {


            Class.forName("com.mysql.cj.jdbc.Driver");


            try (Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
                System.out.println("Connected to the database!");

                String insertQuery = "INSERT INTO product (name_of_the_product, price, stock, category_ID ) VALUES (?,?, ?, ?)";

                // Creating a prepared statement to safely insert data and prevent SQL injection
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    // Set values for the parameters
                    preparedStatement.setString(1, newProduct.getProductName());
                    preparedStatement.setInt(2, newProduct.getPricePerUnit());
                    preparedStatement.setInt(3, newProduct.getStock());
                    preparedStatement.setInt(4, newProduct.getCategory());

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
