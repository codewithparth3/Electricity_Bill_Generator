package com.company.electricityBill.Dao;

import com.company.electricityBill.config.DbConnectivity;
import com.company.electricityBill.model.TransactionDetails;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDao implements Dao<TransactionDetails> {

    private Date LocalDateTime;

    /**
     *
     * @param customerId
     * @return
     * @throws SQLException
     */
    @Override
    public TransactionDetails getById(long customerId) throws SQLException {
        String sql = "select * from transactionDetails where customerId = ?";
        try {
            Connection connection = DbConnectivity.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, customerId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                TransactionDetails transactionDetails = new TransactionDetails();
                transactionDetails.setId(rs.getInt(1));
                transactionDetails.setCustomerId(rs.getLong(2));
                transactionDetails.setTransactionId(rs.getLong(3));
                transactionDetails.setTransactionTime(rs.getInt(4));
                transactionDetails.setTransactionStatus(rs.getString(5));
                transactionDetails.setAmountPaid(rs.getLong(6));

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
        String sql = "update transactionDetails set transactionId, transactionTime, transactionStatus, amountPaid = ? where customerId = ? ";
        try {
            Connection connection = DbConnectivity.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            //long transactionId = Long.parseLong(TransactionDetails);
            //ps.setLong(1,transactionId);
            Date transactionTime = LocalDateTime;
            ps.setDate(2, transactionTime);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                transactionDetails = new TransactionDetails();
                transactionDetails.setId(rs.getInt(1));
                transactionDetails.setCustomerId(rs.getLong(2));
                transactionDetails.setTransactionId(rs.getLong(3));
                transactionDetails.setTransactionTime(rs.getInt(4));
                transactionDetails.setTransactionStatus(rs.getString(5));
                transactionDetails.setAmountPaid(rs.getLong(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
