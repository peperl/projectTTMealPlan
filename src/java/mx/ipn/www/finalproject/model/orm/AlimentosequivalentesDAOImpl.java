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
import mx.ipn.www.finalproject.model.dao.AlimentosequivalentesDAO;

/**
 * This class provides methods to populate DB Table of alimentosequivalentes
 */
public class AlimentosequivalentesDAOImpl implements AlimentosequivalentesDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO alimentosequivalentes ("
        + "idAlimentosEquivalentes, Nombre, Cantidad, Proteinas, Lipidos, Carbohidratos"
        + ") VALUES (?, ?, ?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idAlimentosEquivalentes, Nombre, Cantidad, Proteinas, Lipidos, Carbohidratos "
        + "FROM alimentosequivalentes WHERE "
        + "idAlimentosEquivalentes = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE alimentosequivalentes SET "
        + "Nombre = ?, Cantidad = ?, Proteinas = ?, Lipidos = ?, Carbohidratos = ? "
        + "WHERE "
        + "idAlimentosEquivalentes = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM alimentosequivalentes WHERE "
        + "idAlimentosEquivalentes = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Alimentosequivalentes bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getIdalimentosequivalentes());
            ps.setString(2, bean.getNombre());
            ps.setDouble(3, bean.getCantidad());
            ps.setDouble(4, bean.getProteinas());
            ps.setDouble(5, bean.getLipidos());
            ps.setDouble(6, bean.getCarbohidratos());
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
    public Alimentosequivalentes load(AlimentosequivalentesKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getIdalimentosequivalentes());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Alimentosequivalentes) results.get(0);
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
    public void update(Alimentosequivalentes bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, bean.getNombre());
            ps.setDouble(2, bean.getCantidad());
            ps.setDouble(3, bean.getProteinas());
            ps.setDouble(4, bean.getLipidos());
            ps.setDouble(5, bean.getCarbohidratos());
            ps.setInt(6, bean.getIdalimentosequivalentes());
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
    public void delete(AlimentosequivalentesKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getIdalimentosequivalentes());
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
    protected List<Alimentosequivalentes> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Alimentosequivalentes>();
        while (rs.next()) {
            Alimentosequivalentes bean = new Alimentosequivalentes();
            bean.setIdalimentosequivalentes(rs.getInt("idAlimentosEquivalentes"));
            bean.setNombre(rs.getString("Nombre"));
            bean.setCantidad(rs.getDouble("Cantidad"));
            bean.setProteinas(rs.getDouble("Proteinas"));
            bean.setLipidos(rs.getDouble("Lipidos"));
            bean.setCarbohidratos(rs.getDouble("Carbohidratos"));
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