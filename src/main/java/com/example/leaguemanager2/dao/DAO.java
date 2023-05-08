package com.example.leaguemanager2.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> extends AutoCloseable {

    List<T> findAll() throws SQLException;
    T findByid(int id) throws SQLException;

    T findByName(String name) throws SQLException;

    T save(T entity) throws SQLException;

    void delete(String dni) throws SQLException;
}
