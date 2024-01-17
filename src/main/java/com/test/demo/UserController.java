package com.test.demo;

import com.test.demo.DatabaseManagement.UAddUserToDatabase;
import com.test.demo.DatabaseManagement.UDeleteUser;
import com.test.demo.DatabaseManagement.UModifyUser;
import com.test.demo.DatabaseManagement.USearchForUserID;
import com.test.demo.Models.User;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserController implements Initializable {

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
            tfFirstName.setText( temp.getFirstName());
            tfLastName.setText(temp.getLastName());
            tfUsername.setText(temp.getUsername());
            tfPassword.setText(temp.getPassword());
        }
        else{
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

        UModifyUser.modifyData(modifyUser,intID);
        clearTextFields();
    }
    //Deletes user from database
    @FXML
    public void deleteUser() throws SQLException, ClassNotFoundException {
        int intID = Integer.parseInt(tfID.getText());
        UDeleteUser.deleteUser(intID);
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

        UAddUserToDatabase.addToDatabase(newUser);
        clearTextFields();
    }

    //Clears text fields
    @FXML
    public void clearTextFields(){
        tfID.clear();
        tfFirstName.clear();
        tfLastName.clear();
        tfUsername.clear();
        tfPassword.clear();
        lblUserNotFound.setText("");
    }

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

    ObservableList<User> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colID.setCellValueFactory(new PropertyValueFactory<User,Integer>("ID"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<User,String>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<User,String>("lastName"));
        colUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<User,String>("password"));

        tUser.setItems(list);
    }
}
