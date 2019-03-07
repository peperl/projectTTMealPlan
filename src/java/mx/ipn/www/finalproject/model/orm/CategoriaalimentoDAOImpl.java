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
import mx.ipn.www.finalproject.model.dao.CategoriaalimentoDAO;

/**
 * This class provides methods to populate DB Table of categoriaalimento
 */
public class CategoriaalimentoDAOImpl implements CategoriaalimentoDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO categoriaalimento ("
        + "category_id, NombreCategoria"
        + ") VALUES (?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "category_id, NombreCategoria "
        + "FROM categoriaalimento WHERE "
        + "category_id = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE categoriaalimento SET "
        + "NombreCategoria = ? "
        + "WHERE "
        + "category_id = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM categoriaalimento WHERE "
        + "category_id = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Categoriaalimento bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getCategoryId());
            ps.setString(2, bean.getNombrecategoria());
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
    public Categoriaalimento load(CategoriaalimentoKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getCategoryId());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Categoriaalimento) results.get(0);
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
    public void update(Categoriaalimento bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, bean.getNombrecategoria());
            ps.setInt(2, bean.getCategoryId());
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
    public void delete(CategoriaalimentoKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getCategoryId());
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
    protected List<Categoriaalimento> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Categoriaalimento>();
        while (rs.next()) {
            Categoriaalimento bean = new Categoriaalimento();
            bean.setCategoryId(rs.getInt("category_id"));
            bean.setNombrecategoria(rs.getString("NombreCategoria"));
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