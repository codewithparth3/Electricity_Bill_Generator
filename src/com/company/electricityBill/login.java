package com.company.electricityBill;
import com.company.electricityBill.api.DBconnectivity;
import com.company.electricityBill.exceptionhandler.InvalidCustomerId;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class login
{
    long cust_id; //bill id in the form of Number only
    char z;
    public static void main(String[] args) throws Exception
    {
        Statement stmt=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Electricity","root","jerry");
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from userdetails");
            while(rs.next())
               System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
        }catch(Exception e){ System.out.println(e);}



        System.out.println("             ********** WELCOME TO THE ELECTRICITY BOARD **********             ");
        System.out.println("Please Enter Customer Id Number :");
        Scanner sc = new Scanner(System.in);
        long cust_id = sc.nextLong();
        String s = Long.toString(cust_id);
        if (s.length()!=9) {
            try{
                throw new InvalidCustomerId("You have Entered Invalid Customer Id");
            }catch (Exception e){
                    System.out.println(e);
                    System.out.println("Re-entered customer Id");
                    do{
                        cust_id = sc.nextLong();
                        s = Long.toString(cust_id);
                        System.out.println("would you like to proceed");
                        System.out.println("Please Select Y or N :");
                        char z = sc.next().charAt(0);
                        switch(z)
                        {
                            case 'Y': System.out.println("Press 1 To check the Customer details and consumed units");
                                System.out.println("Press 2 To check the price of consumption per unit ");
                                System.out.println("Press 3 To Pay the Bill");
                                System.out.println("Press 4 To ");
                                int a= sc.nextInt();
                                switch (a)
                                {
                                    case 1 : ResultSet rs=stmt.executeQuery("select * from userdetails");
                                        while(rs.next())
                                            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));
                                        case 2 : ResultSet rs=stmt.executeQuery("select * from userdetails");
                                        while(rs.next())
                                            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));
                                    case 1 : ResultSet rs=stmt.executeQuery("select * from userdetails");
                                        while(rs.next())
                                            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));
                                }break;
                                }




                        case 'y': System.out.println("Press 1 To check the bill");
                                System.out.println("Press 2 To check the price of consumption per unit ");
                                System.out.println("Press 3 To Pay the Bill");
                                System.out.println("Press 4 To exit");
                                int b= sc.nextInt();
                                switch (b){
                                    case 1 : ResultSet rs=stmt.executeQuery("select * from userdetails");
                                        while(rs.next())
                                            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                                }break;
                            case 'N': System.out.println("You have successfully exit");break;
                            case 'n': System.out.println("You have successfully exit");break;
                            default: System.out.println("Invalid Input");
                                System.out.println("Please Re-entered");break;
                        }
                        //if (s.length()<9)
                            //System.out.println("Re-entered customer Id");

                    }while (s.length()!=9);

            }
        } else {
            System.out.println("would you like to proceed");
            System.out.println("Please Select Y or N :");
            char z = sc.next().charAt(0);
            switch(z)
            {
                case 'Y': System.out.println("Press 1 To check the bill");
                          System.out.println("Press 2 To check the price of consumption per unit ");
                          System.out.println("Press 3 To Pay the Bill");
                          System.out.println("Press 4 To exit");
                          int a= sc.nextInt();
                          switch (a){
                          case 1 : ResultSet rs=stmt.executeQuery("select * from userdetails");
                          while(rs.next())
                            System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                }break;
                case 'y': System.out.println("Press 1 To check the Customer details and consumed units");
                          System.out.println("Press 2 To check the price of consumption per unit ");
                          System.out.println("Press 3 To Pay the Bill");
                          System.out.println("Press 4 To exit");
                          int b= sc.nextInt();
                          switch (b){
                          case 1 : ResultSet rs=stmt.executeQuery("select * from userdetails");
                            while(rs.next())
                                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                    }break;
                case 'N': System.out.println("You have successfully exit");break;
                case 'n': System.out.println("You have successfully exit");break;
                default: System.out.println("Invalid Input");
                         System.out.println("Please Re-entered");break;
            }
        }
    }
}
