package mx.ipn.www.finalproject.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import mx.ipn.www.finalproject.model.*;

/**
 * This interface provides methods to populate DB Table of alimentosexcluidos
 */
public interface AlimentosexcluidosDAO {
    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Alimentosexcluidos bean, Connection conn) throws SQLException;

    /**
     * Retrive a record from Database.
     * @param beanKey   The PK Object to be retrived.
     * @param conn      JDBC Connection.
     * @exception       SQLException if something is wrong.
     */
    public Alimentosexcluidos load(AlimentosexcluidosKey key, Connection conn) throws SQLException;

    /**
     * Update a record in Database.
     * @param bean   The Object to be saved.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void update(Alimentosexcluidos bean, Connection conn) throws SQLException;

    /**
     * Create a new record in Database.
     * @param bean   The PK Object to be deleted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void delete(AlimentosexcluidosKey key, Connection conn) throws SQLException;
}