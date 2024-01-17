package com.test.demo.Models;

public class User {

    private int ID;
    private String username;

    private String password;
    private String firstName;
    private String lastName;
    private boolean isAdmin;

    public User(){
    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public User(String firstName, String lastName, String username, String password, boolean isAdmin){

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.isAdmin=isAdmin;
    }
    public User(int ID, String firstName, String lastName, String username, String password){

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.ID = ID;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName(){return firstName;}

    public void setFirstName(String firstName){this.firstName=firstName;}

    public String getLastName(){return lastName;}

    public void setLastName(String lastName){this.lastName=lastName;}

    public boolean getIsAdmin() {return isAdmin;}

    public void setIsAdmin(boolean isAdmin){this.isAdmin=isAdmin;}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
