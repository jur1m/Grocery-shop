package com.test.demo.TestingPackage;
import com.test.demo.Models.User;
import javafx.beans.property.*;

public class UserWProperties  {
    private IntegerProperty ID = new SimpleIntegerProperty();
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private StringProperty username = new SimpleStringProperty();
    private  StringProperty password = new SimpleStringProperty();
    private  BooleanProperty isAdmin = new SimpleBooleanProperty();

    public UserWProperties(int ID, String firstName, String lastName, String username, String password, boolean isAdmin) {
        this.ID = new SimpleIntegerProperty(ID);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.isAdmin = new SimpleBooleanProperty(isAdmin);
    }

    public UserWProperties() {

    }

    // ID Property
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
    public StringProperty getFirstNameProperty() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    // LastName Property
    public String getLastName() {
        return lastName.get();
    }
    public StringProperty getLastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName.set(lastName);
    }

    // Username Property
    public String getUsername() {
        return username.get();
    }

    public StringProperty getUsernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    // Password Property
    public String getPassword() {
        return password.get();
    }

    public StringProperty getPasswordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    // Status Property
    public boolean getIsAdmin() {
        return isAdmin.get();
    }

    public BooleanProperty getIsBooleanAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin.set(isAdmin);
    }
}
