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
import mx.ipn.www.finalproject.model.dao.UserDAO;

/**
 * This class provides methods to populate DB Table of user
 */
public class UserDAOImpl implements UserDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO user ("
        + "username, email, password, create_time"
        + ") VALUES (?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "username, email, password, create_time "
        + "FROM user WHERE "
        + "username = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE user SET "
        + "email = ?, password = ?, create_time = ? "
        + "WHERE "
        + "username = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM user WHERE "
        + "username = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(User bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, bean.getUsername());
            ps.setString(2, bean.getEmail());
            ps.setString(3, bean.getPassword());
            if (bean.getCreateTime() != null)
                ps.setObject(4, bean.getCreateTime());
            else
                ps.setNull(4, Types.TIMESTAMP);
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
    public User load(UserKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setString(1, key.getUsername());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (User) results.get(0);
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
    public void update(User bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, bean.getEmail());
            ps.setString(2, bean.getPassword());
            if (bean.getCreateTime() != null)
                ps.setObject(3, bean.getCreateTime());
            else
                ps.setNull(3, Types.TIMESTAMP);
            ps.setString(4, bean.getUsername());
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
    public void delete(UserKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setString(1, key.getUsername());
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
    protected List<User> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<User>();
        while (rs.next()) {
            User bean = new User();
            bean.setUsername(rs.getString("username"));
            bean.setEmail(rs.getString("email"));
            bean.setPassword(rs.getString("password"));
            bean.setCreateTime(rs.getObject("create_time", java.sql.Timestamp.class));
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