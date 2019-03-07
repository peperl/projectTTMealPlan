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
import mx.ipn.www.finalproject.model.dao.UsuarioDAO;

/**
 * This class provides methods to populate DB Table of usuario
 */
public class UsuarioDAOImpl implements UsuarioDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO usuario ("
        + "idUsuario, Correo, Pass"
        + ") VALUES (?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idUsuario, Correo, Pass "
        + "FROM usuario WHERE "
        + "idUsuario = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE usuario SET "
        + "Correo = ?, Pass = ? "
        + "WHERE "
        + "idUsuario = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM usuario WHERE "
        + "idUsuario = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Usuario bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getIdusuario());
            ps.setString(2, bean.getCorreo());
            ps.setString(3, bean.getPass());
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
    public Usuario load(UsuarioKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getIdusuario());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Usuario) results.get(0);
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
    public void update(Usuario bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, bean.getCorreo());
            ps.setString(2, bean.getPass());
            ps.setInt(3, bean.getIdusuario());
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
    public void delete(UsuarioKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getIdusuario());
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
    protected List<Usuario> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Usuario>();
        while (rs.next()) {
            Usuario bean = new Usuario();
            bean.setIdusuario(rs.getInt("idUsuario"));
            bean.setCorreo(rs.getString("Correo"));
            bean.setPass(rs.getString("Pass"));
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