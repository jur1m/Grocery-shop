package com.test.demo.Controllers;


import com.test.demo.Models.ReceiptElement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class POSController {

    private ArrayList<ReceiptElement> receipt = new ArrayList<ReceiptElement>();


    @FXML
    private Button btAddNewClient;

    @FXML
    private Button btAddToReceipt;

    public void setBtAddToReceipt(){

    }

    @FXML
    private Button btConfirmClient;

    @FXML
    private Button btConfirmDiscount;

    @FXML
    private Button btConfirmReceipt;

    @FXML
    private ChoiceBox<?> cbNameProduct;

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
    private Label lblClientNotFound;

    @FXML
    private Label lblPoints;

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
    private TextField tfIdClient;

    @FXML
    private TextField tfNameClient;

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

}