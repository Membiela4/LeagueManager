package dao;

import modelDomain.Player;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> extends AutoCloseable {

    List<T> findAll() throws SQLException;
    T FindByid(int id);

    Player FindByName(String name) throws SQLException;

    T save(T entity) throws SQLException;

    void delete(String dni);
}
