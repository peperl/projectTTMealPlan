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
import mx.ipn.www.finalproject.model.dao.HistorialantropometricoDAO;

/**
 * This class provides methods to populate DB Table of historialantropometrico
 */
public class HistorialantropometricoDAOImpl implements HistorialantropometricoDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO historialantropometrico ("
        + "idRegistro, Paciente_idPaciente, Fecha, Peso, IMC, Grasa"
        + ") VALUES (?, ?, ?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idRegistro, Paciente_idPaciente, Fecha, Peso, IMC, Grasa "
        + "FROM historialantropometrico WHERE "
        + "idRegistro = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE historialantropometrico SET "
        + "Paciente_idPaciente = ?, Fecha = ?, Peso = ?, IMC = ?, Grasa = ? "
        + "WHERE "
        + "idRegistro = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM historialantropometrico WHERE "
        + "idRegistro = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Historialantropometrico bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getIdregistro());
            ps.setInt(2, bean.getPacienteIdpaciente());
            if (bean.getFecha() != null)
                ps.setDate(3, new java.sql.Date(bean.getFecha().getTime()));
            else
                ps.setNull(3, Types.DATE);
            ps.setDouble(4, bean.getPeso());
            ps.setDouble(5, bean.getImc());
            ps.setDouble(6, bean.getGrasa());
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
    public Historialantropometrico load(HistorialantropometricoKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getIdregistro());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Historialantropometrico) results.get(0);
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
    public void update(Historialantropometrico bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, bean.getPacienteIdpaciente());
            if (bean.getFecha() != null)
                ps.setDate(2, new java.sql.Date(bean.getFecha().getTime()));
            else
                ps.setNull(2, Types.DATE);
            ps.setDouble(3, bean.getPeso());
            ps.setDouble(4, bean.getImc());
            ps.setDouble(5, bean.getGrasa());
            ps.setInt(6, bean.getIdregistro());
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
    public void delete(HistorialantropometricoKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getIdregistro());
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
    protected List<Historialantropometrico> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Historialantropometrico>();
        while (rs.next()) {
            Historialantropometrico bean = new Historialantropometrico();
            bean.setIdregistro(rs.getInt("idRegistro"));
            bean.setPacienteIdpaciente(rs.getInt("Paciente_idPaciente"));
            bean.setFecha(rs.getDate("Fecha"));
            bean.setPeso(rs.getDouble("Peso"));
            bean.setImc(rs.getDouble("IMC"));
            bean.setGrasa(rs.getDouble("Grasa"));
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