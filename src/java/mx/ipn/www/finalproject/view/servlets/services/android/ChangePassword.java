/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.view.servlets.services.android;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.ipn.www.finalproject.model.Paciente;
import mx.ipn.www.finalproject.model.PacienteKey;
import mx.ipn.www.finalproject.model.Usuario;
import mx.ipn.www.finalproject.model.UsuarioKey;
import mx.ipn.www.finalproject.model.dao.PacienteDAO;
import mx.ipn.www.finalproject.model.dao.UsuarioDAO;
import mx.ipn.www.finalproject.model.orm.PacienteDAOImpl;
import mx.ipn.www.finalproject.model.orm.UsuarioDAOImpl;
import mx.ipn.www.finalproject.utils.ConnectionByPayaraSource;
import mx.ipn.www.finalproject.utils.QRgenerator;
import mx.ipn.www.finalproject.view.servlets.services.getAllFood;

/**
 *
 * @author Jose
 */
public class ChangePassword extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String idPaciente = request.getParameter("idPaciente");
        String password = request.getParameter("newPassword");
        
        try {
            ConnectionByPayaraSource connector = new ConnectionByPayaraSource();
            Connection conn = connector.initConnection();
            PacienteDAO dao = new PacienteDAOImpl();
            UsuarioDAO userDAO = new UsuarioDAOImpl();
            Paciente paciente = dao.load(new PacienteKey(Integer.parseInt(idPaciente)), conn);
            Usuario usuario = userDAO.load(new UsuarioKey(paciente.getUsuarioIdusuario()), conn);
            usuario.setPass(password);
            userDAO.update(usuario, conn);
            Boolean successful = true;
            String json = new Gson().toJson(successful);
            response.getWriter().write(json);
            connector.destroy();
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(getAllFood.class.getName()).log(Level.SEVERE, null, ex);
            Boolean successful = false;
            String json = new Gson().toJson(successful);
            response.getWriter().write(json);
        }
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
