package com.test.demo.DatabaseManagement;

import com.test.demo.Models.Client;
import com.test.demo.Models.Product;

import java.sql.*;

public class PSearchForProduct {

        private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
        private static final String usernameDB = "root";
        private static final String passwordDB = "CEN2b2023";

        public static Product searchWithID(int ID) throws ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Product temp = new Product();

            try (Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
                System.out.println("Connected to the database!");



                String insertQuery = "SELECT * FROM product WHERE product_ID = ?;";

                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                    preparedStatement.setInt(1,ID);

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {

                            temp.setProductName(resultSet.getString("name_of_the_product"));
                            temp.setPricePerUnit(resultSet.getInt("price"));
                            temp.setStock(resultSet.getInt("stock"));
                            temp.setCategory(resultSet.getInt("category_ID"));
                            temp.setSupplier(resultSet.getInt("supplier_ID"));
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
