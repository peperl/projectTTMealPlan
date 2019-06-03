/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.view.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.www.finalproject.model.Planalimenticio;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import mx.ipn.www.finalproject.controller.geneticAlgorithm.beans.GeneticAlgorithm;
import mx.ipn.www.finalproject.controller.geneticAlgorithm.beans.Meal;
import mx.ipn.www.finalproject.controller.geneticAlgorithm.constants.ConstantMealDistribution;
import mx.ipn.www.finalproject.model.Alimento;
import mx.ipn.www.finalproject.model.CategoriaalimentoKey;
import mx.ipn.www.finalproject.model.Comida;
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
import mx.ipn.www.finalproject.view.servlets.services.getProposePlan;

/**
 *
 * @author pepe
 */
public class SaveMealPlan extends HttpServlet {

    Map <Integer, Alimento> food = new HashMap<>();
    String[] dias = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
    
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
        HttpSession session = request.getSession(false);
        
        PlanalimenticioDAO planalimenticio = new PlanalimenticioDAOImpl();
        ComidaDAO comidaDAO = new ComidaDAOImpl();
        RelComidaDAO relComidaDAO = new RelComidaDAOImpl();
        
        ConnectionByPayaraSource con = new ConnectionByPayaraSource();
        Connection conn = null;
        Planalimenticio base = (Planalimenticio) session.getAttribute("idPlanAlimenticio");

        
        List<Planalimenticio> planes = new ArrayList<>();
        planes.add(base);
        
        List<List<Comida>> comidas = new ArrayList<>();

        Planalimenticio auxPlan = null;
        for (int i = 0; i < 6; i++) {
            try {
                conn = con.initConnection();
                planalimenticio.create(base, conn);
                if (i==0) {
                    auxPlan = planalimenticio.loadLastPlan(base, conn);
                    planes.add(auxPlan.clone());
                } else {
                    auxPlan.setIdplanalimenticio(auxPlan.getIdplanalimenticio()+ 1);
                    planes.add(auxPlan.clone());
                }
            } catch (NamingException ex) {
                Logger.getLogger(SaveMealPlan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(SaveMealPlan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

       String jsonArray = request.getParameter("infoPlan");
        Gson gson = new Gson();
        JsonArray mealPlanArray = gson.fromJson(jsonArray, JsonArray.class);
        
        

        try {
        AlimentoDAO alimentoDAO = new AlimentoDAOImpl();
        List<Alimento> a =alimentoDAO.loadAllActive(conn);
            for (Alimento alimento : a) {
                food.put(alimento.getIdalimento(), alimento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaveMealPlan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<List<String>> horasList = new ArrayList<>();
        List<List<LocalTime>> horaComidaList =new ArrayList<>();
        List<List<List<String>>> alimentosListList = new ArrayList<>();
        for (JsonElement jsonElement : mealPlanArray) {
            //Aqui es un plan completo
            List<String> horas = new ArrayList<>();
            List<List<String>> alimentosList = new ArrayList<>();
            for (JsonElement jsonElement1 : (JsonArray) jsonElement) {
                //Aqui es un plan por día
                List<String> alimentos = new ArrayList<>();
                int aux=0;
                for (JsonElement jsonElement2 : (JsonArray) jsonElement1) {
                    //Aqui es un alimento y la hora
                    String[] infoCompleta = jsonElement2.toString().split("\\*");
                    alimentos.add(infoCompleta[0]);
                    if (aux++==0) {
                        horas.add(infoCompleta[1].substring(0, infoCompleta[1].length()-1));
                    }
                }
                alimentosList.add(alimentos);
            }
            alimentosListList.add(alimentosList);
            horasList.add(horas);
        }
        for (List<String> horal : horasList) {
            List<LocalTime> horaComida =new ArrayList<>();
            for (String hora : horal) {
                String[] horaSeparada = hora.split(":");
                horaComida.add(LocalTime.of(Integer.parseInt(horaSeparada[0]), Integer.parseInt(horaSeparada[1])));
            }
            horaComidaList.add(horaComida);
        }
        
        







        //horaComidaList
        //planes

        int auxplan = 0;
        int finalIdComida = 0;
        for (Planalimenticio plan : planes) {
            ConstantMealDistribution cmd = new ConstantMealDistribution(plan.getNocomidas());

            int auxComida=0;
            
            List<Comida> comidaAux = new ArrayList<>();
            try {
                for (String nameTiempo : cmd.getNameTiempos()) {
                    Comida comida = new Comida();
                    comida.setNombre(nameTiempo);
                    comida.setDia(dias[auxplan]);
                    comida.setNumero(auxComida + 1);
                    comida.setHora(horaComidaList.get(auxplan).get(auxComida));
                    comida.setPlanalimenticioIdplanalimenticio(plan.getIdplanalimenticio());
                    comidaDAO.create(comida, conn);
                    comidaAux.add(comida);
                    auxComida++;
                }
                if (auxplan == 0) {
                    comidas.add(comidaDAO.loadByPlanAlimenticio(plan.getKeyObject(), conn));
                    List<Comida> a =  comidas.get(0);
                    finalIdComida = a.get(a.size()-1).getIdcomida();
                } else {
                    for (Comida comida : comidaAux) {
                        finalIdComida++;
                        comida.setIdcomida(finalIdComida);
                    }

                    comidas.add(comidaAux);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(SaveMealPlan.class.getName()).log(Level.SEVERE, null, ex);
            }
            auxplan++;
        }
        
        
        Logger.getGlobal().info(comidas.toString());        
        //alimentosListList aqui están todos los alimentos
        //comidas están todas las comidas
        
        
        for (int i = 0; i < alimentosListList.size(); i++) {
            for (int j = 0; j < alimentosListList.get(i).size(); j++) {
                for (int k = 0; k < alimentosListList.get(i).get(j).size(); k++) {
                    
                    
                    RelComida relcomida = new RelComida();
                    Alimento a = getAlimento(alimentosListList.get(i).get(j).get(k));
                    int qty = getQuantity(alimentosListList.get(i).get(j).get(k), a);
                    relcomida.setAlimentoIdalimento(a.getIdalimento());
                    relcomida.setCantidad(qty);
                    relcomida.setComidaIdcomida(comidas.get(i).get(j).getIdcomida());
                    try {
                        relComidaDAO.create(relcomida, conn);
                    } catch (SQLException ex) {
                        Logger.getLogger(SaveMealPlan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        ServletContext sc = request.getServletContext();
        String path = sc.getContextPath();
        response.sendRedirect( path + "/pages/Nutricionista/BlankN.jsp");
        
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
    private int getQuantity(String line, Alimento alimento) {
        Logger.getGlobal().info("getQtyLine: " + line);
        
        String finalInt = "";
        for (int i = 1; i < line.length(); i++) {
            if ( Character.isDigit(line.charAt(i))) {
                finalInt+=line.charAt(i);
            } else {
                break;
            }
        }
        double parcialResult = Double.parseDouble(finalInt);
        Double result = (parcialResult/alimento.getCantidad());
        return result.intValue();
    }
    
    private Alimento getAlimento (String line) {
        String finalInt = "";
        for (int i = line.length()-2; i >= 0; i--) {
            if ( Character.isDigit(line.charAt(i))) {
                finalInt = line.charAt(i) + finalInt;
            } else {
                break;
            }
        }
        return food.get(Integer.parseInt(finalInt));
    }
}
