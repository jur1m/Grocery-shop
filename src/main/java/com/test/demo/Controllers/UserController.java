package com.test.demo.Controllers;

import com.test.demo.DatabaseManagement.*;
import com.test.demo.Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;


public class UserController  {

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfUsername;

    @FXML
    private TextField tfPassword;

    @FXML
    private Label lblUserNotFound;
    @FXML
    private CheckBox chIsAdmin = new CheckBox();


    //Search for users using their personal ID
    @FXML
    public void searchForUserID() throws ClassNotFoundException {
        int intID = Integer.parseInt(tfID.getText());
        User temp = new User();
        try {
            temp = USearchForUserID.searchWithID(intID);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(temp!=null){
            lblUserNotFound.setText("");
            tfFirstName.setText( temp.getFirstName());
            tfLastName.setText(temp.getLastName());
            tfUsername.setText(temp.getUsername());
            tfPassword.setText(temp.getPassword());
            if(temp.getIsAdmin()){
                chIsAdmin.setSelected(true);
            }

        }
        else{
            clearTextFields();
            lblUserNotFound.setText("User not found!");

        }
    }

    //Modify user data
    @FXML
    public void modifyUser() throws SQLException, ClassNotFoundException {
        System.out.println("Modify button is pressed");
        User modifyUser = new User();
        modifyUser.setFirstName(tfFirstName.getText());
        modifyUser.setLastName(tfLastName.getText());
        modifyUser.setUsername(tfUsername.getText());
        modifyUser.setPassword(tfPassword.getText());
        int intID = Integer.parseInt(tfID.getText());
        modifyUser.setIsAdmin(chIsAdmin.isSelected());

        UModifyUser.modifyData(modifyUser,intID);
        initialize();
        clearTextFields();
    }
    //Deletes user from database
    @FXML
    public void deleteUser() throws SQLException, ClassNotFoundException {
        int intID = Integer.parseInt(tfID.getText());
        UDeleteUser.deleteUser(intID);
        initialize();
        clearTextFields();
    }

    //Add new user to database
    @FXML
    public void addToDatabase () throws IOException, SQLException, ClassNotFoundException {
        User newUser = new User();
        newUser.setFirstName(tfFirstName.getText());
        newUser.setLastName(tfLastName.getText());
        newUser.setUsername(tfUsername.getText());
        newUser.setPassword(tfPassword.getText());
        newUser.setIsAdmin(chIsAdmin.isSelected());

        UAddUserToDatabase.addToDatabase(newUser);
        initialize();
        clearTextFields();
    }

    //Clears text fields
    @FXML
    public void clearTextFields(){
        tfFirstName.clear();
        tfLastName.clear();
        tfUsername.clear();
        tfPassword.clear();
        lblUserNotFound.setText("");
        chIsAdmin.setSelected(false);
    }

    //public method to check if all the necessary fields for the userController have data


    //Table view
    @FXML
    private TableView<User> tUser;
    @FXML
    private TableColumn<User,Integer> colID;
    @FXML
    private TableColumn<User,String> colFirstName;
    @FXML
    private TableColumn<User,String> colLastName;
    @FXML
    private TableColumn<User,String> colUsername;
    @FXML
    private TableColumn<User,String> colPassword;
    @FXML
    private TableColumn<User,Boolean> colIsAdmin;


    public void initialize() throws SQLException, ClassNotFoundException {
        ObservableList<User> list = FXCollections.observableArrayList(UShowAllUsers.getUsers());
        tUser.setItems(list);


        colFirstName.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
        colLastName.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());
        colUsername.setCellValueFactory(cellData -> cellData.getValue().getUsernameProperty());
        colPassword.setCellValueFactory(cellData -> cellData.getValue().getPasswordProperty());
        colID.setCellValueFactory(cellData -> cellData.getValue().getIDProperty().asObject());
        colIsAdmin.setCellValueFactory(cellData -> cellData.getValue().getIsBooleanAdmin());

        //tUser.setItems(list);
    }


}
