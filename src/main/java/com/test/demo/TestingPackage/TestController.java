package com.test.demo.TestingPackage;


import com.test.demo.DatabaseManagement.UShowAllUsers;
import com.test.demo.TestingPackage.UserWProperties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;

public class TestController {

    @FXML
    private TableView<UserWProperties> tableUsers;

    @FXML
    private TableColumn<UserWProperties, String> colFirstName;

    @FXML
    private TableColumn<UserWProperties, String> colLastName;

    @FXML
    private TableColumn<UserWProperties, Boolean> colStatus;

    @FXML
    private TableColumn<UserWProperties, String> colUsername;

    @FXML
    private TableColumn<UserWProperties, String> colPassword;

    @FXML
    private TableColumn<UserWProperties, Integer> colID;

    private ObservableList<UserWProperties> list;

    @FXML
    public void initialize() {
        try {
            // Initialize the ObservableList and set it to the TableView
            list = FXCollections.observableArrayList(UShowAllUsers.getUsers());
            tableUsers.setItems(list);

            // Set up cell value factories for each column
            colFirstName.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
            colLastName.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());
            colStatus.setCellValueFactory(cellData -> cellData.getValue().getIsBooleanAdmin().asObject());
            colUsername.setCellValueFactory(cellData -> cellData.getValue().getUsernameProperty());
            colPassword.setCellValueFactory(cellData -> cellData.getValue().getPasswordProperty());
            colID.setCellValueFactory(cellData -> cellData.getValue().getIDProperty().asObject());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
    }
}
