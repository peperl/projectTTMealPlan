package mx.ipn.www.finalproject.view.servlets.services;

import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.www.finalproject.controller.geneticAlgorithm.beans.GeneticAlgorithm;
import mx.ipn.www.finalproject.controller.geneticAlgorithm.beans.Individual;
import mx.ipn.www.finalproject.controller.geneticAlgorithm.beans.Meal;
import mx.ipn.www.finalproject.controller.geneticAlgorithm.constants.ConstantMealDistribution;
import mx.ipn.www.finalproject.controller.geneticAlgorithm.constants.ConstantSpeedLoseWeight;
import mx.ipn.www.finalproject.model.Alimento;
import mx.ipn.www.finalproject.model.CategoriaalimentoKey;
import mx.ipn.www.finalproject.model.Planalimenticio;
import mx.ipn.www.finalproject.model.dao.AlimentoDAO;
import mx.ipn.www.finalproject.model.orm.AlimentoDAOImpl;
import mx.ipn.www.finalproject.utils.ConnectionByPayaraSource;
import mx.ipn.www.finalproject.view.servlets.services.response.ResponseProposePlan;

/**
 *
 * @author pepe
 */
public class getProposePlan extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        //Planalimenticio planalimenticio = (Planalimenticio) session.getAttribute("idPlanAlimenticio");
        Planalimenticio planalimenticio = new Planalimenticio(); 
        planalimenticio.setNocomidas(3);
        planalimenticio.setGastocalorico(0);
        planalimenticio.setTmr(1000);
        
        
        GeneticAlgorithm ga;
            
        Map <Integer, List<Alimento>> foodByCategory = new HashMap<>();
        ConstantMealDistribution cmd = new ConstantMealDistribution(planalimenticio.getNocomidas());
        ConnectionByPayaraSource connectionByPayaraSource = new ConnectionByPayaraSource();
        Connection conn = null;
        try {
            conn = connectionByPayaraSource.initConnection();
        } catch (NamingException ex) {
            Logger.getLogger(getProposePlan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(getProposePlan.class.getName()).log(Level.SEVERE, null, ex);
        }
        Meal [] shellMeal = cmd.getTiempos();
        AlimentoDAO alimentoDAO = new AlimentoDAOImpl();
        for (Meal meal : shellMeal) {
            for (Integer idCategoria : meal.getCategoria()) {
                try {
                    if (!foodByCategory.containsKey(idCategoria)) {
                        List<Alimento> a = alimentoDAO.loadByCategory(new CategoriaalimentoKey(idCategoria), conn);
                        foodByCategory.put(idCategoria, a);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(GeneticAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }            
            
        double a = planalimenticio.getGastocalorico() + planalimenticio.getTmr();
        Logger.getGlobal().info("calorias: " + a);
        ga = new GeneticAlgorithm(1000, planalimenticio.getGastocalorico() + planalimenticio.getTmr(), ConstantSpeedLoseWeight.SLOW_SPEED, 1000, foodByCategory, planalimenticio.getNocomidas());
        
        List<List<List<Alimento>>> result = new ArrayList<>();
        List<List<List<Integer>>> resultQty = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Individual individual = ga.runAlgorithm();
            if (individual == null) {
                Logger.getGlobal().info("Individuo Nulo");
            } else {
                Logger.getGlobal().info("Individuo con error " + individual.getAptitud());
                Logger.getGlobal().info("Proteinas lipidos Carbos objetivo");
                Logger.getGlobal().info(
                        individual.getObjectiveCalories().getProt() + " "
                    +   individual.getObjectiveCalories().getLip() + " "
                    +   individual.getObjectiveCalories().getCarb());
                Logger.getGlobal().info("Proteinas lipidos Carbos del plan");
                Logger.getGlobal().info(
                        individual.getProtein() + " "
                    +   individual.getLipid() + " "
                    +   individual.getCarbos());


                result.add(individual.getDiet());
                resultQty.add(individual.getDietQty());
            }
        }
        List<List<List<ResponseProposePlan>>> list = new ArrayList();
        for (int i = 0; i < result.size(); i++) {
            List<List<ResponseProposePlan>> b = new ArrayList();
            for (int j = 0; j < result.get(i).size(); j++) {
                List<ResponseProposePlan> c = new ArrayList();
                for (int k = 0; k < result.get(i).get(j).size(); k++) {
                    ResponseProposePlan d = new ResponseProposePlan(result.get(i).get(j).get(k), resultQty.get(i).get(j).get(k));
                    c.add(d);
                }
                b.add(c);
            }
            list.add(b);
        }
        
        
        String json = new Gson().toJson(list);
        response.getWriter().write(json);
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