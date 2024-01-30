package com.test.demo.Controllers;

import com.test.demo.DatabaseManagement.CAddClientToDatabase;
import com.test.demo.DatabaseManagement.CSearchForClientID;
import com.test.demo.DatabaseManagement.CShowAllClients;
import com.test.demo.Models.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class PopUpClientController  {


    @FXML
    private Button btAddClToReceipt;

    @FXML
    private Button btAddClientToDB;

    @FXML
    private Button btSearch;

    @FXML
    private ChoiceBox<Client> cbName;

    @FXML
    private Label lblClientName;

    @FXML
    private Label lblError;

    @FXML
    private Label lblPoints;

    @FXML
    private TextField tfAddress;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfPoints;



    @FXML
    void addToDatabase() throws SQLException, ClassNotFoundException {
        Client newClient = new Client();
        newClient.setFirstName(tfFirstName.getText());
        newClient.setLastName(tfLastName.getText());
        int points = 0;

        boolean number = isNumeric(String.valueOf(tfPoints));

        if(number){
            points = Integer.parseInt(tfPoints.getText());
        }

        newClient.setPoints(points);
        newClient.setAddress(tfAddress.getText());

        CAddClientToDatabase.addToDatabase(newClient);


        clearTF();
    }
    private boolean isNumeric(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return pattern.matcher(str).matches();
    }

    @FXML
    void clearTF() {
        tfFirstName.clear();
        tfLastName.clear();
        tfPoints.clear();
        tfAddress.clear();
        lblError.setText("");
        lblPoints.setText("-");
        lblClientName.setText("General");
    }

    Client temp = new Client();
    @FXML
    Client addToReceipt() {

        if(temp == null){
            return null;
        }
        else{
            return temp;
        }
    }

    @FXML
    void searchForClient() {
        int intID = Integer.parseInt(tfID.getText());

        try {
            temp = CSearchForClientID.searchWithID(intID);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(temp!=null){
            lblError.setText("");
            lblClientName.setText(temp.getFirstName());
            lblPoints.setText(temp.getPointsString());
        }
        else{
            clearTF();
            lblError.setText("User not found!");


        }
    }


}
