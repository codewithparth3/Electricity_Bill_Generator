package com.company.electricityBill.model;

public class AccountDetails {
    private int id;
    private String cardNumber;
    private int cvv;
    private int pin;
    private String balance;
    private String holderName;

    public AccountDetails() {
    }

    public AccountDetails(int id, String cardNumber, int cvv, int pin, String balance, String holderName) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.pin = pin;
        this.balance = balance;
        this.holderName = holderName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
}
