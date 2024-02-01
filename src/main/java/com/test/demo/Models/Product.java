package com.test.demo.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {
        private final StringProperty productName = new SimpleStringProperty();
        private final IntegerProperty ID = new SimpleIntegerProperty();
        private final IntegerProperty pricePerUnit = new SimpleIntegerProperty();
        private final IntegerProperty stock = new SimpleIntegerProperty();
        private final IntegerProperty categoryID = new SimpleIntegerProperty();
        private final IntegerProperty supplierID = new SimpleIntegerProperty();
        private final IntegerProperty quantityInReceipt = new SimpleIntegerProperty();
        private final IntegerProperty totalInReceipt = new SimpleIntegerProperty();
        private final IntegerProperty productNr = new SimpleIntegerProperty();


        public Product (){
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

        public void setIDProduct(int ID) {
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







    public int getStock() {
        return stock.get();
    }

    public IntegerProperty stockProperty() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock.set(stock);
    }

    public int getCategory() {
        return categoryID.get();
    }

    public IntegerProperty categoryProperty() {
        return categoryID;
    }

    public void setCategory(int category) {
        this.categoryID.set(category);
    }

    public int getSupplier() {
        return supplierID.get();
    }

    public IntegerProperty supplierProperty() {
        return supplierID;
    }

    public void setSupplier(int supplier) {
        this.supplierID.set(supplier);
    }

    public int getQuantityInReceipt() {
        return quantityInReceipt.get();
    }


    public IntegerProperty quantityInReceiptProperty() {
        return quantityInReceipt;
    }
    public void setQuantityInReceipt(int quantity){
            this.quantityInReceipt.set(quantity);
    }

    public int getTotalInReceipt() {
        return totalInReceipt.get();
    }

    public IntegerProperty totalInReceiptProperty() {
        return totalInReceipt;
    }
    public void setTotalInReceipt(int total){
        this.totalInReceipt.set(total);
    }

    public int getProductNr() {
        return productNr.get();
    }

    public IntegerProperty productNrProperty() {
        return productNr;
    }

    public void setProductNr(int Nr){
            this.productNr.set(Nr);
    }
}


