package com.test.demo.DatabaseManagement;

import com.test.demo.Models.Client;
import com.test.demo.Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CShowAllClients {

        private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
        private static final String usernameDB = "root";
        private static final String passwordDB = "CEN2b2023";

        public static <Connection> ObservableList getClients() throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.cj.jdbc.Driver");

            ObservableList<Client> list = FXCollections.observableArrayList();


            try (java.sql.Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
                System.out.println("Connected to the database!");

                final String client_ID = "client_ID";
                final String first_name = "first_name";
                final String last_name = "last_name";
                final String points = "points";
                final String address = "address";

                String insertQuery = "SELECT * FROM clients;";

                // Creating a prepared statement to safely insert data and prevent SQL injection
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                     ResultSet resultSet = preparedStatement.executeQuery()) {

                    while (resultSet.next()) {

                        Client temp = new Client();
                        temp.setFirstName(resultSet.getString(first_name));
                        temp.setLastName(resultSet.getString(last_name));
                        temp.setAddress(resultSet.getString(address));
                        temp.setPoints(resultSet.getInt(points));
                        temp.setID(resultSet.getInt(client_ID));


                        list.add(temp);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return list;
        }


}
