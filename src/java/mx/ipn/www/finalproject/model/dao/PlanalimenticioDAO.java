package mx.ipn.www.finalproject.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import mx.ipn.www.finalproject.model.*;

/**
 * This interface provides methods to populate DB Table of planalimenticio
 */
public interface PlanalimenticioDAO {
    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Planalimenticio bean, Connection conn) throws SQLException;

    /**
     * Retrive a record from Database.
     * @param beanKey   The PK Object to be retrived.
     * @param conn      JDBC Connection.
     * @exception       SQLException if something is wrong.
     */
    public Planalimenticio load(PlanalimenticioKey key, Connection conn) throws SQLException;

    /**
     * Update a record in Database.
     * @param bean   The Object to be saved.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void update(Planalimenticio bean, Connection conn) throws SQLException;

    /**
     * Create a new record in Database.
     * @param bean   The PK Object to be deleted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void delete(PlanalimenticioKey key, Connection conn) throws SQLException;
}