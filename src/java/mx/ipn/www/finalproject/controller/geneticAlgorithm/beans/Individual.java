/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.controller.geneticAlgorithm.beans;

import java.util.List;
import java.util.Map;
import java.util.Random;
import mx.ipn.www.finalproject.model.Alimento;
import mx.ipn.www.finalproject.utils.BinarySelection;


/**
 *
 * @author pepe
 */
public class Individual {

    private int id;
    private double aptitud;
    private MealPlanInformation mpi;
    private BinarySelection binarySelection;
    private Map<Integer, List<Alimento>> foodByCategory;
    /**
     *
     * @param mpi
     * @param foodByCategory
     */
    public Individual(MealPlanInformation mpi, Map<Integer, List<Alimento>> foodByCategory) {
        
        this.binarySelection = new BinarySelection();
        this.mpi = mpi;
        this.foodByCategory = foodByCategory;
        Random random = new Random();
        this.id = random.nextInt();
        if (this.id < 0) {
            this.id *= -1;
        }
        //4 bits de alimento
        //2 de cantidad
        
        // generate stream of 5 ints between 1 to 100
        //IntStream ints = random.ints(5, 1, 100);
        //ints.forEach(System.out::println);        
    }
    
    public void calculateHability() {
        float prot = 0,lip = 0,carb = 0;
        
        for (Meal mealDistribution : mpi.getMealDistribution()) {
            
            for (Integer category : mealDistribution.getCategoria()) {
                int food = binarySelection.getAlimento(id, 0);
                int qty = binarySelection.getCantidad(id, 0);
                List<Alimento> alimentos = foodByCategory.get(category);
                Alimento alimento = alimentos.get(food % alimentos.size());
                prot+= alimento.getProteinas() * qty;
                lip += alimento.getLipidos() * qty;
                carb += alimento.getCarbohidratos() * qty;
            }
        }
        this.aptitud = prot + lip + carb;
    }
    
    public double getAptitud() {
        return aptitud;
    }

    public void setAptitud(float aptitud) {
        this.aptitud = aptitud;
    }
}

