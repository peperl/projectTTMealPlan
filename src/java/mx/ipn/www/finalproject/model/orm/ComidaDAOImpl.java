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
import mx.ipn.www.finalproject.model.dao.ComidaDAO;

/**
 * This class provides methods to populate DB Table of comida
 */
public class ComidaDAOImpl implements ComidaDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO comida ("
        + "idComida, PlanAlimenticio_idPlanAlimenticio, Nombre, Dia, Numero, Hora"
        + ") VALUES (?, ?, ?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idComida, PlanAlimenticio_idPlanAlimenticio, Nombre, Dia, Numero, Hora "
        + "FROM comida WHERE "
        + "idComida = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE comida SET "
        + "PlanAlimenticio_idPlanAlimenticio = ?, Nombre = ?, Dia = ?, Numero = ?, Hora = ? "
        + "WHERE "
        + "idComida = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM comida WHERE "
        + "idComida = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Comida bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getIdcomida());
            ps.setInt(2, bean.getPlanalimenticioIdplanalimenticio());
            ps.setString(3, bean.getNombre());
            ps.setString(4, bean.getDia());
            ps.setInt(5, bean.getNumero());
            if (bean.getHora() != null)
                ps.setDate(6, new java.sql.Date(bean.getHora().getTime()));
            else
                ps.setNull(6, Types.DATE);
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
    public Comida load(ComidaKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getIdcomida());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Comida) results.get(0);
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
    public void update(Comida bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, bean.getPlanalimenticioIdplanalimenticio());
            ps.setString(2, bean.getNombre());
            ps.setString(3, bean.getDia());
            ps.setInt(4, bean.getNumero());
            if (bean.getHora() != null)
                ps.setDate(5, new java.sql.Date(bean.getHora().getTime()));
            else
                ps.setNull(5, Types.DATE);
            ps.setInt(6, bean.getIdcomida());
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
    public void delete(ComidaKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getIdcomida());
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
    protected List<Comida> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Comida>();
        while (rs.next()) {
            Comida bean = new Comida();
            bean.setIdcomida(rs.getInt("idComida"));
            bean.setPlanalimenticioIdplanalimenticio(rs.getInt("PlanAlimenticio_idPlanAlimenticio"));
            bean.setNombre(rs.getString("Nombre"));
            bean.setDia(rs.getString("Dia"));
            bean.setNumero(rs.getInt("Numero"));
            bean.setHora(rs.getDate("Hora"));
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