package com.test.demo.TestingPackage;

import com.test.demo.DatabaseManagement.ULogInVerificationDB;
import com.test.demo.Models.User;

import java.sql.SQLException;

public class TestingDatabase {
    public static void  main(String[] argv) throws SQLException, ClassNotFoundException {
        User user = new User();
        user = ULogInVerificationDB.checkUser("a", "a");

        System.out.println(user.getUsername()+user.getPassword());
    }
}
