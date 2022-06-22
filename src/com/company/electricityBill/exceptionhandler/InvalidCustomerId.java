package com.company.electricityBill.exceptionhandler;
/**
 * contains logic of exceptionHandler
 */
public class InvalidCustomerId extends RuntimeException{
    String message;
    public InvalidCustomerId(String message){
        this.message = message;
    }
   public String toString() {
        return message;
   }
}
