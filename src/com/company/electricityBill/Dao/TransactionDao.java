package com.company.electricityBill.Dao;

import com.company.electricityBill.config.DbConnectivity;
import com.company.electricityBill.model.TransactionDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDao implements Dao<TransactionDetails> {
    /**
     *
     * @param customerId of userDetails class
     * @return transactionDetails
     * @throws SQLException
     */
    @Override
    public TransactionDetails getById(long customerId) {
        String sql = "select * from transactionDetails where customerId = ?";
        try {
            Connection connection = DbConnectivity.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, customerId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                TransactionDetails transactionDetails = new TransactionDetails();
                transactionDetails.setId(rs.getInt(1));
                transactionDetails.setCustomerId(rs.getString(2));
                transactionDetails.setTransactionId(rs.getString(3));
                transactionDetails.setTransactionStatus(rs.getString(5));
                transactionDetails.setAmountPaid(rs.getDouble(6));

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

        String sql = "insert into transactionDetails(customerId,transactionId,transactionTime,transactionStatus,amountPaid) values(?,?,?,?,?)";
        try {
            Connection connection = DbConnectivity.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, transactionDetails.getCustomerId());
            ps.setString(2, transactionDetails.getTransactionId());
            ps.setString(3, transactionDetails.getTransactionTime());
            ps.setString(4, transactionDetails.getTransactionStatus());
            ps.setDouble(5, transactionDetails.getAmountPaid());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
