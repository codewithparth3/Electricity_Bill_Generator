package com.company.electricityBill.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectivity {

    public static Connection connection;
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Electricity?autoReconnect=true&useSSL=false", "root", "jerry");

            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getConnection();
    }
}


    /*public ResultSet getConnection(String query) throws Exception {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("Driver loaded successfully");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Electricity?autoReconnect=true&useSSL=false", "root", "jerry");
            //System.out.println("Connection established");
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }*/