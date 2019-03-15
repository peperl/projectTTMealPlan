/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.controller.geneticAlgorithm.beans;

import java.util.Random;

/**
 *
 * @author pepe
 */
public class Individual {

    private int id;
    private float aptitud;
    
    public Individual(int maximumValue) {

        Random random = new Random();
        this.id = random.nextInt(maximumValue);
        //4 bits de alimento
        //2 de cantidad
        
        // generate stream of 5 ints between 1 to 100
        //IntStream ints = random.ints(5, 1, 100);
        //ints.forEach(System.out::println);        
    }
    
}
