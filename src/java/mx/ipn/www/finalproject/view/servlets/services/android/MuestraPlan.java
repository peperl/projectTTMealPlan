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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.ipn.www.finalproject.model.Alimento;
import mx.ipn.www.finalproject.model.AlimentoKey;
import mx.ipn.www.finalproject.model.Comida;
import mx.ipn.www.finalproject.model.PacienteKey;
import mx.ipn.www.finalproject.model.Planalimenticio;
import mx.ipn.www.finalproject.model.RelComida;
import mx.ipn.www.finalproject.model.dao.AlimentoDAO;
import mx.ipn.www.finalproject.model.dao.ComidaDAO;
import mx.ipn.www.finalproject.model.dao.PlanalimenticioDAO;
import mx.ipn.www.finalproject.model.dao.RelComidaDAO;
import mx.ipn.www.finalproject.model.orm.AlimentoDAOImpl;
import mx.ipn.www.finalproject.model.orm.ComidaDAOImpl;
import mx.ipn.www.finalproject.model.orm.PlanalimenticioDAOImpl;
import mx.ipn.www.finalproject.model.orm.RelComidaDAOImpl;
import mx.ipn.www.finalproject.utils.ConnectionByPayaraSource;
import mx.ipn.www.finalproject.view.servlets.services.getAllFood;

/**
 *
 * @author Jose
 */
public class MuestraPlan extends HttpServlet {

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

            RelComidaDAO relComidaDAO = new RelComidaDAOImpl();
            List<List<List<RelComida>>> relComidasByPlanes = new ArrayList<>();

            AlimentoDAO alimentoDAO = new AlimentoDAOImpl();
            List<List<List<Alimento>>> alimentos = new ArrayList<>();
            
            planes = planDAO.loadByPaciente(new PacienteKey(Integer.parseInt(idPaciente)), conn);
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
            
            String json = new Gson().toJson(alimentos);
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
