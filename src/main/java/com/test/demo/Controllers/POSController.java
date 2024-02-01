package com.test.demo.Controllers;

import com.test.demo.DatabaseManagement.*;
import com.test.demo.Main;
import com.test.demo.Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class POSController implements Initializable {

    //create deafult client and user
    public Client client = new Client();
    public User user = new User();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            client.setID(1);
            user.setID(1);

    }


    // product textfields
    @FXML
    TextField tfUnitsLeft = new TextField();
    @FXML
    TextField tfProductName = new TextField();
    @FXML
    Label errorLabelPOS = new Label();
    @FXML
    private TextField tfTotalCostProduct;
    @FXML
    private TextField tfIDProduct;

    @FXML
    private TextField tfPricePerUnit;

    @FXML
    private TextField tfQuantityProduct;

    private Product tempProduct = new Product();


    //add product with ID
    @FXML
    public void searchForProduct(){
        if(!tfIDProduct.getText().isEmpty() && isNumeric(tfIDProduct.getText())){
            int ID = Integer.parseInt(tfIDProduct.getText());

            try {
                tempProduct=PSearchForProduct.searchWithID(ID);
                tempProduct.setIDProduct(ID);
                try{
                    fillTF(1);
                }
                catch (NullPointerException e){
                    errorLabelPOS.setText("Error finding product");
                }

            } catch (ClassNotFoundException e) {
                errorLabelPOS.setText("Error finding product");
            }
        }

        tfQuantityProduct.textProperty().addListener((observable, oldValue, newValue)->{
            if(!newValue.isEmpty()){
                fillTF(Integer.parseInt(newValue));
            }
        });
        tfPricePerUnit.textProperty().addListener((observable, oldValue, newValue)->{
            if(!newValue.isEmpty() && Integer.parseInt(newValue)>=10){
                tempProduct.setPricePerUnit(Integer.parseInt(newValue));
                fillTF(tempProduct.getQuantityInReceipt());
            }
        });

    }
    //method to calculate total and fill text fields
    private void fillTF(int quantity){
        tfProductName.setText(tempProduct.getProductName());
        tfPricePerUnit.setText(String.valueOf(tempProduct.getPricePerUnit()));
        tfUnitsLeft.setText(String.valueOf(tempProduct.getStock()));
        tempProduct.setQuantityInReceipt(quantity);
        tfQuantityProduct.setText(String.valueOf(tempProduct.getQuantityInReceipt()));
        int total = tempProduct.getPricePerUnit()*tempProduct.getQuantityInReceipt();
        tempProduct.setTotalInReceipt(total);
        tfTotalCostProduct.setText(String.valueOf(tempProduct.getTotalInReceipt()));

    }




    //add to arraylist
    ObservableList<Product> list = FXCollections.observableArrayList();;

    @FXML
    public void addToReceipt(){

        if(tempProduct!= null && tfProductName.getText()!=null && tfPricePerUnit.getText()!=null && tfQuantityProduct.getText()!=null && tfTotalCostProduct.getText()!=null){
            boolean set = false;
            for(int i=0;i<list.size();i++){
                if(tempProduct.getProductName().equals(list.get(i).getProductName())){
                    int newQty = list.get(i).getQuantityInReceipt()+tempProduct.getQuantityInReceipt();
                    list.get(i).setQuantityInReceipt(newQty);
                    int total = list.get(i).getPricePerUnit()*list.get(i).getQuantityInReceipt();
                    list.get(i).setTotalInReceipt(total);
                    set = true;
                }
            }
            if(!set){
                list.add(tempProduct);
            }

            tempProduct=null;
            showReceipt();
            calculateSubtotal();
            calculateTotal();
            tfSubtotal.setText(String.valueOf(subtotal));
            tfDiscount.setText(String.valueOf(discount));
            tfTotal.setText(String.valueOf(total));

            clearTF();
        }

//        if(!list.isEmpty()){
//            for(int i=0;i<list.size();i++){
//                System.out.println(list.get(i).getProductName());
//            }
//        }
    }


    //Receipt table
    @FXML
    private TableView<Product> tbReceipt;

    @FXML
    private TableColumn<Product, String> colName;

    @FXML
    private TableColumn<Product, Integer> colPricePerUnit;

    @FXML
    private TableColumn<Product, Integer> colTotalPrice;

    @FXML
    private TableColumn<Product, Integer> colUnits;





    private void showReceipt(){
        tbReceipt.setItems(list);

        //colNr.setCellValueFactory(cellData -> cellData.getValue()..asObject());
        colName.setCellValueFactory(cellData -> cellData.getValue().productNameProperty());
        colPricePerUnit.setCellValueFactory(cellData -> cellData.getValue().pricePerUnitProperty().asObject());
        colTotalPrice.setCellValueFactory(cellData -> cellData.getValue().totalInReceiptProperty().asObject());
        colUnits.setCellValueFactory(cellData -> cellData.getValue().quantityInReceiptProperty().asObject());

        //fill text fields with info from table when a row is cclicked to edit that row
        tbReceipt.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {

                tempProduct = tbReceipt.getSelectionModel().getSelectedItem();
                if (tempProduct != null) {
                    fillTF(tempProduct.getQuantityInReceipt());
                }

            } else if (event.getClickCount() == 2) {
                tempProduct = tbReceipt.getSelectionModel().getSelectedItem();
                deleteRow();
            }
        });
    }


    //calculate subtotal
    private int subtotal = 0;
    @FXML
    private TextField tfSubtotal;

    private void calculateSubtotal(){
        subtotal = 0;
        for(int i=0;i<list.size();i++){

            subtotal+=list.get(i).getTotalInReceipt();
        }
        tfSubtotal.setText(String.valueOf(subtotal));
        calculateTotal();

    }

    //Add discount to receipt
    private int discount = 0;
    @FXML
    private TextField tfDiscountAll;
    @FXML
    private TextField tfDiscount;

    @FXML
    public void addDiscountToReceipt(){
        if(!tfDiscountAll.getText().isEmpty() && isNumeric(tfDiscountAll.getText()) && Integer.parseInt(tfDiscountAll.getText())<99999){
            discount = Integer.parseInt(tfDiscountAll.getText());
            tfDiscount.setText(String.valueOf(discount));
            calculateTotal();
        }
    }

    //Calculate total of the receipt
    private int total;
    @FXML
    private TextField tfTotal;
    public void calculateTotal(){
        total = subtotal - discount;
        tfTotal.setText(String.valueOf(total));
        managePoints();
    }

    //print receipt and save data to database
    private Receipt receipt = new Receipt();
    @FXML
    public void printReceipt(){
        //add data to receipt table
        receipt.setReceiptValue(total);
        LocalDate currentDate = LocalDate.now();
        receipt.setDate(currentDate);
        receipt.setClientID(client.getID());
        receipt.setEmployeeID(user.getID());
        int receipt_ID = 0;
        try {
            receipt_ID=RAddReceiptToDatabase.addToDatabase(receipt);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found when writing data from pos receipt to database");
        }
        //add data to receipt_details
        if(receipt_ID==0){
            System.out.println("Data not inserted in DB");
        }
        else if(receipt_ID==-1){
            System.out.println("ID not retrieved");
        }
        else{
            for(int i =0;i<list.size();i++){
                try {
                    RDAddReceiptDetailsToDB.addToDatabase(list.get(i).getID(),list.get(i).getQuantityInReceipt(),receipt_ID);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        clearEverything();

    }

    //manage user
    public void managePoints(){
        int points = client.getPoints();
        if(cbxUsePoints.isSelected()){
            discount += (points/10);
            points = 0;
        }
        else{
            points += getPointsFromReceipt();
        }
        client.setPoints(points);


    }

    ////////////////////////////////////////////////////////////////////////////////////








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
    private Label lblClientName;

    @FXML
    private Label lblPoints;

    @FXML
    private Label lblStatus;



















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


    //other methods

    //checks if string is a number
    private boolean isNumeric(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return pattern.matcher(str).matches();
    }

    //clears text fields
    @FXML
    private void clearTF(){
        tfIDProduct.clear();
        tfProductName.clear();
        tfPricePerUnit.clear();
        tfUnitsLeft.clear();
        tfQuantityProduct.clear();
        tfTotalCostProduct.clear();
        errorLabelPOS.setText("");
        tempProduct=null;
    }

    //deletes a row in the table
    private void deleteRow(){
        for(int i=0;i<list.size();i++){
            if(tempProduct.getProductName().equals(list.get(i).getProductName())){
                list.remove(i);
            }
        }
    }

    private void clearEverything(){
        clearTF();
        list.clear();
        subtotal = 0;
        discount = 0;
        total = 0;
        tfSubtotal.clear();
        tfDiscount.clear();
        tfDiscountAll.clear();
        tfTotal.clear();
    }

    private int getPointsFromReceipt(){
        int points = total/2;
        return points;
    }


}
