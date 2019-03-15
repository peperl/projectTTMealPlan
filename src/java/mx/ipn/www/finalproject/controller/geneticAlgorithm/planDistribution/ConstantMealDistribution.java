package mx.ipn.www.finalproject.controller.geneticAlgorithm.planDistribution;

import mx.ipn.www.finalproject.controller.geneticAlgorithm.beans.Meal;

/**
 *
 * @author pepe
 */
public class ConstantMealDistribution {

    /*
    Categoria
    Leche 1
    Carne 2
    Cereales 4
    Lípidos 3
    Frutas 5
    Verduras Contenido bajo en potasio 6
    Verduras Contenido medio en potasio 7
     */
    
    private Meal[] tiempos;
    
    public ConstantMealDistribution(int tiempos) {
        if (tiempos == 3) {
            Integer[] desayunoCategorias = {1,2,4,3,5};
            Meal desayuno = new Meal(5 , desayunoCategorias );

            Integer[] comidaCategorias = {2,4,6,5,3};
            Meal comida = new Meal(5 , comidaCategorias );

            Integer[] cenaCategorias = {1,2,4,3,5};
            Meal cena = new Meal(5 , cenaCategorias );

             this.tiempos = new Meal[3];
             this.tiempos[0] = desayuno;
             this.tiempos[1] = comida;
             this.tiempos[2] = cena;
        }
    }

    public Meal[] getTiempos() {
        return tiempos;
    }
}