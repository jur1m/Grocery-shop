package com.test.demo.Controllers;

import com.test.demo.DatabaseManagement.*;
import com.test.demo.Models.Category;
import com.test.demo.Models.Product;
import com.test.demo.Models.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class ProductController {

    //Initialize tables:





    @FXML
    private Button btAddCategory;

    @FXML
    private Button btAddProduct;

    @FXML
    private Button btAddStock;

    @FXML
    private Button btAddSupplier;

    @FXML
    private Button btDeleteCategory;

    @FXML
    private Button btDeleteProduct;

    @FXML
    private Button btDeleteSupplier;

    @FXML
    private Button btModifyCategory;

    @FXML
    private Button btModifyProduct;

    @FXML
    private Button btModifySupplier;

    @FXML
    private Button btSearchCategory;

    @FXML
    private Button btSearchProduct;

    @FXML
    private Button btSearchSupplier;



    @FXML
    private TableColumn<?, ?> colCategoryProduct;





    @FXML
    private TableColumn<?, ?> colIdProduct;



    @FXML
    private TableColumn<?, ?> colNameProduct;



    @FXML
    private TableColumn<?, ?> colStockProduct;

    @FXML
    private TableColumn<?, ?> colSupplierProduct;

    @FXML
    private TableColumn<?, ?> colpriceProduct;



    @FXML
    private TableView<?> tbProductTable;



    @FXML
    private TextField tfAddToStock;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfDescriptionCategory;

    @FXML
    private TextField tfIDCategory;

    @FXML
    private TextField tfIDProduct;

    @FXML
    private TextField tfIDSupplier;

    @FXML
    private TextField tfNameCategory;

    @FXML
    private TextField tfNameSupplier;

    @FXML
    private TextField tfPrice;

    @FXML
    private TextField tfProductName;

    @FXML
    private TextField tfStock;

    @FXML
    private TextField tfSupplier;

    @FXML
    private Label categoryLabel;



    @FXML
    void addProductToDatabase(ActionEvent event) {
        Product temp = new Product();
        temp.setProductName(tfProductName.getText());
        temp.setPricePerUnit(Integer.parseInt(tfPrice.getText()));
        temp.setStock(Integer.parseInt(tfStock.getText()));
        //temp.setCategory();

    }





    @FXML
    void clearProductTF(ActionEvent event) {

    }





    @FXML
    void deleteProduct(ActionEvent event) {

    }





    @FXML
    void modifyProduct(ActionEvent event) {

    }





    @FXML
    void searchForProduct(ActionEvent event) {

    }





    //Category management

    @FXML
    void searchForCategory() {


        if(tfIDCategory.getText().isEmpty()){
            categoryLabel.setText("Please enter a valid ID");
        }

        else{
            int ID = Integer.parseInt(tfIDCategory.getText());
            Category temp = new Category();
            try {
                temp = CtSearchForCategory.searchWithID(ID);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            if(temp!=null){
                categoryLabel.setText("");
                tfNameCategory.setText(temp.getCategoryName());
                System.out.println(temp.getCategoryName());
                tfDescriptionCategory.setText(temp.getCategoryDescription());

            }
            else{
                clearCategoryTF();
                categoryLabel.setText("Category not found");

            }
        }


    }

    @FXML
    void modifyCategory() throws SQLException, ClassNotFoundException {
        Category temp = new Category();

        if(tfIDCategory.getText().isEmpty()){
            categoryLabel.setText("");
            categoryLabel.setText("Please enter a valid ID");
        }
        else if(tfNameCategory.getText().isEmpty()){
            categoryLabel.setText("");
            categoryLabel.setText("Please enter a valid category name");
        }
        else{
            categoryLabel.setText("");
            int ID = Integer.parseInt(tfIDCategory.getText());
            temp.setCategoryName(tfNameCategory.getText());
            temp.setCategoryDescription(tfDescriptionCategory.getText());
            CtModifyCategory.modifyData(temp,ID);
            initializeCategoryTable();
            clearCategoryTF();
        }
    }

    @FXML
    void deleteCategory() throws SQLException, ClassNotFoundException {

        if(tfIDCategory.getText().isEmpty()){
            categoryLabel.setText("Please enter a valid ID");
        }
        else{
            int ID = Integer.parseInt(tfIDCategory.getText());
            categoryLabel.setText("");
            CtDeleteCategory.deleteCategory(ID);
            initializeCategoryTable();
            clearCategoryTF();
        }
    }

    @FXML
    void clearCategoryTF() {
        tfNameCategory.clear();
        tfIDCategory.clear();
        tfDescriptionCategory.clear();
        categoryLabel.setText("");
    }

    @FXML
    void addNewCategory() throws ClassNotFoundException, SQLException {
        Category temp = new Category();
        temp.setCategoryName(tfNameCategory.getText());
        temp.setCategoryDescription(tfDescriptionCategory.getText());
        if(tfNameCategory.getText().isEmpty()){
            categoryLabel.setText("Please enter a valid category name");
        }
        else{
            categoryLabel.setText("");
            CtAddCategory.addToDatabase(temp);
            initializeCategoryTable();
            clearCategoryTF();
        }

    }

    @FXML
    private TableView<Category> tbCategories;
    @FXML
    private TableColumn<Category, String> colNameCategory;
    @FXML
    private TableColumn<Category, String> colCategoryDescription;
    @FXML
    private TableColumn<Category, Integer> colIDCategory;

    public void initializeCategoryTable() throws SQLException, ClassNotFoundException {
        ObservableList<Category> categoryList = FXCollections.observableArrayList(CtShowAllCategories.getCategories());
        tbCategories.setItems(categoryList);


        colIDCategory.setCellValueFactory(cellData -> cellData.getValue().categoryIDProperty().asObject());
        colNameCategory.setCellValueFactory(cellData -> cellData.getValue().categoryNameProperty());
        colCategoryDescription.setCellValueFactory(cellData -> cellData.getValue().categoryDescriptionProperty());


    }



    //Supplier Management
    @FXML
    Label supplierLabel = new Label();

    @FXML
    void clearSupplierTF() {
        tfNameSupplier.clear();
        tfIDSupplier.clear();
        supplierLabel.setText("");
    }
    @FXML
    void searchForSupplier() {

        if(tfIDSupplier.getText().isEmpty()){
            supplierLabel.setText("Please enter a valid ID");
        }

        else{
            int ID = Integer.parseInt(tfIDSupplier.getText());
            Supplier temp = new Supplier();
            try {
                temp = SSearchSupplier.searchWithID(ID);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            if(temp!=null){
                supplierLabel.setText("");
                tfNameSupplier.setText(temp.getSupplierName());

            }
            else{
                clearSupplierTF();
                supplierLabel.setText("Supplier not found");

            }
        }
    }


    @FXML
    void modifySupplier() throws SQLException, ClassNotFoundException {
        Supplier temp = new Supplier();

        if(tfIDSupplier.getText().isEmpty()){
            supplierLabel.setText("");
            supplierLabel.setText("Please enter a valid ID");
        }
        else if(tfNameSupplier.getText().isEmpty()){
            supplierLabel.setText("");
            supplierLabel.setText("Please enter a valid supplier name");
        }
        else{
            supplierLabel.setText("");
            int ID = Integer.parseInt(tfIDSupplier.getText());
            temp.setSupplierName(tfNameSupplier.getText());
            SModifySupplier.modifyData(temp,ID);
            initializeSupplierTable();
            clearSupplierTF();
        }
    }

    @FXML
    void addSupplier() throws ClassNotFoundException, SQLException {
        Supplier temp = new Supplier();
        temp.setSupplierName(tfNameSupplier.getText());
        if(tfNameSupplier.getText().isEmpty()){
            supplierLabel.setText("Please enter a valid supplier name");
        }
        else{
            supplierLabel.setText("");
            SAddSupplier.addToDatabase(temp);
            initializeSupplierTable();
            clearSupplierTF();
        }
    }
    @FXML
    void deleteSupplier() throws SQLException, ClassNotFoundException {
        if(tfIDSupplier.getText().isEmpty()){
            supplierLabel.setText("Please enter a valid ID");
        }
        else{
            int ID = Integer.parseInt(tfIDSupplier.getText());
            supplierLabel.setText("");
            SDeleteSupplier.deleteSupplier(ID);
            clearSupplierTF();
            initializeSupplierTable();
        }
    }





    @FXML
    private TableView<Supplier> tbSuppliers;
    @FXML
    private TableColumn<Supplier, String> colNameSupplier;
    @FXML
    private TableColumn<Supplier, Integer> colIDSupplier;

    public void initializeSupplierTable() throws SQLException, ClassNotFoundException {
        ObservableList<Supplier> supplierList = FXCollections.observableArrayList(SShowAllSuppliers.getSuppliers());
        tbSuppliers.setItems(supplierList);


        colIDSupplier.setCellValueFactory(cellData -> cellData.getValue().supplierIDProperty().asObject());
        colNameSupplier.setCellValueFactory(cellData -> cellData.getValue().supplierNameProperty());


    }

    public void initialize() throws SQLException, ClassNotFoundException {
        initializeSupplierTable();
        initializeCategoryTable();
    }

}
