/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.view.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.ipn.www.finalproject.model.Alimento;
import mx.ipn.www.finalproject.model.dao.AlimentoDAO;
import mx.ipn.www.finalproject.model.orm.AlimentoDAOImpl;
import mx.ipn.www.finalproject.utils.ConnectionByPayaraSource;

/**
 *
 * @author pepe
 */
public class AgregarAlimento extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Alimento alimento = new Alimento();
        AlimentoDAO dao = new AlimentoDAOImpl();
        alimento.setNombre(request.getParameter("nombre"));
        alimento.setCategoria(Integer.parseInt(request.getParameter("categoria")));
        alimento.setEstado(0);
        alimento.setUnidad(request.getParameter("unidad"));
        alimento.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        alimento.setCarbohidratos(Double.parseDouble(request.getParameter("carbohidratos")));
        alimento.setProteinas(Double.parseDouble(request.getParameter("proteinas")));
        alimento.setLipidos(Double.parseDouble(request.getParameter("lipidos")));

        ConnectionByPayaraSource connectionClass = new ConnectionByPayaraSource();
        ServletContext sc = request.getServletContext();
        String path = sc.getContextPath();

        try {
            Connection con = connectionClass.initConnection();
            dao.create(alimento, con);
            connectionClass.destroy();
            response.sendRedirect( path + "/pages/Nutricionista/agregarAlimento.jsp?success=yes");
            
        } catch (NamingException ex) {
            Logger.getLogger(AgregarAlimento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AgregarAlimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectionClass.destroy();
        response.sendRedirect( path + "/pages/Nutricionista/agregarAlimento.jsp?success=no");
        
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
