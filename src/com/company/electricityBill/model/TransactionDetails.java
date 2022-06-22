package com.company.electricityBill.model;

/**
 * represents TransactionDetails
 */
public class TransactionDetails {
    private int id;
    private long customerId;
    private long transactionId;
    private int transactionTime;
    private String transactionStatus;
    private long amountPaid;

    public TransactionDetails() {
        this.id = id;
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.transactionStatus = transactionStatus;
        this.transactionTime = transactionTime;
        this.amountPaid = amountPaid;
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

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public int getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(int transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public long getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(long amountPaid) {
        this.amountPaid = amountPaid;
    }

}

