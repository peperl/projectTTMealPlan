package mx.ipn.www.finalproject.view.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.www.finalproject.model.Alimento;
import mx.ipn.www.finalproject.model.AlimentoKey;
import mx.ipn.www.finalproject.model.Alimentosexcluidos;
import mx.ipn.www.finalproject.model.Comida;
import mx.ipn.www.finalproject.model.Historialantropometrico;
import mx.ipn.www.finalproject.model.Paciente;
import mx.ipn.www.finalproject.model.PacienteKey;
import mx.ipn.www.finalproject.model.Planalimenticio;
import mx.ipn.www.finalproject.model.RelComida;
import mx.ipn.www.finalproject.model.Seguimiento;
import mx.ipn.www.finalproject.model.Usuario;
import mx.ipn.www.finalproject.model.UsuarioKey;
import mx.ipn.www.finalproject.model.dao.AlimentoDAO;
import mx.ipn.www.finalproject.model.dao.AlimentosexcluidosDAO;
import mx.ipn.www.finalproject.model.dao.ComidaDAO;
import mx.ipn.www.finalproject.model.dao.HistorialantropometricoDAO;
import mx.ipn.www.finalproject.model.dao.PacienteDAO;
import mx.ipn.www.finalproject.model.dao.PlanalimenticioDAO;
import mx.ipn.www.finalproject.model.dao.RelComidaDAO;
import mx.ipn.www.finalproject.model.dao.SeguimientoDAO;
import mx.ipn.www.finalproject.model.dao.UsuarioDAO;
import mx.ipn.www.finalproject.model.orm.AlimentoDAOImpl;
import mx.ipn.www.finalproject.model.orm.AlimentosexcluidosDAOImpl;
import mx.ipn.www.finalproject.model.orm.ComidaDAOImpl;
import mx.ipn.www.finalproject.model.orm.HistorialantropometricoDAOImpl;
import mx.ipn.www.finalproject.model.orm.PacienteDAOImpl;
import mx.ipn.www.finalproject.model.orm.PlanalimenticioDAOImpl;
import mx.ipn.www.finalproject.model.orm.RelComidaDAOImpl;
import mx.ipn.www.finalproject.model.orm.SeguimientoDAOImpl;
import mx.ipn.www.finalproject.model.orm.UsuarioDAOImpl;
import mx.ipn.www.finalproject.utils.ConnectionByPayaraSource;

/**
 *
 * @author pepe
 */
public class GetPaciente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * Clase usado de enlace entre listaPacientes y seguimiento paciente
     * para insertar en la sesión todo lo necesario para crear la vista
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        if (request.getParameter("id") == null) {
            return;
        }
        int idPaciente = Integer.parseInt(request.getParameter("id"));

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Usuario usuario;
        
        PacienteDAO pacienteDAO = new PacienteDAOImpl();
        Paciente paciente;
        
        HistorialantropometricoDAO haDAO = new HistorialantropometricoDAOImpl();
        List<Historialantropometrico> historiales;
        
        AlimentosexcluidosDAO aExcluidosDAO = new AlimentosexcluidosDAOImpl();
        List<Alimentosexcluidos> alimentosexcluidos;
        
        PlanalimenticioDAO planDAO = new PlanalimenticioDAOImpl();
        List<Planalimenticio> planes;
        
        ComidaDAO comidaDAO = new ComidaDAOImpl();
        List<List<Comida>> comidasByPlanes = new ArrayList<>();
        
        RelComidaDAO relComidaDAO = new RelComidaDAOImpl();
        List<List<List<RelComida>>> relComidasByPlanes = new ArrayList<>();
        
        AlimentoDAO alimentoDAO = new AlimentoDAOImpl();
        List<List<List<Alimento>>> alimentos = new ArrayList<>();

        SeguimientoDAO seguimientoDAO = new SeguimientoDAOImpl();
        List<List<Seguimiento>> seguimientos = new ArrayList<>();
        
        
        
        ConnectionByPayaraSource cbps = new ConnectionByPayaraSource();
        
        try {
            Connection conn = cbps.initConnection();
            
            paciente = pacienteDAO.load(new PacienteKey(idPaciente), conn);
            usuario = usuarioDAO.load(new UsuarioKey(paciente.getUsuarioIdusuario()), conn);
            historiales = haDAO.loadByPaciente(paciente.getKeyObject(), conn);
            alimentosexcluidos = aExcluidosDAO.loadByPaciente(paciente.getKeyObject(), conn);
            planes = planDAO.loadByPaciente(paciente.getKeyObject(), conn);
            for (Planalimenticio plan : planes) {
                List<Comida> aux = comidaDAO.loadByPlanAlimenticio(plan.getKeyObject(),conn);
                if(aux != null && aux.size()>0) {
                    comidasByPlanes.add(aux);
                }
            }
            
            //Error en las siguientes lineas por encontrar un plan sin alimentos asociados
            for (List<Comida> comidasByPlan : comidasByPlanes) {
                List<List<RelComida>> aux2 = new ArrayList<>();
                if (comidasByPlan!=null & comidasByPlan.size()>0) {
                    for (Comida comida : comidasByPlan) {
                        List<RelComida> aux = relComidaDAO.loadByComida(comida.getKeyObject(), conn);
                        aux2.add(aux);
                    }
                    relComidasByPlanes.add(aux2);
                }
            }
            
            for (List<List<RelComida>> relComidasByPlane : relComidasByPlanes) {
                List<List<Alimento>> aux3 = new ArrayList<>();
                for (List<RelComida> list : relComidasByPlane) {
                    List<Alimento> aux2 = new ArrayList();
                    for (RelComida relComida : list) {
                        Alimento aux = alimentoDAO.load(new AlimentoKey(relComida.getAlimentoIdalimento()), conn);
                        aux2.add(aux);
                    }
                    aux3.add(aux2);
                }
                alimentos.add(aux3);
            }
            List<Alimento> alimentosEvitados = new ArrayList<>();
            if(alimentosexcluidos != null && alimentosexcluidos.size()>0) {
                for (Alimentosexcluidos alimentosexcluido : alimentosexcluidos) {
                    alimentosEvitados.add(alimentoDAO.load(new AlimentoKey(alimentosexcluido.getAlimentoIdalimento()), conn));
                }
            }
            
            session.setAttribute("pacienteGeneralInformation", paciente);
            session.setAttribute("pacienteGIUsuario", usuario);
            session.setAttribute("pacienteGIAlimentosEvitados", alimentosEvitados);
            session.setAttribute("pacienteGIHistorial", historiales);
            session.setAttribute("pacienteGIPlanes", planes);
            
            ServletContext sc = request.getServletContext();
            String path = sc.getContextPath();
            response.sendRedirect( path + "/pages/Nutricionista/seguimientoPaciente.jsp");
            
        } catch (NamingException ex) {
            Logger.getLogger(GetPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GetPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        cbps.destroy();
            //session.setAttribute("qrid", usuarioIdusuario);
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
