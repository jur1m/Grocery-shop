package com.test.demo.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Category {
    private final StringProperty categoryName = new SimpleStringProperty();
    private final IntegerProperty categoryID = new SimpleIntegerProperty();
    private final StringProperty categoryDescription = new SimpleStringProperty();

    public Category(){

    }


    public String getCategoryName() {
        return categoryName.get();
    }

    public StringProperty categoryNameProperty() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName.set(categoryName);
    }

    public String getCategoryDescription() {
        return categoryDescription.get();
    }

    public StringProperty categoryDescriptionProperty() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription.set(categoryDescription);
    }

    public int getCategoryID() {
        return categoryID.get();
    }

    public IntegerProperty categoryIDProperty() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID.set(categoryID);
    }
}
