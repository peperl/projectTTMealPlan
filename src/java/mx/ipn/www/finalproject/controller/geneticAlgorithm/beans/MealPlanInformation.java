/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.controller.geneticAlgorithm.beans;

import java.util.List;

/**
 *
 * @author pepe
 */
class MealPlanInformation {
    
    protected int mealsQuanity;
    protected Meal[] mealDistribution;

    public MealPlanInformation(int mealsQuanity, Meal[] mealDistribution) {
        this.mealsQuanity = mealsQuanity;
        this.mealDistribution = mealDistribution;
    }
    
    public Meal[] getMealDistribution() {
        return mealDistribution;
    }

    public void setMealDistribution(Meal[] mealDistribution) {
        this.mealDistribution = mealDistribution;
    }
}
