package com.company.electricityBill.service;


import com.company.electricityBill.Dao.UserDao;
import com.company.electricityBill.config.DbConnectivity;
import com.company.electricityBill.model.UserDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserInputOutput {}
/*    public static void userInput(char input, Scanner sc, String customerId) throws SQLException {
        do{
            switch (input) {
                case 'Y':
                case 'y':
                    System.out.println("Press 1 To check the consumed units");
                    System.out.println("Press 2 To check the Bill ");
                    System.out.println("Press 3 To Pay the Bill");
                    System.out.println("Press 4 To exit");
                    char firstinput = sc.next().charAt(0);
                    //DbConnectivity db = new DbConnectivity();
                    ResultSet rs = null;
                    switch (firstinput) {
                        case 1:
                            String query1 = String.format("select * from userdetails where customerId = %s", customerId);
                            try {

                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            while (rs.next())
                                System.out.println("Customer Name - " + rs.getString(3) + " and Consumed Units - " + rs.getInt(5));
                            break;
                        case 2:
                            String query2 = String.format("select * from billdetails where customerId = %s", customerId);
                            try {

                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            while (rs.next())
                                System.out.println("The total bill for a customer Id " + rs.getInt(1) + " is  " + rs.getBigDecimal(2));
                            break;
                        case 3:
                            System.out.println("Do you want to Proceed");
                            System.out.println("Please Select Y -> Yes or N -> No ");
                            char secondinput = sc.next().charAt(0);
                            switch (secondinput) {
                                case 'y':
                                case 'Y':
                                    System.out.println("Press Y to complete the payment");
                                    char third = sc.next().charAt(0);
                                    switch (third) {
                                        case 'y':
                                        case 'Y':
                                            System.out.println("You have successfully completed your bill payment");
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
        }while (input<4);
    }

}*/