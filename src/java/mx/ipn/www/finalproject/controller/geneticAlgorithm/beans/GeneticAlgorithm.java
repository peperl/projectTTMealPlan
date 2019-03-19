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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import mx.ipn.www.finalproject.controller.geneticAlgorithm.constants.ConstantMealDistribution;
import mx.ipn.www.finalproject.model.Alimento;
import mx.ipn.www.finalproject.model.CategoriaalimentoKey;
import mx.ipn.www.finalproject.model.Planalimenticio;
import mx.ipn.www.finalproject.model.dao.AlimentoDAO;
import mx.ipn.www.finalproject.model.orm.AlimentoDAOImpl;
import mx.ipn.www.finalproject.utils.ConnectionByPayaraSource;

/**
 *
 * @author pepe
 */
public class GeneticAlgorithm {
    
    private Map<Integer, List<Alimento>> foodByCategory;
    private Population population;
    
    public GeneticAlgorithm(int populationSize) throws ServletException {
        foodByCategory = new HashMap<>();
        ConnectionByPayaraSource connector = new ConnectionByPayaraSource();
        ConstantMealDistribution cmd = new ConstantMealDistribution(3);
        Meal [] shellMeal = cmd.getTiempos();
        Connection conn = connector.initConnection();
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
        connector.destroy();
        
        MealPlanInformation mpi = new MealPlanInformation(shellMeal);
        this.population = new Population(populationSize, mpi, foodByCategory);
        
    }
    
    public Planalimenticio runAlgorithm() {
        this.population.generatePopulation();
        return null;
    }
    
    public static void main(String[] args) {
        try {
            GeneticAlgorithm ga = new GeneticAlgorithm(10000000);
            ga.runAlgorithm();
        } catch (ServletException ex) {
            Logger.getLogger(GeneticAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
