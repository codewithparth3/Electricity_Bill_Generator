package com.company.electricityBill.exceptionhandler;

public class InvalidCustomerId extends RuntimeException{
    String s;
    public InvalidCustomerId(String s){
        this.s = s;
    }
    public String toString() {
        return " " + s;
    }
}
