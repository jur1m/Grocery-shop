package com.test.demo.Controllers;

import com.test.demo.Main;
import com.test.demo.Models.Client;
import com.test.demo.Models.Receipt;
import com.test.demo.Models.ReceiptElement;
import com.test.demo.Models.User;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class POSController {
    private Client client = new Client();
    public User user = new User();
    private Receipt receipt = new Receipt();
    private int subotal;
    private int discount;
    private int total;

    private ReceiptElement temp = new ReceiptElement();
    ObservableList<ReceiptElement> list;


    @FXML
    private Button btAddClient;

    @FXML
    private Button btAddToReceipt;

    @FXML
    private Button btConfirmDiscount;

    @FXML
    private Button btConfirmReceipt;

    @FXML
    private CheckBox cbxUsePoints;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPricePerUnit;

    @FXML
    private TableColumn<?, ?> colTotalPrice;

    @FXML
    private TableColumn<?, ?> colUnits;

    @FXML
    private Label lblClientName;

    @FXML
    private Label lblPoints;

    @FXML
    private Label lblStatus;

    @FXML
    private TableView<?> tbReceipt;

    @FXML
    private TextField tfDiscount;

    @FXML
    private TextField tfDiscountAll;

    @FXML
    private TextField tfDiscountPerc;

    @FXML
    private TextField tfIDProduct;

    @FXML
    private TextField tfPricePerUnit;

    @FXML
    private TextField tfQuantityProduct;

    @FXML
    private TextField tfSubtotal;

    @FXML
    private TextField tfTotal;

    @FXML
    private TextField tfTotalCostProduct;




    //client management
    @FXML
    void addClientToReceipt() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AddClientppup.fxml"));
        Parent root1;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Add user to receipt");
        stage.setScene(new Scene(root1));
        stage.show();

    }

}
