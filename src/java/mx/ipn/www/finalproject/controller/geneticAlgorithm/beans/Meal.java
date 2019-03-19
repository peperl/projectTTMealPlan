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
    
    private Integer[] categoria;

    public Meal(Integer[] categoria) {
        this.categoria = categoria;
    }

    public Integer[] getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer[] categoria) {
        this.categoria = categoria;
    }
    
}
