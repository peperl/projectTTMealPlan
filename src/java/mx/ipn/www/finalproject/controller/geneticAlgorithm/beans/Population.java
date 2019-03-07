/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.controller.geneticAlgorithm.beans;

import mx.ipn.www.finalproject.controller.geneticAlgorithm.planDistribution.ConstantMealDistribution;

/**
 *
 * @author pepe
 */
public class Population {
    
    protected int size;
    protected MealPlanInformation mpi;
        

    public Population (int size, MealPlanInformation mpi) {
        this.size = size;
        this.mpi = mpi;
    }
    
    public void generatePopulation() {
        
    }
    
    public static void main(String[] args) {
        ConstantMealDistribution cmd = new ConstantMealDistribution(3);
        MealPlanInformation mpi = new MealPlanInformation(0, cmd.getTiempos());
        Population population = new Population(1000, mpi);
        population.generatePopulation();
    }
}
