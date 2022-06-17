package com.company.electricityBill.exceptionhandler;

public class InvalidCustomerId extends RuntimeException{
    String message;
    public InvalidCustomerId(String message){
        this.message = message;
    }
   public String toString() {
        return message;
   }
}
