package mx.ipn.www.finalproject.model.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;
import mx.ipn.www.finalproject.model.*;
import mx.ipn.www.finalproject.model.dao.SeguimientoDAO;

/**
 * This class provides methods to populate DB Table of seguimiento
 */
public class SeguimientoDAOImpl implements SeguimientoDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO seguimiento ("
        + "idSeguimiento, Cumplimiento, Fecha, Comida_idComida, AlimentosEquivalentes_idAlimentosEquivalentes"
        + ") VALUES (?, ?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idSeguimiento, Cumplimiento, Fecha, Comida_idComida, AlimentosEquivalentes_idAlimentosEquivalentes "
        + "FROM seguimiento WHERE "
        + "idSeguimiento = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE seguimiento SET "
        + "Cumplimiento = ?, Fecha = ?, Comida_idComida = ?, AlimentosEquivalentes_idAlimentosEquivalentes = ? "
        + "WHERE "
        + "idSeguimiento = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM seguimiento WHERE "
        + "idSeguimiento = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Seguimiento bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getIdseguimiento());
            ps.setString(2, bean.getCumplimiento());
            if (bean.getFecha() != null)
                ps.setDate(3, new java.sql.Date(bean.getFecha().getTime()));
            else
                ps.setNull(3, Types.DATE);
            ps.setInt(4, bean.getComidaIdcomida());
            ps.setInt(5, bean.getAlimentosequivalentesIdalimentosequivalentes());
            ps.executeUpdate();
        }finally {
            close(ps);
        }
    }

    /**
     * Retrive a record from Database.
     * @param beanKey   The PK Object to be retrived.
     * @param conn      JDBC Connection.
     * @exception       SQLException if something is wrong.
     */
    public Seguimiento load(SeguimientoKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getIdseguimiento());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Seguimiento) results.get(0);
            else
                return null;
        }finally {
            close(rs);
            close(ps);
        }
    }

    /**
     * Update a record in Database.
     * @param bean   The Object to be saved.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void update(Seguimiento bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, bean.getCumplimiento());
            if (bean.getFecha() != null)
                ps.setDate(2, new java.sql.Date(bean.getFecha().getTime()));
            else
                ps.setNull(2, Types.DATE);
            ps.setInt(3, bean.getComidaIdcomida());
            ps.setInt(4, bean.getAlimentosequivalentesIdalimentosequivalentes());
            ps.setInt(5, bean.getIdseguimiento());
            ps.executeUpdate();
        }finally {
            close(ps);
        }
    }

    /**
     * Create a new record in Database.
     * @param bean   The PK Object to be deleted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void delete(SeguimientoKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getIdseguimiento());
            ps.executeUpdate();
        }finally {
            close(ps);
        }
    }
    
    /**
     * Populate the ResultSet.
     * @param rs     The ResultSet.
     * @return       The Object to retrieve from DB.
     * @exception    SQLException if something is wrong.
     */
    protected List<Seguimiento> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Seguimiento>();
        while (rs.next()) {
            Seguimiento bean = new Seguimiento();
            bean.setIdseguimiento(rs.getInt("idSeguimiento"));
            bean.setCumplimiento(rs.getString("Cumplimiento"));
            bean.setFecha(rs.getDate("Fecha"));
            bean.setComidaIdcomida(rs.getInt("Comida_idComida"));
            bean.setAlimentosequivalentesIdalimentosequivalentes(rs.getInt("AlimentosEquivalentes_idAlimentosEquivalentes"));
            results.add(bean);
        }
        return results;
    }

    /**
     * Close JDBC Statement.
     * @param stmt  Statement to be closed.
     */
    protected void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            }catch(SQLException e){}
        }
    }

    /**
     * Close JDBC ResultSet.
     * @param rs  ResultSet to be closed.
     */
    protected void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            }catch(SQLException e){}
        }
    }
}