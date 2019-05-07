/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.controller.geneticAlgorithm.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import mx.ipn.www.finalproject.controller.geneticAlgorithm.constants.ConstantMinimAbility;
import mx.ipn.www.finalproject.model.Alimento;
import mx.ipn.www.finalproject.utils.BinarySelection;

/**
 *
 * @author pepe
 */
public class PopulationGenerator {
    
    private int populationSize;
    private MealPlanInformation mpi;
    private Map<Integer, List<Alimento>> foodByCategory;
    private ObjectiveCalories objectiveCalories;
    
    public PopulationGenerator(int populationSize, MealPlanInformation mpi, Map<Integer, List<Alimento>> foodByCategory, ObjectiveCalories objectiveCalories) {
        this.populationSize = populationSize;
        this.mpi = mpi;
        this.foodByCategory = foodByCategory;
        this.objectiveCalories = objectiveCalories;
    }
    
    public List<Individual> generatePopulation() {
        List<Individual> initialPopulation = new ArrayList<>();
        for (int i = 0; i < this.populationSize; i++) {
            Individual x = new Individual(mpi,foodByCategory, objectiveCalories);
            x.calculateHability();
            initialPopulation.add(x);
        }
        return initialPopulation;
    }

    Map<Double, Individual> Crossing(List<Individual> population) {
        population = binaryTournment(population);
        BinarySelection bs = new BinarySelection();
        Map<Double,Individual> result = new HashMap<>();
        Random random = new Random();
        
        int limit = population.size();
        Individual a, b;
        for (int i = 0; i < limit/2; i++) {
            a = population.remove(random.nextInt(limit) % limit);
            limit--;
            b = population.remove(random.nextInt(limit) % limit);
            limit--;
            Individual c = new Individual(mpi, foodByCategory, objectiveCalories,bs.cross(a.getId(), b.getId()));
            Individual d = new Individual(mpi, foodByCategory, objectiveCalories,bs.cross(b.getId(), a.getId()));
            c.calculateHability();
            d.calculateHability();
            result.put(a.getAptitud(), a);
            result.put(b.getAptitud(), b);
            result.put(c.getAptitud(), c);
            result.put(d.getAptitud(), d);
        }
        return result;
    }
    
    private List<Individual> binaryTournment(List<Individual> population) {
        List<Individual> result = new ArrayList<>();
        Random random = new Random();
        
        int limit = population.size();
        int limitForUse = limit;
        Individual a, b;
        for (int i = 0; i < limit/2; i++) {
            a = population.remove(random.nextInt(limitForUse)%limitForUse);
            limitForUse--;
            b = population.remove(random.nextInt(limitForUse)%limitForUse);
            limitForUse--;
            if (a.getAptitud() > b.getAptitud()) {
                result.add(a);
            } else if (a.getAptitud() < b.getAptitud()) {
                result.add(b);
            } else {
                result.add(a);
            }
            
        }
        return result;
    }

    public Map<Double, Individual> Mutation(Map<Double, Individual> population2) {
        Map<Double, Individual> result = new HashMap<>();
        
        for (Map.Entry<Double, Individual> entry : population2.entrySet()) {
            Random random = new Random();
            for (Meal mealDistribution : mpi.getMealDistribution()) {
                BinarySelection bs = new BinarySelection();
                int foodsqty = mealDistribution.getCategoria().length;
                int newid = bs.mutation(entry.getValue().getId(), random.nextInt(foodsqty)%foodsqty);
                Individual newIndividual = new Individual(mpi, foodByCategory, objectiveCalories, newid);
                newIndividual.calculateHability();
                if (entry.getKey() > newIndividual.getAptitud()) {
                    result.put(entry.getKey(), entry.getValue());
                } else {
                    result.put(newIndividual.getAptitud(), newIndividual);
                }
            }
        }
        return result;
    }

    public Individual reachGoal(List<Individual> population) {
        Individual special = null;
        for (Individual individual : population) {
            if (individual.getAptitud() < ConstantMinimAbility.minumAbility) {
                if (special != null) {
                    if (individual.getAptitud() > special.getAptitud()) {
                        special = individual;
                    }
                } else {
                    special = individual;
                }
            }
        }
        return special;
    }
}

