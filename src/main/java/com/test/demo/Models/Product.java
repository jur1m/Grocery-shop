package com.test.demo.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {
        private StringProperty productName = new SimpleStringProperty();
        private IntegerProperty ID = new SimpleIntegerProperty();
        private IntegerProperty pricePerUnit = new SimpleIntegerProperty();
        private IntegerProperty stock = new SimpleIntegerProperty();
        private StringProperty category = new SimpleStringProperty();
        private StringProperty supplier = new SimpleStringProperty();


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







    public int getStock() {
        return stock.get();
    }

    public IntegerProperty stockProperty() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock.set(stock);
    }

    public String getCategory() {
        return category.get();
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getSupplier() {
        return supplier.get();
    }

    public StringProperty supplierProperty() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier.set(supplier);
    }
}


