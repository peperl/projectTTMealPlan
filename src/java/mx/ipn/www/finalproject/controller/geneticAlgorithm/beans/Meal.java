/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.controller.geneticAlgorithm.beans;

/**
 *
 * @author pepe
 */
public class Meal {
    
    private int quantityOfDishes;
    private Integer[] categoria;

    public Meal(int quantity, Integer[] categoria) {
        this.quantityOfDishes = quantity;
        this.categoria = categoria;
    }

    public int getQuantityOfDishes() {
        return quantityOfDishes;
    }

    public void setQuantityOfDishes(int quantityOfDishes) {
        this.quantityOfDishes = quantityOfDishes;
    }

    public Integer[] getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer[] categoria) {
        this.categoria = categoria;
    }
    
}
