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
import mx.ipn.www.finalproject.model.dao.AlimentosexcluidosDAO;

/**
 * This class provides methods to populate DB Table of alimentosexcluidos
 */
public class AlimentosexcluidosDAOImpl implements AlimentosexcluidosDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO alimentosexcluidos ("
        + "Paciente_idPaciente, Alimento_idAlimento"
        + ") VALUES (?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "Paciente_idPaciente, Alimento_idAlimento "
        + "FROM alimentosexcluidos WHERE "
        + "Paciente_idPaciente = ? AND Alimento_idAlimento = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE alimentosexcluidos SET "
        + "WHERE "
        + "Paciente_idPaciente = ? AND Alimento_idAlimento = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM alimentosexcluidos WHERE "
        + "Paciente_idPaciente = ? AND Alimento_idAlimento = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Alimentosexcluidos bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getPacienteIdpaciente());
            ps.setInt(2, bean.getAlimentoIdalimento());
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
    public Alimentosexcluidos load(AlimentosexcluidosKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getPacienteIdpaciente());
            ps.setInt(2, key.getAlimentoIdalimento());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Alimentosexcluidos) results.get(0);
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
    public void update(Alimentosexcluidos bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, bean.getPacienteIdpaciente());
            ps.setInt(2, bean.getAlimentoIdalimento());
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
    public void delete(AlimentosexcluidosKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getPacienteIdpaciente());
            ps.setInt(2, key.getAlimentoIdalimento());
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
    protected List<Alimentosexcluidos> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Alimentosexcluidos>();
        while (rs.next()) {
            Alimentosexcluidos bean = new Alimentosexcluidos();
            bean.setPacienteIdpaciente(rs.getInt("Paciente_idPaciente"));
            bean.setAlimentoIdalimento(rs.getInt("Alimento_idAlimento"));
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