/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.controller.geneticAlgorithm.beans;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import mx.ipn.www.finalproject.controller.geneticAlgorithm.planDistribution.ConstantMealDistribution;
import mx.ipn.www.finalproject.model.Alimento;
import mx.ipn.www.finalproject.model.CategoriaalimentoKey;
import mx.ipn.www.finalproject.model.Planalimenticio;
import mx.ipn.www.finalproject.model.dao.AlimentoDAO;
import mx.ipn.www.finalproject.model.orm.AlimentoDAOImpl;
import mx.ipn.www.finalproject.utils.ConnectionByPayaraSource;
//import mx.ipn.www.finalproject.utils.ConnectionByJDBC;

/**
 *
 * @author pepe
 */
public class GeneticAlgorithm {
    
    ConstantMealDistribution cmd;
    Meal [] shellMeal;
    HashMap<Integer, List<Alimento>> foodByCategory = new HashMap<Integer, List<Alimento>>();
    
    public GeneticAlgorithm() throws ServletException, SQLException {

        ConnectionByPayaraSource connectionClass = new ConnectionByPayaraSource();

        this.cmd = new ConstantMealDistribution(3);
        this.shellMeal = cmd.getTiempos();
        Connection conn = connectionClass.initConnection();
        AlimentoDAO alimentoDAO = new AlimentoDAOImpl();
        
        for (Meal meal : this.shellMeal) {
            for (Integer idCategoria : meal.getCategoria()) {
                if (!foodByCategory.containsKey(idCategoria)) {
                    List<Alimento> a = alimentoDAO.loadByCategory(new CategoriaalimentoKey(idCategoria), conn);
                    foodByCategory.put(idCategoria, a);
                }
            }
        }
        connectionClass.destroy();
        
        for (List<Alimento> value : foodByCategory.values()) {
            System.out.println(value);
            System.out.println();
        }
    }
    
    public Planalimenticio runAlgorithm() {
        
        return null;
    }
    
    private Individual mutation(Individual old, int foodNumber) {
        return null;

    }
    
    private Individual crossing(Individual a, Individual b) {
        return null;
    }
    
}
