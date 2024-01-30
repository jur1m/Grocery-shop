package com.test.demo.Models;

import java.util.Date;

public class Receipt {
    private int receiptValue;
    private int employeeID;
    private int clientID;
    private int receiptID;
    private Date date = new Date();


    public int getReceiptValue() {
        return receiptValue;
    }

    public void setReceiptValue(int receiptValue) {
        this.receiptValue = receiptValue;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(int receiptID) {
        this.receiptID = receiptID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
