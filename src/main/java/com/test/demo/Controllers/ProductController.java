package com.test.demo.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ProductController {

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
    private TableColumn<?, ?> colCategoryDescription;

    @FXML
    private TableColumn<?, ?> colCategoryProduct;

    @FXML
    private TableColumn<?, ?> colIDCategory;

    @FXML
    private TableColumn<?, ?> colIDSupplier;

    @FXML
    private TableColumn<?, ?> colIdProduct;

    @FXML
    private TableColumn<?, ?> colNameCategory;

    @FXML
    private TableColumn<?, ?> colNameProduct;

    @FXML
    private TableColumn<?, ?> colNameSupplier;

    @FXML
    private TableColumn<?, ?> colStockProduct;

    @FXML
    private TableColumn<?, ?> colSupplierProduct;

    @FXML
    private TableColumn<?, ?> colpriceProduct;

    @FXML
    private TableView<?> tbCategories;

    @FXML
    private TableView<?> tbProductTable;

    @FXML
    private TableView<?> tbSuppliers;

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

}
