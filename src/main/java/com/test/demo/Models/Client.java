package com.test.demo.Models;

import javafx.beans.property.*;

public class Client {

    private IntegerProperty ID = new SimpleIntegerProperty();
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private IntegerProperty points = new SimpleIntegerProperty();
    private StringProperty address = new SimpleStringProperty();


    public Client(){

    }

    public int getID() {
        return ID.get();
    }

    public IntegerProperty getIDProperty() {
        return ID;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    // FirstName Property
    public String getFirstName() {
        return firstName.get();
    }
    public javafx.beans.property.StringProperty getFirstNameProperty() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    // LastName Property
    public String getLastName() {
        return lastName.get();
    }
    public javafx.beans.property.StringProperty getLastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName.set(lastName);
    }

    // Address Property
    public String getAddress() {
        return address.get();
    }

    public javafx.beans.property.StringProperty getAddressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    //Points property
    public int getPoints(){ return points.get();}

    public javafx.beans.property.IntegerProperty getPointsProperty() {
        return points;
    }

    public void setPoints(int points){this.points.set(points);}

    public String getPointsString(){
        String pointsS = String.valueOf(getPoints());
        return pointsS;
    }

}


