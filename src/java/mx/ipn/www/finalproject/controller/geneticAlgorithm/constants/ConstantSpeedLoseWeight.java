/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.controller.geneticAlgorithm.constants;

/**
 *
 * @author pepe
 */
public class ConstantSpeedLoseWeight {
    
    /**
     * Los valores de los arreglos representan:
     * 0 Carbohidratos
     * 1 Proteinas
     * 2 Lípidos
     */
    public static double [] slowSpeed = {0.55 , 0.16 , 0.29};
    public static double[] normalSpeed = {0.50 , 0.18 , 0.32};
    public static double[] fastSpeed = {0.45 , 0.20 , 0.35};
    public static short SLOW_SPEED = 1;
    public static short NORMAL_SPEED = 2;
    public static short FAST_SPEED = 3;
    
}

