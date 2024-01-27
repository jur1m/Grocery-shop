package com.test.demo.DatabaseManagement;

import com.test.demo.Models.Category;
import com.test.demo.Models.Client;

import java.sql.*;

public class CtSearchForCategory {

        private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
        private static final String usernameDB = "root";
        private static final String passwordDB = "CEN2b2023";

        public static Category searchWithID(int ID) throws ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Category temp = new Category();

            try (Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
                System.out.println("Connected to the database!");



                String insertQuery = "SELECT * FROM product_category WHERE category_ID = ?;";

                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                    preparedStatement.setInt(1,ID);

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {

                            temp.setCategoryName(resultSet.getString("category"));
                            temp.setCategoryDescription(resultSet.getString("category_description"));
                        }
                        else{
                            temp=null;
                        }
                    }}
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return temp;
        }




}
