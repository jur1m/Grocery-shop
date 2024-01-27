package com.test.demo.Controllers;

import com.test.demo.DatabaseManagement.*;
import com.test.demo.Models.Client;
import com.test.demo.Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class ClientController {

    @FXML
    private Button btAddClient;

    @FXML
    private Button btClear;

    @FXML
    private Button btDelete;

    @FXML
    private Button btModify;

    @FXML
    private Button btSearch;


    @FXML
    private Label lblClientNotFound;

    @FXML
    private TextField tfAddress;

    @FXML
    private TextField tfClientID;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfPoints;

    @FXML
    void addClientToDB() throws SQLException, ClassNotFoundException {
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

        initialize();
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
        lblClientNotFound.setText("");
    }

    @FXML
    void deleteClientFromDB() throws SQLException, ClassNotFoundException {
        int intID = Integer.parseInt(tfClientID.getText());
        CDeleteClientFromDatabase.deleteClient(intID);
        initialize();
        clearTF();
    }

    @FXML
    void modifyClientData() throws SQLException, ClassNotFoundException {
        Client modifyClient = new Client();
        modifyClient.setFirstName(tfFirstName.getText());
        modifyClient.setLastName(tfLastName.getText());
        modifyClient.setAddress(tfAddress.getText());

        int points = 0;

        boolean number = isNumeric(String.valueOf(tfPoints));

        if(number){
            points = Integer.parseInt(tfPoints.getText());
        }

        modifyClient.setPoints(points);

        int intID = Integer.parseInt(tfClientID.getText());

        CModifyClient.modifyData(modifyClient,intID);
        initialize();
        clearTF();
    }

    @FXML
    void searchClient() {
        int intID = Integer.parseInt(tfClientID.getText());
        Client temp = new Client();
        try {
            temp = CSearchForClientID.searchWithID(intID);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(temp!=null){
            lblClientNotFound.setText("");
            tfFirstName.setText( temp.getFirstName());
            tfLastName.setText(temp.getLastName());
            tfPoints.setText(temp.getPointsString());
            tfAddress.setText(temp.getAddress());
        }
        else{
            clearTF();
            lblClientNotFound.setText("User not found!");

        }
    }


    @FXML
    private TableColumn<Client, String> colAddress;

    @FXML
    private TableColumn<Client, String> colFirstName;

    @FXML
    private TableColumn<Client, String> colLastName;

    @FXML
    private TableColumn<Client, Integer> colPoints;

    @FXML
    private TableColumn<Client, Integer> colID;

    @FXML
    private TableView<Client> tableClients;




    private ObservableList<Client> list;



    public void initialize() throws SQLException, ClassNotFoundException {
        list = FXCollections.observableArrayList(CShowAllClients.getClients());
        tableClients.setItems(list);


        colFirstName.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
        colLastName.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());
        colAddress.setCellValueFactory(cellData -> cellData.getValue().getAddressProperty());
        colPoints.setCellValueFactory(cellData -> cellData.getValue().getPointsProperty().asObject());
        colID.setCellValueFactory(cellData -> cellData.getValue().getIDProperty().asObject());


    }

}
