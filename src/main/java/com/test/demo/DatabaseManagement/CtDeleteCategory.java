package com.test.demo.DatabaseManagement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CtDeleteCategory {


        private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
        private static final String usernameDB = "root";
        private static final String passwordDB = "CEN2b2023";

        public static void deleteCategory(int ID) throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.cj.jdbc.Driver");


            try (java.sql.Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)){
                System.out.println("Connected to the database!");

                String insertQuery = "DELETE FROM product_category WHERE category_ID = ?;";

                // Creating a prepared statement to safely insert data and prevent SQL injection
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    // Set values for the parameters
                    preparedStatement.setInt(1, ID);

                    // Execute the insert statement
                    int rowsAffected = preparedStatement.executeUpdate();

                    // Check the number of rows affected to determine if the insert was successful
                    if (rowsAffected > 0) {
                        System.out.println("Data deleted successfully.");

                    } else {
                        System.out.println("Data drop failed.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




}
