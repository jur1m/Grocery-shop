package com.test.demo.Controllers;

import com.test.demo.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.SQLException;

public class MenuBarControllerUser {

    @FXML
    protected void goToClients() throws IOException {

        Main m = new Main();
        m.changeScene("ClientView.fxml");
    }

    @FXML
    protected void goToPOS() throws IOException, SQLException, ClassNotFoundException {
        Main m = new Main();
        m.changeScene("POS.fxml");
    }

    @FXML
    protected void goToProduct() throws IOException {
        Main m = new Main();
        m.changeScene("Products.fxml");
    }

    @FXML
    protected void logOut() throws IOException {
        Main m = new Main();
        m.changeScene("test.fxml");
    }

}
