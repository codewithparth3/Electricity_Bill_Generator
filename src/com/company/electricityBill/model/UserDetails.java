package com.company.electricityBill.model;

public class UserDetails {
    private int id;
    private long customerId;
    private String customerName;
    private String state;
    private int units;

    public UserDetails() {
    }

    public UserDetails(int id, long customerId, String customerName, String state, int units) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.state = state;
        this.units = units;
    }

    public int getId() {
        return id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}
