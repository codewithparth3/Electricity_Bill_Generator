package com.company.electricityBill.service;

import com.company.electricityBill.Dao.AccountDao;

import com.company.electricityBill.Dao.TransactionDao;
import com.company.electricityBill.Dao.UserDao;
import com.company.electricityBill.model.AccountDetails;

import com.company.electricityBill.model.TransactionDetails;
import com.company.electricityBill.model.UserDetails;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

import static com.company.electricityBill.service.BillCalculator.calculate;

public class UserInputOutput {

    /**
     * userInput method contains the main logic of electricity board
     * user input output is given by userInput method
     *
     * @param sc         input from user
     * @param customerId customer's unique Id
     */
    public static void userInput(Scanner sc, String customerId) {
        UserDao userDao = new UserDao();
        AccountDao accountDao = new AccountDao();
        TransactionDao transactionDao = new TransactionDao();
        for (int i = 1; i < 4; i++) {
            System.out.println("Would you like to proceed");
            System.out.println("Please Select Y or N :");
            char input = sc.next().charAt(0);
            if (input == 'N' || input == 'n') {
                System.out.println("      ********** You have successfully exit **********       ");
                System.out.println("              ********** Thank You **********                ");
                break;
            } else {
                UUID uuid = UUID.randomUUID();
                LocalDateTime now =  LocalDateTime.now();
                UserDetails userDetails = userDao.getById(Long.parseLong(customerId));
                double billAmount = calculate(userDetails.getUnits(), (userDetails.getState()));
                double  totalAmount = billAmount + (billAmount * 0.15);
                switch (input) {
                    case 'Y', 'y' -> {
                        System.out.println("Press 1 To check the consumed units");
                        System.out.println("Press 2 To check the Bill ");
                        System.out.println("Press 3 To Pay the Bill");
                        System.out.println("Press 4 To exit");
                        int firstInput = sc.nextInt();
                        switch (firstInput) {
                            case 1:
                                System.out.println("Customer Name - " + userDetails.getCustomerName() + " and Consumed Units - " + userDetails.getUnits());
                                break;
                            case 2:
                                System.out.println("The Bill amount of total consumed units is " + billAmount);
                                System.out.println("GST to be added - " +(billAmount*0.15));
                                System.out.println("Now The total bill of " + userDetails.getCustomerName() + " is " + totalAmount);
                                break;
                            case 3:
                                System.out.println("Do you want to Proceed further for payment");
                                System.out.println("Please Select Y -> Yes or N -> No ");
                                char secondInput = sc.next().charAt(0);
                                switch (secondInput) {
                                    case 'y', 'Y' -> {
                                        System.out.println("To Pay bill from your wallet then Press Y");
                                        char thirdInput = sc.next().charAt(0);
                                        switch (thirdInput) {
                                            case 'Y', 'y' -> {
                                                System.out.println("Now Bill amount to be paid is " + totalAmount);
                                                System.out.println("Wallet balance - " + userDetails.getWallet());
                                                System.out.println("Press Y to complete the payment");
                                                System.out.println("Press N to cancel the payment");
                                                char fourthInput = sc.next().charAt(0);
                                                switch (fourthInput) {
                                                    case 'y':
                                                    case 'Y':
                                                        if (userDetails.getWallet() > totalAmount) {
                                                            long paid = (long) (userDetails.getWallet() - totalAmount);
                                                            System.out.println("Remaining amount after bill payment is " + paid);
                                                            userDetails.setWallet(paid);
                                                            userDao.save(userDetails);
                                                            TransactionDetails transactionDetails = new TransactionDetails(customerId, uuid.toString() ,now.toString() ,"success ", totalAmount);
                                                            transactionDao.save(transactionDetails);
                                                            System.out.println("You have successfully completed your bill payment");
                                                            System.out.println("Your transaction Id - " + uuid + " transaction time - " + now + " transaction status - Success");
                                                            if (fourthInput == 'Y' || fourthInput == 'y') {
                                                                i = 4;
                                                                break;
                                                            }
                                                        } else {
                                                            String cardNumber = null;
                                                            System.out.println("Your balance is insufficient");
                                                            System.out.println("Now press Y to add money to your wallet");
                                                            char fifthInput = sc.next().charAt(0);
                                                            switch (fifthInput) {
                                                                case 'Y', 'y' -> {
                                                                    cardNumber = CardValidation.cardDetails();
                                                                }
                                                                default -> {
                                                                    System.out.println("Invalid Input");
                                                                    System.out.println("Please Re-entered");
                                                                    break;
                                                                }
                                                            }
                                                            AccountDetails accountDetails = accountDao.getByCardNumber(Long.parseLong(cardNumber));
                                                            System.out.println("Entered card details are - " + accountDetails.getCardNumber() + "  Card Holder Name - " + accountDetails.getHolderName() + "  Balance - " + accountDetails.getBalance());
                                                            System.out.println("Now How much money do you want to add in your wallet - ");
                                                            long money = sc.nextInt();
                                                            System.out.println("Money is added successfully in your wallet");
                                                            long updateWallet = money + userDetails.getWallet();
                                                            System.out.println("Now updated wallet balance is " + updateWallet);
                                                            System.out.println("Again press Y to complete the payment");
                                                            char sixthinput = sc.next().charAt(0);
                                                            switch (sixthinput) {
                                                                case 'Y', 'y' -> {
                                                                    TransactionDetails transactionDetails = new TransactionDetails(customerId, uuid.toString() ,now.toString() ,"success ", totalAmount);
                                                                    transactionDao.save(transactionDetails);
                                                                    System.out.println("You have successfully completed your bill payment");
                                                                    System.out.println("YOUR TRANSACTION ID - " + uuid + " TRANSACTION TIME - " + now + " TRANSACTION STATUS - Success");
                                                                }
                                                                default -> {
                                                                    System.out.println("Invalid Input");
                                                                    System.out.println("Please Re-entered");
                                                                    break;
                                                                }
                                                            }
                                                            if (sixthinput == 'Y' || sixthinput == 'y' || fourthInput == 'Y' || fourthInput == 'y') {
                                                                i = 4;
                                                                break;
                                                            }
                                                            break;
                                                        }
                                                    case 'N':
                                                    case 'n':
                                                        System.out.println("Your Transaction is cancelled due to payment is not done");
                                                        System.out.println("      ********** You have successfully exit **********       ");
                                                        System.out.println("              ********** Thank You **********                ");
                                                        if (secondInput == 'N' || secondInput == 'n') {
                                                            i = 4;
                                                            break;
                                                        }
                                                        break;
                                                }
                                            }
                                            default -> {
                                                System.out.println("Invalid Input");
                                                System.out.println("Please Re-entered");
                                                break;
                                            }
                                        }
                                    }
                                    default -> {
                                        System.out.println("Invalid Input");
                                        System.out.println("Please Re-entered");
                                        break;
                                    }
                                }
                                System.out.println("      ********** You have successfully exit **********       ");
                                System.out.println("              ********** Thank You **********                ");
                                if (secondInput == 'N' || secondInput == 'n') {
                                    i = 4;
                                    break;
                                }
                                break;
                            case 4:
                                System.out.println("      ********** You have successfully exit **********       ");
                                System.out.println("              ********** Thank You **********                ");
                                if (firstInput == 4) {
                                    i = 4;
                                    break;
                                }

                            default:
                                System.out.println("Invalid Input");
                                System.out.println("Please Re-entered");
                                break;
                        }
                    }
                    default -> {
                        System.out.println("Invalid Input");
                        System.out.println("Please Re-entered");
                        break;
                    }
                }
            }
        }
    }
}