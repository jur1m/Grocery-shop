package com.test.demo.DatabaseManagement;
import com.test.demo.Models.Supplier;

import java.sql.*;

public class SSearchSupplier {
        private static final String jdbcUrl = "jdbc:mysql://localhost:3306/myshop";
        private static final String usernameDB = "root";
        private static final String passwordDB = "CEN2b2023";

        public static Supplier searchWithID(int ID) throws ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Supplier temp = new Supplier();

            try (Connection connection = DriverManager.getConnection(jdbcUrl, usernameDB, passwordDB)) {
                System.out.println("Connected to the database!");



                String insertQuery = "SELECT * FROM supplier WHERE supplier_ID = ?;";

                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                    preparedStatement.setInt(1,ID);

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {

                            temp.setSupplierName(resultSet.getString("supplier_name"));
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
