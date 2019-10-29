/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.controller.estimations;

/**
 *
 * @author pepe
 */
public class Estimations {
    public static double getTMR(String sexo, double peso, double estatura, int edad) {
        if (sexo.equals("M")) {
            return (66.473+(13.752*peso)+(5.003*estatura)-(6.755*edad));
        } else {
            return (655.096+(9.563*peso)+(1.85*estatura)-(4.676*edad));
        }
    }
    
    public static double getGastoCalorico(String sexo, double tmr, int actividadFisica) {
        double actFisica = 0;
        if (sexo.equals("M")) {
            switch (actividadFisica) {
                case 0:
                    actFisica = 0;
                    break;
                case 1:
                    actFisica = 1.55;
                    break;
                case 2:
                    actFisica = 1.78;
                    break;
                case 3:
                    actFisica = 2.10;
                    break;
                default:
                    break;
            }
        } else{
            switch (actividadFisica) {
                case 0:
                    actFisica = 0;
                    break;
                case 1:
                    actFisica = 1.56;
                    break;
                case 2:
                    actFisica = 1.64;
                    break;
                case 3:
                    actFisica = 1.82;
                    break;
                default:
                    break;
            }
        }
        
        return tmr * actFisica;
    }
}
