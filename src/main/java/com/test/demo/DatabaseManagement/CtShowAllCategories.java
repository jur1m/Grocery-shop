package com.test.demo.DatabaseManagement;

import com.test.demo.Models.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CtShowAllCategories {
        private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
        private static final String usernameDB = "root";
        private static final String passwordDB = "CEN2b2023";

        public static ObservableList getCategories() throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.cj.jdbc.Driver");

            ObservableList<Category> list = FXCollections.observableArrayList();


            try (java.sql.Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
                System.out.println("Connected to the database!");

                final String category_ID = "category_ID";
                final String category = "category";
                final String category_description = "category_description";

                String insertQuery = "SELECT * FROM product_category;";

                // Creating a prepared statement to safely insert data and prevent SQL injection
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                     ResultSet resultSet = preparedStatement.executeQuery()) {

                    while (resultSet.next()) {

                        Category temp = new Category();
                        temp.setCategoryName(resultSet.getString(category));
                        temp.setCategoryDescription(resultSet.getString(category_description));
                        temp.setCategoryID(resultSet.getInt(category_ID));


                        list.add(temp);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return list;
        }


}
