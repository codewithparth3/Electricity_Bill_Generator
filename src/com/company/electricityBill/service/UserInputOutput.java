package com.company.electricityBill.service;

import com.company.electricityBill.Dao.AccountDao;
import com.company.electricityBill.Dao.UserDao;
import com.company.electricityBill.model.AccountDetails;
import com.company.electricityBill.model.UserDetails;

import java.time.LocalDateTime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

import static com.company.electricityBill.service.BillCalculator.calculate;

public class UserInputOutput {

    /**
     * userInput method contains the main logic of electricity board
     * user input output is given by userInput method
     *
     * @param sc
     * @param customerId
     * @throws SQLException are thrown when data entered by user is null from database
     */
    public static void userInput(Scanner sc, String customerId) throws SQLException {
        UserDao userDao = new UserDao();
        AccountDao accountDao = new AccountDao();
        for (int i = 1; i < 4; i++) {
            System.out.println("Would you like to proceed");
            System.out.println("Please Select Y or N :");
            char input = sc.next().charAt(0);
            if (input == 'N' || input == 'n') {
                System.out.println("      ********** You have successfully exit **********       ");
                System.out.println("              ********** Thank You **********                ");
                break;
            } else {
                UserDetails userDetails = userDao.getById(Long.parseLong(customerId));
                switch (input) {
                    case 'Y', 'y' -> {
                        System.out.println("Press 1 To check the consumed units");
                        System.out.println("Press 2 To check the Bill ");
                        System.out.println("Press 3 To Pay the Bill");
                        System.out.println("Press 4 To exit");
                        int firstInput = sc.nextInt();
                        ResultSet rs = null;
                        switch (firstInput) {
                            case 1:
                                System.out.println("Customer Name - " + userDetails.getCustomerName() + " and Consumed Units - " + userDetails.getUnits());
                                break;
                            case 2:
                                System.out.println("The total bill of " + userDetails.getCustomerName() + " is " + calculate(userDetails.getUnits(), (userDetails.getState())));
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
                                            case 'Y':
                                            case 'y':

                                                System.out.println("Now total amount to be paid is " + calculate(userDetails.getUnits(), (userDetails.getState())));
                                                System.out.println("Wallet balance - " + userDetails.getWallet());
                                                System.out.println("Press Y to complete the payment");
                                                System.out.println("Press N to cancel the payment");
                                                char fourthInput = sc.next().charAt(0);
                                                switch (fourthInput) {
                                                    case 'y':
                                                    case 'Y':
                                                        if (userDetails.getWallet() > calculate(userDetails.getUnits(), (userDetails.getState()))) {
                                                            long paid = (long) (userDetails.getWallet() - calculate(userDetails.getUnits(), (userDetails.getState())));
                                                            System.out.println("Remaining amount after bill payment is " + paid);
                                                            userDetails.setWallet(paid);
                                                            userDao.save(userDetails);
                                                            System.out.println("You have successfully completed your bill payment");
                                                            LocalDateTime currentTime = LocalDateTime.now();
                                                            UUID uuid = UUID.randomUUID();
                                                            System.out.println("Your transaction Id - " + uuid + " transaction time - " + currentTime + " transaction status - Success");
                                                            if (fourthInput == 'Y' || fourthInput == 'y') {
                                                                i = 4;
                                                                break;
                                                            }
                                                        } else {
                                                            System.out.println("Your balance is insufficient");
                                                            System.out.println("Now press Y to add money to your wallet");
                                                            char fifthInput = sc.next().charAt(0);
                                                            String cardNumber = null;
                                                            switch (fifthInput) {
                                                                case 'Y':
                                                                case 'y':
                                                                    System.out.println("Enter Debit Card Number - ");
                                                                    cardNumber = Long.toString(sc.nextLong());
                                                                    if (cardNumber.length() != 16) {
                                                                        System.out.println("card number must be of 16 digits");
                                                                        System.out.println("Please re-entered card number");
                                                                        cardNumber = Long.toString(sc.nextLong());
                                                                    }
                                                                    System.out.println("Enter cvv Number - ");
                                                                    String cvv = Long.toString(sc.nextInt());
                                                                    if (cvv.length() != 3) {
                                                                        System.out.println("cvv number must be of 3 digits");
                                                                        System.out.println("Please re-entered cvv number");
                                                                        cvv = Long.toString(sc.nextInt());
                                                                    }
                                                                    System.out.println("Enter pin Number - ");
                                                                    String pin = Long.toString(sc.nextInt());
                                                                    if (pin.length() != 4) {
                                                                        System.out.println("pin must be of 4 digits");
                                                                        System.out.println("Please re-entered pin");
                                                                        pin = Long.toString(sc.nextInt());
                                                                    }
                                                                    // System.out.println("You have entered wrong cvv");
                                                                    // System.out.println("Your Transaction is cancelled due to incorrect card details");
                                                                    // System.out.println("********** EXIT **********");
                                                                    if (cardNumber.length() == i || cvv.length() == i || pin.length() == i) {
                                                                        System.out.println("You have entered invalid card details");
                                                                        System.out.println("Money is not credited in your wallet");
                                                                        System.out.println("Your Transaction is cancelled due to insufficient balance");
                                                                        if (fifthInput == 'Y' || fifthInput == 'y') {
                                                                            i = 4;
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
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
                                                                case 'Y':
                                                                case 'y':
                                                                    //TransactionDetails.setTransactionId(transactionDetails.setTransactionTime());
                                                                    //boolean transactionResult = transaction.save(transactionDetails);
                                                                    System.out.println("You have successfully completed your bill payment");
                                                                    LocalDateTime now = LocalDateTime.now();
                                                                    UUID uuid = UUID.randomUUID();
                                                                    System.out.println("YOUR TRANSACTION ID - " + uuid + " TRANSACTION TIME - " + now + " TRANSACTION STATUS - Success");
                                                            }
                                                            if (sixthinput == 'Y' || sixthinput == 'y' || fourthInput == 'Y' || fourthInput == 'y') {
                                                                i = 4;
                                                                break;
                                                            }
                                                            ;
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
                    case 'N', 'n' -> {
                        System.out.println("      ********** You have successfully exit **********       ");
                        System.out.println("              ********** Thank You **********                ");
                    }
                    default -> {
                        System.out.println("Invalid Input");
                        System.out.println("Please Re-entered");
                        System.out.println("Please Select Y or N :");
                    }
                }
            }
        }
    }
}