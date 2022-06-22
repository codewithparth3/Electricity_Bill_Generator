package com.company.electricityBill.model;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * represents TransactionDetails
 */
public class TransactionDetails {
    private int id;
    private String customerId;
    private String transactionId;
    private String transactionTime;
    private String transactionStatus;
    private double amountPaid;

    public TransactionDetails(){}

    public TransactionDetails(String customerId, String transactionId, String transactionTime, String transactionStatus, double amountPaid){
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.transactionTime =transactionTime;
        this.transactionStatus = transactionStatus;
        this.amountPaid = amountPaid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

}

