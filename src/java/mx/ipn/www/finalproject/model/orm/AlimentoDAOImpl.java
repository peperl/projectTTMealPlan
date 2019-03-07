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
import mx.ipn.www.finalproject.model.dao.AlimentoDAO;

/**
 * This class provides methods to populate DB Table of alimento
 */
public class AlimentoDAOImpl implements AlimentoDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO alimento ("
        + "idAlimento, Nombre, Cantidad, Proteinas, Lipidos, Carbohidratos, Estado, "
        + "Categoria, UnidadDeMedida"
        + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idAlimento, Nombre, Cantidad, Proteinas, Lipidos, Carbohidratos, Estado, "
        + "Categoria,  UnidadDeMedida"
        + "FROM alimento WHERE "
        + "idAlimento = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE alimento SET "
        + "Nombre = ?, Cantidad = ?, Proteinas = ?, Lipidos = ?, Carbohidratos = ?, Estado = ?, Categoria = ?, UnidadDeMedida = ? "
        + "WHERE "
        + "idAlimento = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM alimento WHERE "
        + "idAlimento = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Alimento bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getIdalimento());
            ps.setString(2, bean.getNombre());
            ps.setDouble(3, bean.getCantidad());
            ps.setDouble(4, bean.getProteinas());
            ps.setDouble(5, bean.getLipidos());
            ps.setDouble(6, bean.getCarbohidratos());
            ps.setInt(7, bean.getEstado());
            ps.setInt(8, bean.getCategoria());
            ps.setString(9, bean.getUnidadDeMedida());
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
    public Alimento load(AlimentoKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getIdalimento());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Alimento) results.get(0);
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
    public void update(Alimento bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, bean.getNombre());
            ps.setDouble(2, bean.getCantidad());
            ps.setDouble(3, bean.getProteinas());
            ps.setDouble(4, bean.getLipidos());
            ps.setDouble(5, bean.getCarbohidratos());
            ps.setInt(6, bean.getEstado());
            ps.setInt(7, bean.getCategoria());
            ps.setInt(8, bean.getIdalimento());
            ps.setString(9, bean.getUnidadDeMedida());
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
    public void delete(AlimentoKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getIdalimento());
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
    protected List<Alimento> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Alimento>();
        while (rs.next()) {
            Alimento bean = new Alimento();
            bean.setIdalimento(rs.getInt("idAlimento"));
            bean.setNombre(rs.getString("Nombre"));
            bean.setCantidad(rs.getDouble("Cantidad"));
            bean.setProteinas(rs.getDouble("Proteinas"));
            bean.setLipidos(rs.getDouble("Lipidos"));
            bean.setCarbohidratos(rs.getDouble("Carbohidratos"));
            bean.setEstado(rs.getInt("Estado"));
            bean.setCategoria(rs.getInt("Categoria"));
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