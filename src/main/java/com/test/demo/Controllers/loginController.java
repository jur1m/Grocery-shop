package com.test.demo.Controllers;

import com.test.demo.DatabaseManagement.ULogInVerificationDB;

import com.test.demo.Main;
import com.test.demo.Models.User;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.sql.SQLException;

public class loginController {



    @FXML
    private Label lblError;

    @FXML
    private TextField tfUsername;

    @FXML
    private PasswordField tfPassword;

    @FXML
    public void userLogin () throws IOException, SQLException, ClassNotFoundException {
        checkLogin();

    }

    @FXML
    protected void checkLogin() throws IOException, SQLException, ClassNotFoundException {
        Main m = new Main();
        User check = new User();
        check = ULogInVerificationDB.checkUser(tfUsername.getText(),tfPassword.getText());
        if(!check.getUsername().equals("N404")){
            System.out.println("login success");
            m.changeScene("UserAdministrationView.fxml");
        }
        else{
            lblError.setText("Error logging in");
        }
    }




}
