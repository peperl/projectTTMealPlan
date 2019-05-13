/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.controller.geneticAlgorithm.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mx.ipn.www.finalproject.controller.geneticAlgorithm.constants.ConstantMealDistribution;
import mx.ipn.www.finalproject.model.Alimento;

/**
 *
 * @author pepe
 */
public class GeneticAlgorithm {
    
    private Map<Integer, List<Alimento>> foodByCategory;
    private PopulationGenerator pGenerator;
    private ObjectiveCalories objectiveCalories;
    private int iterations;
    
    public GeneticAlgorithm(int populationSize, double kilocal, short speed, int iterations, Map<Integer, List<Alimento>> foodByCategory, int mealsQty) {
        
        this.iterations = iterations;
        this.foodByCategory = foodByCategory;
        objectiveCalories = new ObjectiveCalories(kilocal, speed);
        ConstantMealDistribution cmd = new ConstantMealDistribution(mealsQty);
        Meal [] shellMeal = cmd.getTiempos();
        MealPlanInformation mpi = new MealPlanInformation(shellMeal);
        this.pGenerator = new PopulationGenerator(populationSize, mpi, foodByCategory, objectiveCalories);
    }
    
    public Individual runAlgorithm() {
        List<Individual> population = this.pGenerator.generatePopulation();
        Individual a = null;
        
        for (int i = 0; i < iterations; i++) {
            Map<Double,Individual> population2 = this.pGenerator.Crossing(population);
            population2 = this.pGenerator.Mutation(population2);
            population = new ArrayList<>(population2.values());
            a = this.pGenerator.reachGoal(population);
            if (a != null) {
                System.out.println("meta lograda");
                break;
            }
        }
        
        return a;
    }
}
