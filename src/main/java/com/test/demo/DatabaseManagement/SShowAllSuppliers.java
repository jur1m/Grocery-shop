package com.test.demo.DatabaseManagement;

import com.test.demo.Models.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SShowAllSuppliers {
        private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
        private static final String usernameDB = "root";
        private static final String passwordDB = "CEN2b2023";

        public static ObservableList getSuppliers() throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.cj.jdbc.Driver");

            ObservableList<Supplier> list = FXCollections.observableArrayList();


            try (java.sql.Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
                System.out.println("Connected to the database!");

                final String supplier_ID = "supplier_ID";
                final String supplier_name = "supplier_name";

                String insertQuery = "SELECT * FROM supplier;";

                // Creating a prepared statement to safely insert data and prevent SQL injection
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                     ResultSet resultSet = preparedStatement.executeQuery()) {

                    while (resultSet.next()) {

                        Supplier temp = new Supplier();
                        temp.setSupplierName(resultSet.getString(supplier_name));
                        temp.setSupplierID(resultSet.getInt(supplier_ID));


                        list.add(temp);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return list;
        }




}
