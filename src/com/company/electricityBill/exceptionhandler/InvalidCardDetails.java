package com.company.electricityBill.exceptionhandler;

public class InvalidCardDetails extends RuntimeException {
    String message;
    public InvalidCardDetails(String message){
        this.message = message;
    }
    public String toString() {
        return message;
    }
}
