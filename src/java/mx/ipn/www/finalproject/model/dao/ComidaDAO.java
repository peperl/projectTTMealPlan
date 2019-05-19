/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Wed Mar 13 01:44:23 CST 2019
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package mx.ipn.www.finalproject.model.dao;

import mx.ipn.www.finalproject.model.ComidaKey;
import mx.ipn.www.finalproject.model.Comida;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import mx.ipn.www.finalproject.model.PlanalimenticioKey;

/**
 * This interface provides methods to populate DB Table of comida
 */
public interface ComidaDAO {
    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Comida bean, Connection conn) throws SQLException;

    /**
     * Retrive a record from Database.
     * @param beanKey   The PK Object to be retrived.
     * @param conn      JDBC Connection.
     * @exception       SQLException if something is wrong.
     */
    public Comida load(ComidaKey key, Connection conn) throws SQLException;

    public List<Comida> loadByPlanAlimenticio(PlanalimenticioKey key, Connection conn) throws SQLException;
    /**
     * Update a record in Database.
     * @param bean   The Object to be saved.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void update(Comida bean, Connection conn) throws SQLException;

    /**
     * Create a new record in Database.
     * @param bean   The PK Object to be deleted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void delete(ComidaKey key, Connection conn) throws SQLException;

    
}