package com.test.demo.DatabaseManagement;

import com.test.demo.Models.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CtModifyCategory {
        private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
        private static final String usernameDB = "root";
        private static final String passwordDB = "CEN2b2023";

        public static void modifyData(Category modCategory, int ID) throws ClassNotFoundException, SQLException {


            Class.forName("com.mysql.cj.jdbc.Driver");


            try (Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
                System.out.println("Connected to the database!");

                String insertQuery = "UPDATE product_category SET category = ?, category_description = ? WHERE category_ID = ?;";

                // Creating a prepared statement to safely insert data and prevent SQL injection
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    // Set values for the parameters
                    preparedStatement.setString(1, modCategory.getCategoryName());

                    preparedStatement.setString(2, modCategory.getCategoryDescription());
                    preparedStatement.setInt(3,ID);

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
