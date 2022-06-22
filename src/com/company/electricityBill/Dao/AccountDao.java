package com.company.electricityBill.Dao;

import com.company.electricityBill.config.DbConnectivity;
import com.company.electricityBill.model.AccountDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao implements Dao<AccountDetails> {
    /**
     *
     * @param cardNumber
     * @return
     * @throws SQLException
     */
    public AccountDetails getByCardNumber(long cardNumber) throws SQLException {
        String sql = "select * from accountDetails where cardNumber =  " + cardNumber + "";
        try {
            Connection connection = DbConnectivity.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                AccountDetails accountDetails = new AccountDetails();
                accountDetails.setId(rs.getInt(1));
                accountDetails.setCardNumber(rs.getLong(2));
                accountDetails.setCvv(rs.getInt(3));
                accountDetails.setPin(rs.getInt(4));
                accountDetails.setBalance(rs.getLong(5));
                accountDetails.setHolderName(rs.getString(6));

                return accountDetails;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AccountDetails getById(long customerId) throws SQLException {
        return null;
    }

    @Override
    public boolean save(AccountDetails accountDetails) {
        return false;
    }

    @Override
    public boolean update(AccountDetails accountDetails) {
        return false;
    }
}
