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
import mx.ipn.www.finalproject.model.dao.PlanalimenticioDAO;

/**
 * This class provides methods to populate DB Table of planalimenticio
 */
public class PlanalimenticioDAOImpl implements PlanalimenticioDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO planalimenticio ("
        + "idPlanAlimenticio, Paciente_idPaciente, FechaCreacion, Duracion, GastoCalorico, Proteinas, Lipidos, "
        + "Carbohidratos, NoComidas, Estado, TMR"
        + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idPlanAlimenticio, Paciente_idPaciente, FechaCreacion, Duracion, GastoCalorico, Proteinas, Lipidos, "
        + "Carbohidratos, NoComidas, Estado, TMR "
        + "FROM planalimenticio WHERE "
        + "idPlanAlimenticio = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE planalimenticio SET "
        + "Paciente_idPaciente = ?, FechaCreacion = ?, Duracion = ?, GastoCalorico = ?, Proteinas = ?, Lipidos = ?, Carbohidratos = ?,  "
        + "NoComidas = ?, Estado = ?, TMR = ? "
        + "WHERE "
        + "idPlanAlimenticio = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM planalimenticio WHERE "
        + "idPlanAlimenticio = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Planalimenticio bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getIdplanalimenticio());
            ps.setInt(2, bean.getPacienteIdpaciente());
            if (bean.getFechacreacion() != null)
                ps.setDate(3, new java.sql.Date(bean.getFechacreacion().getTime()));
            else
                ps.setNull(3, Types.DATE);
            ps.setInt(4, bean.getDuracion());
            ps.setDouble(5, bean.getGastocalorico());
            ps.setDouble(6, bean.getProteinas());
            ps.setDouble(7, bean.getLipidos());
            ps.setDouble(8, bean.getCarbohidratos());
            ps.setInt(9, bean.getNocomidas());
            ps.setInt(10, bean.getEstado());
            ps.setDouble(11, bean.getTmr());
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
    public Planalimenticio load(PlanalimenticioKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getIdplanalimenticio());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Planalimenticio) results.get(0);
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
    public void update(Planalimenticio bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, bean.getPacienteIdpaciente());
            if (bean.getFechacreacion() != null)
                ps.setDate(2, new java.sql.Date(bean.getFechacreacion().getTime()));
            else
                ps.setNull(2, Types.DATE);
            ps.setInt(3, bean.getDuracion());
            ps.setDouble(4, bean.getGastocalorico());
            ps.setDouble(5, bean.getProteinas());
            ps.setDouble(6, bean.getLipidos());
            ps.setDouble(7, bean.getCarbohidratos());
            ps.setInt(8, bean.getNocomidas());
            ps.setInt(9, bean.getEstado());
            ps.setDouble(10, bean.getTmr());
            ps.setInt(11, bean.getIdplanalimenticio());
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
    public void delete(PlanalimenticioKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getIdplanalimenticio());
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
    protected List<Planalimenticio> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Planalimenticio>();
        while (rs.next()) {
            Planalimenticio bean = new Planalimenticio();
            bean.setIdplanalimenticio(rs.getInt("idPlanAlimenticio"));
            bean.setPacienteIdpaciente(rs.getInt("Paciente_idPaciente"));
            bean.setFechacreacion(rs.getDate("FechaCreacion"));
            bean.setDuracion(rs.getInt("Duracion"));
            bean.setGastocalorico(rs.getDouble("GastoCalorico"));
            bean.setProteinas(rs.getDouble("Proteinas"));
            bean.setLipidos(rs.getDouble("Lipidos"));
            bean.setCarbohidratos(rs.getDouble("Carbohidratos"));
            bean.setNocomidas(rs.getInt("NoComidas"));
            bean.setEstado(rs.getInt("Estado"));
            bean.setTmr(rs.getDouble("TMR"));
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