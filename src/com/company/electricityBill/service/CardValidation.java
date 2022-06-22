package com.company.electricityBill.service;

import com.company.electricityBill.Dao.AccountDao;
import com.company.electricityBill.exceptionhandler.InvalidCardDetails;
import com.company.electricityBill.model.AccountDetails;

import java.util.Scanner;

public class CardValidation {
    public static String cardDetails() {
        String cvv;
        String pin;
        AccountDao accountDao = new AccountDao();
        System.out.println("Enter the card details from which You have to add money to your wallet");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Debit Card Number - ");
        String cardNumber = Long.toString(sc.nextLong());
        AccountDetails accountDetails;
        do {
            if (cardNumber.length() != 16) {
                System.out.println("card number must be of 16 digits");
                System.out.println("Please re-enter card number");
                cardNumber = Long.toString(sc.nextLong());
            }
            if (accountDao.getByCardNumber(Long.parseLong(cardNumber)) == null) {
                try {
                    throw new InvalidCardDetails("Invalid Card Number : Card number does not exist ");
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Please try again and re-enter card number");
                    cardNumber = Long.toString(sc.nextLong());
                }
            }
        }
        while (cardNumber.length() != 16 || accountDao.getByCardNumber(Long.parseLong(cardNumber)) == null);
        accountDetails = accountDao.getByCardNumber(Long.parseLong(cardNumber));
        System.out.println("Enter cvv Number - ");
        cvv = Integer.toString(sc.nextInt());
        do {
            if (cvv.length() != 3) {
                System.out.println("cvv number must be of 3 digits");
                System.out.println("Please re-entered cvv number");
                cvv = Long.toString(sc.nextInt());
            }
            if (!cvv.equals(Integer.toString(accountDetails.getCvv()))) {
                System.out.println("Your cvv is incorrect");
                System.out.println("Please re-entered cvv number");
                cvv = Long.toString(sc.nextInt());
            }
        } while (cvv.length() != 3 || !cvv.equals(Integer.toString(accountDetails.getCvv())));
        System.out.println("Enter pin Number - ");
        pin = Long.toString(sc.nextInt());
        do {
            if (pin.length() != 4) {
                System.out.println("pin number must be of 4 digits");
                System.out.println("Please re-entered pin number");
                pin = Long.toString(sc.nextInt());
            }
            if (!pin.equals(Integer.toString(accountDetails.getPin()))) {
                System.out.println("Your pin is incorrect");
                System.out.println("Please re-entered pin number");
                pin = Long.toString(sc.nextInt());
            }
        } while (pin.length() != 4 || !pin.equals(Integer.toString(accountDetails.getPin())));
        return cardNumber;
    }
}