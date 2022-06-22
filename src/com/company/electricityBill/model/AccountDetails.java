package com.company.electricityBill.model;

/**
 * represents AccountDetails
 */
public class AccountDetails {
    private int id;
    private long customerId;
    private long cardNumber;
    private int cvv;
    private int pin;
    private long balance;
    private String holderName;

    public AccountDetails() {
    }

    public AccountDetails(int id, long customerId, long cardNumber, int cvv, int pin, long balance, String holderName) {
        this.id = id;
        this.customerId = customerId;
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

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
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

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
}
