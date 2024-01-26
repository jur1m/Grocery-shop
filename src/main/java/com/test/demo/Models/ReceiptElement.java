package com.test.demo.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReceiptElement {
    private StringProperty productName = new SimpleStringProperty();
    private IntegerProperty ID = new SimpleIntegerProperty();
    private IntegerProperty pricePerUnit = new SimpleIntegerProperty();
    private IntegerProperty quantity = new SimpleIntegerProperty();
    private IntegerProperty totalCost = new SimpleIntegerProperty();
    private IntegerProperty quantityLeft = new SimpleIntegerProperty();


    public ReceiptElement (){

    }
    public ReceiptElement(String name, int pricePerUnit, int quantity, int totalCost){
        setProductName(name);
        setPricePerUnit(pricePerUnit);
        setQuantity(quantity);
        setTotalCost(totalCost);
    }

    public String getProductName() {
        return productName.get();
    }

    public StringProperty productNameProperty() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }


    public int getID() {
        return ID.get();
    }

    public IntegerProperty IDProperty() {
        return ID;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public int getPricePerUnit() {
        return pricePerUnit.get();
    }

    public IntegerProperty pricePerUnitProperty() {
        return pricePerUnit;
    }

    public void setPricePerUnit(int pricePerUnit) {
        this.pricePerUnit.set(pricePerUnit);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public int getTotalCost() {
        return totalCost.get();
    }

    public IntegerProperty totalCostProperty() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost.set(totalCost);
    }

    public int getQuantityLeft() {
        return quantityLeft.get();
    }

    public IntegerProperty quantityLeftProperty() {
        return quantityLeft;
    }

    public void setQuantityLeft(int quantityLeft) {
        this.quantityLeft.set(quantityLeft);
    }
}
