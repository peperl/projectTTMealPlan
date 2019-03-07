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
import mx.ipn.www.finalproject.model.dao.PacienteDAO;

/**
 * This class provides methods to populate DB Table of paciente
 */
public class PacienteDAOImpl implements PacienteDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO paciente ("
        + "idPaciente, Usuario_idUsuario, Nutricionista_idNutricionista, Nombre, Apellidos, FechaNacimiento, Ocupacion, "
        + "Telefono, Direccion, PesoAnterior, Estatura, CirBraquial, CirPantorrilla, DificultadesAliment, "
        + "Enfermedades, Tratamiento, ProteinaAnterior, LipidosAnterior, CarbohidratosAnterior, ComidasAnterior, ActividadFisica, "
        + "FechaRegistro, Estado"
        + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idPaciente, Usuario_idUsuario, Nutricionista_idNutricionista, Nombre, Apellidos, FechaNacimiento, Ocupacion, "
        + "Telefono, Direccion, PesoAnterior, Estatura, CirBraquial, CirPantorrilla, DificultadesAliment, "
        + "Enfermedades, Tratamiento, ProteinaAnterior, LipidosAnterior, CarbohidratosAnterior, ComidasAnterior, ActividadFisica, "
        + "FechaRegistro, Estado "
        + "FROM paciente WHERE "
        + "idPaciente = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE paciente SET "
        + "Usuario_idUsuario = ?, Nutricionista_idNutricionista = ?, Nombre = ?, Apellidos = ?, FechaNacimiento = ?, Ocupacion = ?, Telefono = ?,  "
        + "Direccion = ?, PesoAnterior = ?, Estatura = ?, CirBraquial = ?, CirPantorrilla = ?, DificultadesAliment = ?, Enfermedades = ?,  "
        + "Tratamiento = ?, ProteinaAnterior = ?, LipidosAnterior = ?, CarbohidratosAnterior = ?, ComidasAnterior = ?, ActividadFisica = ?, FechaRegistro = ?,  "
        + "Estado = ? "
        + "WHERE "
        + "idPaciente = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM paciente WHERE "
        + "idPaciente = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Paciente bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getIdpaciente());
            ps.setInt(2, bean.getUsuarioIdusuario());
            ps.setInt(3, bean.getNutricionistaIdnutricionista());
            ps.setString(4, bean.getNombre());
            ps.setString(5, bean.getApellidos());
            if (bean.getFechanacimiento() != null)
                ps.setDate(6, new java.sql.Date(bean.getFechanacimiento().getTime()));
            else
                ps.setNull(6, Types.DATE);
            ps.setString(7, bean.getOcupacion());
            ps.setString(8, bean.getTelefono());
            ps.setString(9, bean.getDireccion());
            ps.setDouble(10, bean.getPesoanterior());
            ps.setDouble(11, bean.getEstatura());
            ps.setDouble(12, bean.getCirbraquial());
            ps.setString(13, bean.getCirpantorrilla());
            ps.setString(14, bean.getDificultadesaliment());
            ps.setString(15, bean.getEnfermedades());
            ps.setString(16, bean.getTratamiento());
            ps.setDouble(17, bean.getProteinaanterior());
            ps.setDouble(18, bean.getLipidosanterior());
            ps.setDouble(19, bean.getCarbohidratosanterior());
            ps.setDouble(20, bean.getComidasanterior());
            ps.setDouble(21, bean.getActividadfisica());
            ps.setString(22, bean.getFecharegistro());
            ps.setInt(23, bean.getEstado());
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
    public Paciente load(PacienteKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getIdpaciente());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Paciente) results.get(0);
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
    public void update(Paciente bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, bean.getUsuarioIdusuario());
            ps.setInt(2, bean.getNutricionistaIdnutricionista());
            ps.setString(3, bean.getNombre());
            ps.setString(4, bean.getApellidos());
            if (bean.getFechanacimiento() != null)
                ps.setDate(5, new java.sql.Date(bean.getFechanacimiento().getTime()));
            else
                ps.setNull(5, Types.DATE);
            ps.setString(6, bean.getOcupacion());
            ps.setString(7, bean.getTelefono());
            ps.setString(8, bean.getDireccion());
            ps.setDouble(9, bean.getPesoanterior());
            ps.setDouble(10, bean.getEstatura());
            ps.setDouble(11, bean.getCirbraquial());
            ps.setString(12, bean.getCirpantorrilla());
            ps.setString(13, bean.getDificultadesaliment());
            ps.setString(14, bean.getEnfermedades());
            ps.setString(15, bean.getTratamiento());
            ps.setDouble(16, bean.getProteinaanterior());
            ps.setDouble(17, bean.getLipidosanterior());
            ps.setDouble(18, bean.getCarbohidratosanterior());
            ps.setDouble(19, bean.getComidasanterior());
            ps.setDouble(20, bean.getActividadfisica());
            ps.setString(21, bean.getFecharegistro());
            ps.setInt(22, bean.getEstado());
            ps.setInt(23, bean.getIdpaciente());
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
    public void delete(PacienteKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getIdpaciente());
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
    protected List<Paciente> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Paciente>();
        while (rs.next()) {
            Paciente bean = new Paciente();
            bean.setIdpaciente(rs.getInt("idPaciente"));
            bean.setUsuarioIdusuario(rs.getInt("Usuario_idUsuario"));
            bean.setNutricionistaIdnutricionista(rs.getInt("Nutricionista_idNutricionista"));
            bean.setNombre(rs.getString("Nombre"));
            bean.setApellidos(rs.getString("Apellidos"));
            bean.setFechanacimiento(rs.getDate("FechaNacimiento"));
            bean.setOcupacion(rs.getString("Ocupacion"));
            bean.setTelefono(rs.getString("Telefono"));
            bean.setDireccion(rs.getString("Direccion"));
            bean.setPesoanterior(rs.getDouble("PesoAnterior"));
            bean.setEstatura(rs.getDouble("Estatura"));
            bean.setCirbraquial(rs.getDouble("CirBraquial"));
            bean.setCirpantorrilla(rs.getString("CirPantorrilla"));
            bean.setDificultadesaliment(rs.getString("DificultadesAliment"));
            bean.setEnfermedades(rs.getString("Enfermedades"));
            bean.setTratamiento(rs.getString("Tratamiento"));
            bean.setProteinaanterior(rs.getDouble("ProteinaAnterior"));
            bean.setLipidosanterior(rs.getDouble("LipidosAnterior"));
            bean.setCarbohidratosanterior(rs.getDouble("CarbohidratosAnterior"));
            bean.setComidasanterior(rs.getDouble("ComidasAnterior"));
            bean.setActividadfisica(rs.getDouble("ActividadFisica"));
            bean.setFecharegistro(rs.getString("FechaRegistro"));
            bean.setEstado(rs.getInt("Estado"));
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