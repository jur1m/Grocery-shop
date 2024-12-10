package com.test.demo.DatabaseManagement;

import com.test.demo.Models.User;

import java.sql.*;

public class USearchForUserID {

    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
    private static final String usernameDB = "root";
    private static final String passwordDB = "CEN2b2023";

    public static User searchWithID(int ID) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        User temp = new User();

        try (Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
            System.out.println("Connected to the database!");



            String insertQuery = "SELECT * FROM employees WHERE employee_ID = ?;";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                preparedStatement.setInt(1,ID);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {


                        temp.setUsername(resultSet.getString(("username")));
                        temp.setPassword(resultSet.getString("password"));
                        temp.setFirstName(resultSet.getString("first_name"));
                        temp.setLastName(resultSet.getString("last_name"));

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
