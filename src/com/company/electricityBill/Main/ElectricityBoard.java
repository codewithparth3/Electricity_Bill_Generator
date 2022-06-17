package com.company.electricityBill.Main;

import com.company.electricityBill.config.DbConnectivity;
import com.company.electricityBill.exceptionhandler.InvalidCustomerId;
import com.company.electricityBill.model.UserDetails;
import com.company.electricityBill.service.UserInputOutput;
import com.company.electricityBill.Dao.UserDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ElectricityBoard {
    static int i;
    //static long customerId; //Customer Id in the form of Number only
   // String valid;

    public static void main(String[] args) throws Exception {
        UserDao user = new UserDao();

           // Statement st = null;
            System.out.println("             ********** WELCOME TO THE ELECTRICITY BOARD **********             ");
            System.out.println("Please Enter Customer Id Number :");
            Scanner sc = new Scanner(System.in);
            String customerId = Long.toString(sc.nextLong());
        if (customerId.length() != 9) {
            try {
                String query = "select * from userdetails where customerId = customerId";
                DbConnectivity.getConnection();
                PreparedStatement ps = DbConnectivity.getConnection().prepareStatement(customerId);
                ResultSet rs = ps.executeQuery(query);

                throw new InvalidCustomerId("You have Entered Invalid Customer Id");
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Re-entered customer Id");
                char input = sc.next().charAt(0);
                //UserInputOutput.userInput(input, sc, customerId);
                //String valid = getId
                // validation to check wheather customer is present in the database
                do {
                    System.out.println("Would you like to proceed");
                    System.out.println("Please Select Y or N :");
                    input = sc.next().charAt(0);
                   // UserInputOutput.userInput(input, sc, customerId);
                }
                while (customerId.length() != 9);
            }
        } else {
            for(i=1;i<4;i++){
                System.out.println("Would you like to proceed");
                System.out.println("Please Select Y or N :");
                char input = sc.next().charAt(0);
                switch (input) {
                    case 'Y':
                    case 'y':
                        System.out.println("Press 1 To check the consumed units");
                        System.out.println("Press 2 To check the Bill ");
                        System.out.println("Press 3 To Pay the Bill");
                        System.out.println("Press 4 To exit");
                        int firstinput = sc.nextInt();
                        switch (firstinput) {
                            case 1:
                                UserDetails userDetails = user.getById(Long.parseLong(customerId));
                                System.out.println("Customer Name - " + userDetails.getCustomerName() + " and Consumed Units - " + userDetails.getUnits());
                                    break;

                            //case 2:
                                   // System.out.println("The total bill for a customer Id " + rs.getInt(1) + " is  " + rs.getBigDecimal(2));
                               // break;
                            case 3:
                                System.out.println("Do you want to Proceed your Payment");
                                System.out.println("Please Select Y -> Yes or N -> No ");
                                char secondinput = sc.next().charAt(0);
                                switch (secondinput) {
                                    case 'y':
                                    case 'Y':
                                        System.out.println("The total bill amount is ");
                                        System.out.println("   ");
                                        System.out.println("Press Y to complete the payment");
                                        char third = sc.next().charAt(0);
                                        switch (third) {
                                            case 'y':
                                            case 'Y':
                                                System.out.println("You have successfully completed your Bill payment");
                                                System.out.println("Thank you we have received your Bill payment");
                                                System.out.println("Your transaction Id is ");
                                        }break;
                                }
                                break;
                            case 'N':
                            case 'n':
                                System.out.println("You have successfully exit");
                                break;
                            default:
                                System.out.println("Invalid Input");
                                System.out.println("Please Re-entered");

                                break;

                        }
                }
                //UserInputOutput.userInput(input, sc, customerId);
            }
        }
    }
}
