package com.company.electricityBill.Dao;

import com.company.electricityBill.config.DbConnectivity;
import com.company.electricityBill.model.TransactionDetails;
import com.company.electricityBill.model.UserDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDao implements Dao<TransactionDetails> {

    @Override
    public TransactionDetails getById(long id) throws SQLException {
        String sql = "select Id, customerId, transactionId, transactionTime, transactionStatus, amountPaid from Transactiondetails where id = ?";
        try {
            PreparedStatement ps = DbConnectivity.getConnection().prepareStatement(sql);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                TransactionDetails transactionDetails = new TransactionDetails();
                transactionDetails.setId(rs.getInt(1));
                transactionDetails.setCustomerId(rs.getLong(2));
                transactionDetails.setTransactionId(rs.getString(3));
                transactionDetails.setTransactionTime(rs.getInt(4));
                transactionDetails.setTransactionStatus(rs.getString(5));
                transactionDetails.setAmountPaid(rs.getString(6));

                return transactionDetails;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(TransactionDetails transactionDetails) {
        return false;
    }

    @Override
    public boolean save(TransactionDetails transactionDetails) {
        String sql = "Insert into transactiondetails values";
        try {
            PreparedStatement ps = DbConnectivity.getConnection().prepareStatement(sql);
            //ps.setInt(1,);
           // ps.setLong(2,);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                transactionDetails = new TransactionDetails();
                transactionDetails.setId(rs.getInt(1));
                transactionDetails.setCustomerId(rs.getLong(2));
                transactionDetails.setTransactionId(rs.getString(3));
                transactionDetails.setTransactionTime(rs.getInt(4));
                transactionDetails.setTransactionStatus(rs.getString(5));
                transactionDetails.setAmountPaid(rs.getString(6));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return false;
    }
}
