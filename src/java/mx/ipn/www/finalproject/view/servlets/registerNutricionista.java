/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.view.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.*;
import javax.naming.*;
import mx.ipn.www.finalproject.model.Usuario;
import mx.ipn.www.finalproject.model.dao.UsuarioDAO;
import mx.ipn.www.finalproject.model.orm.UsuarioDAOImpl;
import mx.ipn.www.finalproject.utils.ConnectionByPayaraSource;

/**
 *
 * @author pepe
 */
public class registerNutricionista extends HttpServlet {

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
        
        response.setContentType("text/html;charset=UTF-8");
        String nombre = request.getParameter("nomD");
        String apellido = request.getParameter("apeD");
        String cedula = request.getParameter("cedula");
        String email = request.getParameter("email");
        String telefono = request.getParameter("idTelefono");
        String direccion = request.getParameter("idDireccion");
        String password = request.getParameter("idPassword");
        String confirmPassword = request.getParameter("idConfirm");
        String termsCheck = request.getParameter("termsCheck");
        
        ConnectionByPayaraSource connectionClass = new ConnectionByPayaraSource();
        Connection con = connectionClass.initConnection();
        Usuario usuario = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        try {
            usuarioDAO.create(usuario, con);
        } catch (SQLException ex) {
            Logger.getLogger(registerNutricionista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        connectionClass.destroy();
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
