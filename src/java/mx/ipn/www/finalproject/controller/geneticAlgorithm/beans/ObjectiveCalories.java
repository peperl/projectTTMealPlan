/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.controller.geneticAlgorithm.beans;

import mx.ipn.www.finalproject.controller.geneticAlgorithm.constants.ConstantSpeedLoseWeight;

/**
 *
 * @author pepe
 */
public final class ObjectiveCalories {
    
    private double carb, prot, lip;
    
    
    public ObjectiveCalories(double kilocalories, short speed) {
        double kilocal = kilocalories;
        
        if (speed == ConstantSpeedLoseWeight.SLOW_SPEED) {
            carb = kilocal * ConstantSpeedLoseWeight.slowSpeed[0];
            prot = kilocal * ConstantSpeedLoseWeight.slowSpeed[1];
            lip = kilocal * ConstantSpeedLoseWeight.slowSpeed[2];
        } else if (speed == ConstantSpeedLoseWeight.NORMAL_SPEED) {
            carb = kilocal * ConstantSpeedLoseWeight.normalSpeed[0];
            prot = kilocal * ConstantSpeedLoseWeight.normalSpeed[1];
            lip = kilocal * ConstantSpeedLoseWeight.normalSpeed[2];
        } else if (speed == ConstantSpeedLoseWeight.FAST_SPEED) {
            carb = kilocal * ConstantSpeedLoseWeight.fastSpeed[0];
            prot = kilocal * ConstantSpeedLoseWeight.fastSpeed[1];
            lip = kilocal * ConstantSpeedLoseWeight.fastSpeed[2];
        }
        
    }

    public double getCarb() {
        return carb;
    }

    public void setCarb(double carb) {
        this.carb = carb;
    }

    public double getProt() {
        return prot;
    }

    public void setProt(double prot) {
        this.prot = prot;
    }

    public double getLip() {
        return lip;
    }

    public void setLip(double lip) {
        this.lip = lip;
    }

    @Override
    public String toString() {
        return "ObjectiveCalories{" + "carb=" + carb + ", prot=" + prot + ", lip=" + lip + '}';
    }
    
    
}
