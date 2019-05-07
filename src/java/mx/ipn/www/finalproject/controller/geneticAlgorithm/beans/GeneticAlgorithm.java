/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.controller.geneticAlgorithm.beans;

import com.sun.javafx.geom.Crossings;
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
import mx.ipn.www.finalproject.controller.geneticAlgorithm.constants.ConstantMealDistribution;
import mx.ipn.www.finalproject.controller.geneticAlgorithm.constants.ConstantSpeedLoseWeight;
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
    private PopulationGenerator pGenerator;
    private ObjectiveCalories objectiveCalories;
    
    public GeneticAlgorithm(int populationSize, double kilocal, short speed) throws ServletException, NamingException, SQLException {
        
        foodByCategory = new HashMap<>();
        objectiveCalories = new ObjectiveCalories(kilocal, speed);
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
        this.pGenerator = new PopulationGenerator(populationSize, mpi, foodByCategory, objectiveCalories);
        
    }
    
    public Individual runAlgorithm() {
        List<Individual> population = this.pGenerator.generatePopulation();
        
        for (int i = 0; i < 100; i++) {
            Map<Double,Individual> population2 = this.pGenerator.Crossing(population);
            population2 = this.pGenerator.Mutation(population2);
            population = new ArrayList<>(population2.values());
            Individual a = this.pGenerator.reachGoal(population);
            if (a != null) {
                return a;
            }
        }
        return null;
    }
}
