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
import mx.ipn.www.finalproject.model.dao.NutricionistaDAO;

/**
 * This class provides methods to populate DB Table of nutricionista
 */
public class NutricionistaDAOImpl implements NutricionistaDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO nutricionista ("
        + "idNutricionista, Usuario_idUsuario, Nombre, Cedula, FechaNacimiento, EscuelaProcedencia, Telefono, "
        + "Direccion, Estado, FechaRegistro, FechaAceptado"
        + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idNutricionista, Usuario_idUsuario, Nombre, Cedula, FechaNacimiento, EscuelaProcedencia, Telefono, "
        + "Direccion, Estado, FechaRegistro, FechaAceptado "
        + "FROM nutricionista WHERE "
        + "idNutricionista = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE nutricionista SET "
        + "Usuario_idUsuario = ?, Nombre = ?, Cedula = ?, FechaNacimiento = ?, EscuelaProcedencia = ?, Telefono = ?, Direccion = ?,  "
        + "Estado = ?, FechaRegistro = ?, FechaAceptado = ? "
        + "WHERE "
        + "idNutricionista = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM nutricionista WHERE "
        + "idNutricionista = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Nutricionista bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getIdnutricionista());
            ps.setInt(2, bean.getUsuarioIdusuario());
            ps.setString(3, bean.getNombre());
            ps.setString(4, bean.getCedula());
            if (bean.getFechanacimiento() != null)
                ps.setDate(5, new java.sql.Date(bean.getFechanacimiento().getTime()));
            else
                ps.setNull(5, Types.DATE);
            ps.setString(6, bean.getEscuelaprocedencia());
            ps.setString(7, bean.getTelefono());
            ps.setString(8, bean.getDireccion());
            ps.setInt(9, bean.getEstado());
            if (bean.getFecharegistro() != null)
                ps.setDate(10, new java.sql.Date(bean.getFecharegistro().getTime()));
            else
                ps.setNull(10, Types.DATE);
            if (bean.getFechaaceptado() != null)
                ps.setDate(11, new java.sql.Date(bean.getFechaaceptado().getTime()));
            else
                ps.setNull(11, Types.DATE);
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
    public Nutricionista load(NutricionistaKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getIdnutricionista());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Nutricionista) results.get(0);
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
    public void update(Nutricionista bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, bean.getUsuarioIdusuario());
            ps.setString(2, bean.getNombre());
            ps.setString(3, bean.getCedula());
            if (bean.getFechanacimiento() != null)
                ps.setDate(4, new java.sql.Date(bean.getFechanacimiento().getTime()));
            else
                ps.setNull(4, Types.DATE);
            ps.setString(5, bean.getEscuelaprocedencia());
            ps.setString(6, bean.getTelefono());
            ps.setString(7, bean.getDireccion());
            ps.setInt(8, bean.getEstado());
            if (bean.getFecharegistro() != null)
                ps.setDate(9, new java.sql.Date(bean.getFecharegistro().getTime()));
            else
                ps.setNull(9, Types.DATE);
            if (bean.getFechaaceptado() != null)
                ps.setDate(10, new java.sql.Date(bean.getFechaaceptado().getTime()));
            else
                ps.setNull(10, Types.DATE);
            ps.setInt(11, bean.getIdnutricionista());
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
    public void delete(NutricionistaKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getIdnutricionista());
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
    protected List<Nutricionista> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Nutricionista>();
        while (rs.next()) {
            Nutricionista bean = new Nutricionista();
            bean.setIdnutricionista(rs.getInt("idNutricionista"));
            bean.setUsuarioIdusuario(rs.getInt("Usuario_idUsuario"));
            bean.setNombre(rs.getString("Nombre"));
            bean.setCedula(rs.getString("Cedula"));
            bean.setFechanacimiento(rs.getDate("FechaNacimiento"));
            bean.setEscuelaprocedencia(rs.getString("EscuelaProcedencia"));
            bean.setTelefono(rs.getString("Telefono"));
            bean.setDireccion(rs.getString("Direccion"));
            bean.setEstado(rs.getInt("Estado"));
            bean.setFecharegistro(rs.getDate("FechaRegistro"));
            bean.setFechaaceptado(rs.getDate("FechaAceptado"));
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