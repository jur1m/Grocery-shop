package com.test.demo.Controllers;

import com.test.demo.Main;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.SQLException;

public class MenuBarController {


    //POS button
    @FXML
    protected void goToPOS() throws IOException, SQLException, ClassNotFoundException {
        Main m = new Main();
        m.changeScene("POS.fxml");
    }

    //Users button
    @FXML
    protected void goToUsers() throws IOException {
        Main m = new Main();
        m.changeScene("UserAdministrationView.fxml");

    }

    //Clients button
    @FXML
    protected void goToClients() throws IOException {

        System.out.println("Clients button");
        Main m = new Main();
        m.changeScene("ClientView.fxml");
    }

    @FXML
    protected void goToProduct() throws IOException {
        Main m = new Main();
        m.changeScene("Products.fxml");
    }

    @FXML
    protected void goToDiscounts(){
        System.out.println("Discounts button");
    }

    @FXML
    protected void goToReports(){
        System.out.println("Reports button");
    }

    @FXML
    protected void logOut() throws IOException {
        Main m = new Main();
        m.changeScene("test.fxml");
    }



}
