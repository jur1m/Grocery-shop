package com.test.demo.DatabaseManagement;

import com.test.demo.Models.Client;
import com.test.demo.Models.User;

import java.sql.*;

public class CSearchForClientID {

        private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
        private static final String usernameDB = "root";
        private static final String passwordDB = "CEN2b2023";

        public static Client searchWithID(int ID) throws ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Client temp = new Client();

            try (Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
                System.out.println("Connected to the database!");



                String insertQuery = "SELECT * FROM clients WHERE client_ID = ?;";

                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                    preparedStatement.setInt(1,ID);

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {

                            temp.setFirstName(resultSet.getString("first_name"));
                            temp.setLastName(resultSet.getString("last_name"));
                            temp.setAddress(resultSet.getString("address"));
                            temp.setPoints(resultSet.getInt("points"));
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


