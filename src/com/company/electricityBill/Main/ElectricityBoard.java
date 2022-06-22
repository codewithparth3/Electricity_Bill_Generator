package com.company.electricityBill.Main;

import com.company.electricityBill.exceptionhandler.InvalidCustomerId;
import com.company.electricityBill.service.UserInputOutput;
import com.company.electricityBill.Dao.UserDao;

import java.util.Scanner;

/**This is the main class
 * contains userInput method
 */
public class ElectricityBoard {

    /**This is the main method
     * @param args
     * @throws Exception that are thrown by if condition
     */
    public static void main(String[] args) throws Exception {
        UserDao userDao = new UserDao();
        System.out.println("             ********** WELCOME TO THE ELECTRICITY BOARD **********             ");
        System.out.println("NOTE - You have only 2 attempts to enter the correct customer Id");
        System.out.println("Please Enter Customer Id Number :");
        Scanner sc = new Scanner(System.in);
        String customerId = Long.toString(sc.nextLong());
        if (customerId.length() != 9) {
            try {
                throw new InvalidCustomerId("You have Entered Invalid Customer Id");
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Only 1 attempt is left");
                System.out.println("Re-entered customer Id");
                customerId = Long.toString(sc.nextLong());
                if (userDao.getById(Long.parseLong(customerId)) == null) {
                    try {
                        throw new InvalidCustomerId("Invalid Customer : Customer with Id " + customerId + " does not exist");
                    } catch (Exception ex) {
                        System.out.println(ex);
                        System.out.println("WARNING - Last attempt is left");
                        System.out.println("Re-entered customer Id");
                        customerId = Long.toString(sc.nextLong());
                        if (userDao.getById(Long.parseLong(customerId)) == null) {
                            System.out.println("You have exceed the attempts and not allowed to Enter again");
                            System.out.println("Please Try again later");
                            System.out.println("********** EXIT **********");
                        } else {
                            System.out.println("Customer Id is Valid");
                            UserInputOutput.userInput(sc, customerId);
                        }
                    }
                }
            }
        } else if (userDao.getById(Long.parseLong(customerId)) != null) {
            System.out.println("Customer Id is Valid");
            UserInputOutput.userInput(sc, customerId);
        } else {
            if (userDao.getById(Long.parseLong(customerId)) == null) {
                try {
                    throw new InvalidCustomerId("Invalid Customer : Customer with Id " + customerId + " does not exist");
                } catch (Exception ex) {
                    System.out.println(ex);
                    System.out.println("Only 1 attempt is left");
                    System.out.println("Re-entered customer Id");
                    customerId = Long.toString(sc.nextLong());
                    if (userDao.getById(Long.parseLong(customerId)) == null) {
                        System.out.println("You have exceed the attempts and not allowed to Enter again");
                        System.out.println("Please Try again later");
                        System.out.println("********** EXIT **********");
                    } else {
                        System.out.println("Customer Id is Valid");
                        UserInputOutput.userInput(sc, customerId);
                    }
                }
            }
        }
    }
}

