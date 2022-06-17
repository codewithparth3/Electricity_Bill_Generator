package com.company.electricityBill.Dao;

import java.sql.SQLException;

public interface Dao<T> {

    T getById(long id) throws SQLException;

    boolean save(T t);

    boolean update(T t);

}
