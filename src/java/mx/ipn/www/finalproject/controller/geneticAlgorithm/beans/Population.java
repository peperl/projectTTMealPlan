/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.controller.geneticAlgorithm.beans;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import mx.ipn.www.finalproject.model.Alimento;

/**
 *
 * @author pepe
 */
public class Population {
    
    protected int populationSize;
    protected MealPlanInformation mpi;
    Map<Integer, List<Alimento>> foodByCategory;
    
    
    Population(int populationSize, MealPlanInformation mpi, Map<Integer, List<Alimento>> foodByCategory) {
        this.populationSize = populationSize;
        this.mpi = mpi;
        this.foodByCategory = foodByCategory;
    }
    
    public void generatePopulation() {
        Map<Double, Individual> initialPopulation = new TreeMap<>();
        for (int i = 0; i < this.populationSize; i++) {
            Individual x = new Individual(mpi,foodByCategory);
            x.calculateHability();
            initialPopulation.put(x.getAptitud(), x);
        }
    }
}
