package com.company.electricityBill.Dao;

import com.company.electricityBill.config.DbConnectivity;
import com.company.electricityBill.model.AccountDetails;
import com.company.electricityBill.model.TransactionDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao implements Dao<AccountDetails>{

    @Override
    public AccountDetails getById(long id) throws SQLException {
        String sql = "select Id, customerId, cardNumber, cvv, pin, balance, holderName from accountdetails where id = id";
        try {
            PreparedStatement ps = DbConnectivity.getConnection().prepareStatement(sql);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                AccountDetails accountDetails = new AccountDetails();
                accountDetails.setId(rs.getInt(1));
                accountDetails.setCardNumber(rs.getString(2));
                accountDetails.setCvv(rs.getInt(3));
                accountDetails.setPin(rs.getInt(4));
                accountDetails.setBalance(rs.getString(5));
                accountDetails.setHolderName(rs.getString(6));

                return accountDetails;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
