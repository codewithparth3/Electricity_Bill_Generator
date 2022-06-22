package com.company.electricityBill.util;

import java.time.LocalDateTime;

public class Constant {
    public double total(){
        double a=30;
        return a;
    }
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        double tax = 20;

        System.out.println(s1 == s2); // s1 & s2 are in String constant pool whereas s3 are in heap
        System.out.println(s2 == s3); //

        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(tax);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toString());
        java.sql.Date date = java.sql.Date.valueOf(localDateTime.toLocalDate());
        java.sql.Time time = java.sql.Time.valueOf(localDateTime.toLocalTime());
    }
}
