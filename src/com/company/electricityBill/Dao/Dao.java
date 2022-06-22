package com.company.electricityBill.Dao;

import java.sql.SQLException;

/**
 * Dao interface
 * @param <T>
 */
public interface Dao<T> {
    T getById(long customerId) throws SQLException;

    boolean save(T t);

    boolean update(T t);
}
