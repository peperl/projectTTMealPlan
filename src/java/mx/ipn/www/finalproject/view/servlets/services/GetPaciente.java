/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.view.servlets.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.www.finalproject.model.Comida;
import mx.ipn.www.finalproject.model.Historialantropometrico;
import mx.ipn.www.finalproject.model.Paciente;
import mx.ipn.www.finalproject.model.PacienteKey;
import mx.ipn.www.finalproject.model.Planalimenticio;
import mx.ipn.www.finalproject.model.RelComida;
import mx.ipn.www.finalproject.model.dao.ComidaDAO;
import mx.ipn.www.finalproject.model.dao.HistorialantropometricoDAO;
import mx.ipn.www.finalproject.model.dao.PacienteDAO;
import mx.ipn.www.finalproject.model.dao.PlanalimenticioDAO;
import mx.ipn.www.finalproject.model.dao.RelComidaDAO;
import mx.ipn.www.finalproject.model.orm.ComidaDAOImpl;
import mx.ipn.www.finalproject.model.orm.HistorialantropometricoDAOImpl;
import mx.ipn.www.finalproject.model.orm.PacienteDAOImpl;
import mx.ipn.www.finalproject.model.orm.PlanalimenticioDAOImpl;
import mx.ipn.www.finalproject.model.orm.RelComidaDAOImpl;
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
        HttpSession session = request.getSession(false);
        
        int idPaciente = Integer.parseInt(request.getParameter("id"));
        PacienteDAO pacienteDAO = new PacienteDAOImpl();
        Paciente paciente;
        
        List<Historialantropometrico> historiales;
        HistorialantropometricoDAO haDAO = new HistorialantropometricoDAOImpl();
        
        List<Planalimenticio> planes;
        PlanalimenticioDAO planDAO = new PlanalimenticioDAOImpl();
        
        List<List<Comida>> comidasByPlanes = new ArrayList<>();
        ComidaDAO comidaDAO = new ComidaDAOImpl();
        
        List<List<List<RelComida>>> relComidasByPlanes = new ArrayList<>();
        RelComidaDAO relComidaDAO = new RelComidaDAOImpl();
        
        
        ConnectionByPayaraSource cbps = new ConnectionByPayaraSource();
        
        try {
            Connection conn = cbps.initConnection();
            paciente = pacienteDAO.load(new PacienteKey(idPaciente), conn);
            historiales = haDAO.loadByPaciente(paciente.getKeyObject(), conn);
            planes = planDAO.loadByPaciente(paciente.getKeyObject(), conn);
            for (Planalimenticio plan : planes) {
                List<Comida> aux = comidaDAO.loadByPlanAlimenticio(plan.getKeyObject(),conn);
                comidasByPlanes.add(aux);
            }
            
            for (List<Comida> comidasByPlane : comidasByPlanes) {
                
            }
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
