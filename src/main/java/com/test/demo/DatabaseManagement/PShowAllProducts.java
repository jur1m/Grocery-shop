package com.test.demo.DatabaseManagement;

import com.test.demo.Models.Category;
import com.test.demo.Models.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PShowAllProducts {
        private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
        private static final String usernameDB = "root";
        private static final String passwordDB = "CEN2b2023";

        public static ObservableList getProducts() throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.cj.jdbc.Driver");

            ObservableList<Product> list = FXCollections.observableArrayList();


            try (java.sql.Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
                System.out.println("Connected to the database!");

                final String product_ID = "product_ID";
                final String name_of_the_product = "name_of_the_product";
                final String price = "price";
                final String stock = "stock";
                final String category_ID = "category_ID";
                final String supplier_ID = "supplier_ID";

                String insertQuery = "SELECT * FROM product;";

                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                     ResultSet resultSet = preparedStatement.executeQuery()) {

                    while (resultSet.next()) {

                        Product temp = new Product();
                        temp.setIDProduct(resultSet.getInt(product_ID));
                        temp.setProductName(resultSet.getString(name_of_the_product));
                        temp.setPricePerUnit(resultSet.getInt(price));
                        temp.setStock(resultSet.getInt(stock));
                        temp.setCategory(resultSet.getInt(category_ID));
                        temp.setSupplier(resultSet.getInt(supplier_ID));


                        list.add(temp);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return list;
        }

}
