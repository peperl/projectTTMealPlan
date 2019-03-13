/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.view.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.ipn.www.finalproject.model.Nutricionista;
import mx.ipn.www.finalproject.model.Usuario;
import mx.ipn.www.finalproject.model.dao.NutricionistaDAO;
import mx.ipn.www.finalproject.model.dao.UsuarioDAO;
import mx.ipn.www.finalproject.model.orm.NutricionistaDAOImpl;
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
        String escuela = request.getParameter("escuela");
        String email = request.getParameter("email");
        String telefono = request.getParameter("idTelefono");
        String direccion = request.getParameter("idDireccion");
        String password = request.getParameter("idPassword");
        String confirmPassword = request.getParameter("idConfirm");
        String termsCheck = request.getParameter("termsCheck");
        
        SimpleDateFormat format = new SimpleDateFormat("d/M/yyyy");
        java.util.Date fechanacimiento = new java.util.Date();
        try {
            fechanacimiento = format.parse(request.getParameter("nacimiento"));
        } catch (ParseException ex) {
            Logger.getLogger(registerNutricionista.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
        java.util.Date fechaRegistro = new java.util.Date();
        
        ConnectionByPayaraSource connectionClass = new ConnectionByPayaraSource();
        Connection con = connectionClass.initConnection();
        Usuario usuario = new Usuario(email, password);
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Nutricionista nutricionista;
        NutricionistaDAO nutricionistaDAO = new NutricionistaDAOImpl();
        
        try {
            usuarioDAO.create(usuario, con);
            usuario = usuarioDAO.loadByData(usuario, con);
            nutricionista =  new Nutricionista(usuario.getIdusuario(), nombre + " " + apellido, cedula, fechanacimiento, escuela, telefono, direccion, 0, fechaRegistro);
            nutricionistaDAO.create(nutricionista, con);
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
