package com.company.electricityBill.model;

/**
 * represents UserDetails
 */
public class UserDetails {
    private int id;
    private long customerId;
    private String customerName;
    private String state;
    private int units;
    private long wallet;

    public UserDetails() {
    }

    /**constructor of UserDetails
     *
     * @param id
     * @param customerId
     * @param customerName
     * @param state
     * @param units
     * @param wallet
     */
    public UserDetails(int id, long customerId, String customerName, String state, int units, long wallet) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.state = state;
        this.units = units;
        this.wallet = wallet;
    }

    public int getId() {
        return id;
    }

    /**
     *
     * @return long representing the UserDetail's CustomerId
     */
    public long getCustomerId() {
        return customerId;
    }

    /**Sets the UserDetail's customerId
     * @param customerId a long containing the UserDetail's customerId
     */
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

    public long getWallet() {
        return wallet;
    }

    public void setWallet(long wallet) {
        this.wallet = wallet;
    }

     public boolean save(UserDetails wallet) {
        return true;
    }
}
