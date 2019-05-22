/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.view.servlets.services.android;

import com.google.gson.Gson;
import java.io.IOException;
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
import mx.ipn.www.finalproject.model.Comida;
import mx.ipn.www.finalproject.model.PacienteKey;
import mx.ipn.www.finalproject.model.Planalimenticio;
import mx.ipn.www.finalproject.model.Seguimiento;
import mx.ipn.www.finalproject.model.dao.ComidaDAO;
import mx.ipn.www.finalproject.model.dao.PlanalimenticioDAO;
import mx.ipn.www.finalproject.model.dao.SeguimientoDAO;
import mx.ipn.www.finalproject.model.orm.ComidaDAOImpl;
import mx.ipn.www.finalproject.model.orm.PlanalimenticioDAOImpl;
import mx.ipn.www.finalproject.model.orm.SeguimientoDAOImpl;
import mx.ipn.www.finalproject.utils.ConnectionByPayaraSource;
import mx.ipn.www.finalproject.view.servlets.services.getAllFood;

/**
 *
 * @author Jose
 */
public class GetApegoPercent extends HttpServlet {

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
        
        if (idPaciente==null) {
            GenericResponse genericResponse = new GenericResponse(Boolean.FALSE);
            String json = new Gson().toJson(genericResponse);
            response.getWriter().write(json);
            return;
        }
        try {
            ConnectionByPayaraSource connector = new ConnectionByPayaraSource();
            Connection conn = connector.initConnection();
            
            PlanalimenticioDAO planDAO = new PlanalimenticioDAOImpl();
            List<Planalimenticio> planes;

            ComidaDAO comidaDAO = new ComidaDAOImpl();
            List<List<Comida>> comidasByPlanes = new ArrayList<>();
            
            SeguimientoDAO seguimientoDAO = new SeguimientoDAOImpl();
            List<List<List<Seguimiento>>> seguimientos = new ArrayList<>();
            
            List<Integer> resultado = new ArrayList<>();
            
            planes = planDAO.loadByPaciente(new PacienteKey(Integer.parseInt(idPaciente)), conn);
            for (Planalimenticio plan : planes) {
                List<Comida> aux = comidaDAO.loadByPlanAlimenticio(plan.getKeyObject(),conn);
                if(aux != null && aux.size()>0) {
                    comidasByPlanes.add(aux);
                }
            }
            
            for (List<Comida> comidasOfAPlan : comidasByPlanes) {
                List<List<Seguimiento>> aux = new ArrayList<>();
                for (Comida comida : comidasOfAPlan) {
                    aux.add(seguimientoDAO.loadByIdComida(comida.getKeyObject(), conn));
                }
                seguimientos.add(aux);
            }
            
            String json = new Gson().toJson(resultado);
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
