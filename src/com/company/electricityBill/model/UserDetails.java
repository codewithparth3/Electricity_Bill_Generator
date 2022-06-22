package com.company.electricityBill.model;

/**
 * represents UserDetails
 */
public class UserDetails {
    private String customerId;
    private String customerName;
    private String state;
    private int units;
    private long wallet;

    public UserDetails() {
    }

    /**
     *
     * @return long representing the UserDetail's CustomerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**Sets the UserDetail's customerId
     * @param customerId a long containing the UserDetail's customerId
     */
    public void setCustomerId(String customerId) {
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

    public long getWallet() {
        return wallet;
    }

    public void setWallet(long wallet) {
        this.wallet = wallet;
    }

}
