/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.view.servlets.services.android;

import mx.ipn.www.finalproject.view.servlets.services.android.response.GenericResponse;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.ipn.www.finalproject.model.Historialantropometrico;
import mx.ipn.www.finalproject.model.dao.HistorialantropometricoDAO;
import mx.ipn.www.finalproject.model.orm.HistorialantropometricoDAOImpl;
import mx.ipn.www.finalproject.utils.ConnectionByPayaraSource;
import mx.ipn.www.finalproject.view.servlets.services.getAllFood;

/**
 *
 * @author Jose
 */
public class registraPeso extends HttpServlet {

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
        String peso = request.getParameter("peso");
        String grasa = request.getParameter("grasa");
        String imc = request.getParameter("imc");

        if (idPaciente==null||peso==null) {
            GenericResponse genericResponse = new GenericResponse(Boolean.FALSE);
            String json = new Gson().toJson(genericResponse);
            response.getWriter().write(json);
        }
        
        try {
            grasa = request.getParameter("grasa");
        } catch (Exception e) {
            grasa = "0";
        }
        try {
            imc = request.getParameter("imc");
        } catch (Exception e) {
            imc = "0";
        }
        
        try {
            ConnectionByPayaraSource connector = new ConnectionByPayaraSource();
            Connection conn = connector.initConnection();
            HistorialantropometricoDAO dao = new HistorialantropometricoDAOImpl();
            Historialantropometrico historialantropometrico = new Historialantropometrico();
            historialantropometrico.setPacienteIdpaciente(Integer.parseInt(idPaciente));
            historialantropometrico.setFecha(new Date());
            historialantropometrico.setGrasa(Double.parseDouble(grasa));
            historialantropometrico.setImc(Double.parseDouble(imc));
            dao.create(historialantropometrico, conn);            
            GenericResponse genericResponse = new GenericResponse(Boolean.TRUE);
            String json = new Gson().toJson(genericResponse);
            response.getWriter().write(json);
            connector.destroy();
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(getAllFood.class.getName()).log(Level.SEVERE, null, ex);
            GenericResponse genericResponse = new GenericResponse(Boolean.FALSE);
            String json = new Gson().toJson(genericResponse);
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
