/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Wed Mar 13 01:44:23 CST 2019
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package mx.ipn.www.finalproject.model.dao;

import mx.ipn.www.finalproject.model.RelComidaKey;
import mx.ipn.www.finalproject.model.RelComida;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import mx.ipn.www.finalproject.model.ComidaKey;

/**
 * This interface provides methods to populate DB Table of rel_comida
 */
public interface RelComidaDAO {
    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(RelComida bean, Connection conn) throws SQLException;

    /**
     * Retrive a record from Database.
     * @param beanKey   The PK Object to be retrived.
     * @param conn      JDBC Connection.
     * @exception       SQLException if something is wrong.
     */
    public RelComida load(RelComidaKey key, Connection conn) throws SQLException;
    
    public List<RelComida> loadByComida(ComidaKey key, Connection conn) throws SQLException;

    /**
     * Update a record in Database.
     * @param bean   The Object to be saved.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void update(RelComida bean, Connection conn) throws SQLException;

    /**
     * Create a new record in Database.
     * @param bean   The PK Object to be deleted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void delete(RelComidaKey key, Connection conn) throws SQLException;
}