/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.view.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.www.finalproject.controller.estimations.Estimations;
import mx.ipn.www.finalproject.model.Historialantropometrico;
import mx.ipn.www.finalproject.model.Paciente;
import mx.ipn.www.finalproject.model.Planalimenticio;
import mx.ipn.www.finalproject.model.dao.HistorialantropometricoDAO;
import mx.ipn.www.finalproject.model.dao.PlanalimenticioDAO;
import mx.ipn.www.finalproject.model.orm.HistorialantropometricoDAOImpl;
import mx.ipn.www.finalproject.model.orm.PlanalimenticioDAOImpl;
import mx.ipn.www.finalproject.utils.ConnectionByPayaraSource;

/**
 *
 * @author pepe
 */
public class RegisterAntopometricData extends HttpServlet {

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

            ConnectionByPayaraSource connector = new ConnectionByPayaraSource();
            HistorialantropometricoDAO dao = new HistorialantropometricoDAOImpl();
            Connection conn;
        
            HttpSession session = request.getSession(false);
            Paciente paciente = (Paciente) session.getAttribute("pacienteIdpaciente");
            Planalimenticio planalimenticio = (Planalimenticio) session.getAttribute("idPlanAlimenticio");
            PlanalimenticioDAO planDAO = new PlanalimenticioDAOImpl();
            
            int idUsario = (int) session.getAttribute("qrid");
            double peso = Double.parseDouble(request.getParameter("peso"));
            double imc = Double.parseDouble(request.getParameter("imc"));
            double grasa = Double.parseDouble(request.getParameter("grasa"));
            Historialantropometrico data = new Historialantropometrico();
            data.setFecha(new Date());
            data.setGrasa(grasa);
            data.setPeso(peso);
            data.setPacienteIdpaciente(paciente.getIdpaciente());
            data.setImc(imc);
            
        try {
            conn = connector.initConnection();
            Logger.getGlobal().warning(data.toString());
            dao.create(data, conn);
            Calendar calendar = Calendar.getInstance();
            int anioActual = calendar.get(Calendar.YEAR);
            calendar.setTime(paciente.getFechanacimiento());            
            int anioNacimiento = calendar.get(Calendar.YEAR);
            double tmr = Estimations.getTMR(paciente.getSexo(), peso, paciente.getEstatura()*100, anioActual-anioNacimiento);
            double gastoCalorico = Estimations.getGastoCalorico(tmr, paciente.getActividadfisica());
            planalimenticio.setTmr(tmr);
            planalimenticio.setGastocalorico(gastoCalorico);
            planDAO.update(planalimenticio, conn);
            session.setAttribute("idPlanAlimenticio",planalimenticio);
            ServletContext sc = request.getServletContext();
            String path = sc.getContextPath();
            response.sendRedirect( path + "/pages/Nutricionista/planAlimenticio.html");

        } catch (NamingException ex) {
            Logger.getLogger(RegisterAntopometricData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterAntopometricData.class.getName()).log(Level.SEVERE, null, ex);
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
