/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Wed Mar 13 01:44:24 CST 2019
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package mx.ipn.www.finalproject.model.orm;

import mx.ipn.www.finalproject.model.Usuario;
import mx.ipn.www.finalproject.model.UsuarioKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;
import mx.ipn.www.finalproject.model.dao.UsuarioDAO;

/**
 * This class provides methods to populate DB Table of usuario
 */
public class UsuarioDAOImpl implements UsuarioDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO Usuario ("
        + "Correo, Pass"
        + ") VALUES (?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idUsuario, Correo, Pass "
        + "FROM Usuario WHERE "
        + "idUsuario = ?";

    /* SQL to select data without id*/
    private static final String SQL_SELECT_BY_DATA =
        "SELECT "
        + "idUsuario, Correo, Pass "
        + "FROM Usuario WHERE "
        + "Correo = ? AND Pass = ?";
    
    private static final String SQL_SELECT_BY_EMAIL =
        "SELECT "
        + "idUsuario, Correo, Pass "
        + "FROM Usuario WHERE "
        + "Correo = ?";

    /* SQL to select data without id*/
    private static final String SQL_SELECT_FOR_LOGIN_NUTRICIONISTA =
        "SELECT "
        + "Usuario.idUsuario, Usuario.Correo, Usuario.Pass FROM Usuario INNER JOIN Nutricionista " +
        "ON Usuario.idUsuario = Nutricionista.Usuario_idUsuario WHERE "
        + "Usuario.Correo = ? AND Usuario.Pass = ?";

    private static final String SQL_SELECT_FOR_LOGIN_PACIENTE =
        "SELECT "
        + "Usuario.idUsuario, Usuario.Correo, Usuario.Pass FROM Usuario INNER JOIN Paciente " +
        "ON Usuario.idUsuario = Paciente.Usuario_idUsuario WHERE "
        + "Usuario.Correo = ? AND Usuario.Pass = ?";
    
    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE Usuario SET "
        + "Correo = ?, Pass = ? "
        + "WHERE "
        + "idUsuario = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM Usuario WHERE "
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
            //ps.setInt(1, bean.getIdusuario());
            ps.setString(1, bean.getCorreo());
            ps.setString(2, bean.getPass());
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
     * Retrive a record from Database.
     * @param beanKey   The PK Object to be retrived.
     * @param conn      JDBC Connection.
     * @exception       SQLException if something is wrong.
     */
    public Usuario loadByData(Usuario usuario, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT_BY_DATA);
            ps.setString(1, usuario.getCorreo());
            ps.setString(2, usuario.getPass());
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
    
    @Override
    public Usuario loadByEmail(Usuario usuario, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT_BY_EMAIL);
            ps.setString(1, usuario.getCorreo());
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
     * Retrive a record from Database.
     * @param beanKey   The PK Object to be retrived.
     * @param conn      JDBC Connection.
     * @exception       SQLException if something is wrong.
     */
    public Usuario loadForLoginNuricionista(Usuario usuario, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT_FOR_LOGIN_NUTRICIONISTA);
            ps.setString(1, usuario.getCorreo());
            ps.setString(2, usuario.getPass());
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

    @Override
    public Usuario loadForLoginPaciente(Usuario usuario, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT_FOR_LOGIN_PACIENTE);
            ps.setString(1, usuario.getCorreo());
            ps.setString(2, usuario.getPass());
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
            String auxPass = rs.getString("Pass");
            if (auxPass != null) {
                bean.setPass(rs.getString("Pass"));
            }
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