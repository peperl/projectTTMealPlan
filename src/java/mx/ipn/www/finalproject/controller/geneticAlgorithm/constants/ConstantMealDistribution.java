package mx.ipn.www.finalproject.controller.geneticAlgorithm.constants;

import mx.ipn.www.finalproject.controller.geneticAlgorithm.beans.Meal;

/**
 *
 * @author pepe
 * Class dedicated to know the categories of each meal according
 * with the quantity of the meals.
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
    private String[] nameTiempos;
    
    public ConstantMealDistribution(int tiempos) {
        
        if (tiempos == 3) {
            Integer[] desayunoCategorias = {1,2,4,3,5};
            Meal desayuno = new Meal(desayunoCategorias );

            Integer[] comidaCategorias = {2,4,6,5,3};
            Meal comida = new Meal(comidaCategorias );

            Integer[] cenaCategorias = {1,2,4,3,5};
            Meal cena = new Meal(cenaCategorias );

            this.tiempos = new Meal[tiempos];
            this.nameTiempos = new String[tiempos];
            this.tiempos[0] = desayuno;
            this.tiempos[1] = comida;
            this.tiempos[2] = cena;
             
            this.nameTiempos[0] = "Desayuno";
            this.nameTiempos[1] = "Comida";
            this.nameTiempos[2] = "Cena";
        } else if (tiempos == 4) {
            
            this.nameTiempos = new String[tiempos];
            this.nameTiempos[0] = "Desayuno";
            this.nameTiempos[1] = "Comida";
            this.nameTiempos[2] = "Colación";
            this.nameTiempos[3] = "Cena";
            
            
        } else  if (tiempos == 5) {
            this.nameTiempos = new String[tiempos];
            this.nameTiempos[0] = "Desayuno";
            this.nameTiempos[1] = "Colación";
            this.nameTiempos[2] = "Comida";
            this.nameTiempos[3] = "Colación";
            this.nameTiempos[4] = "Cena";
            
            
            
        }
        
        
        
        
    }

    public Meal[] getTiempos() {
        return tiempos;
    }

    public String[] getNameTiempos() {
        return nameTiempos;
    }

    public void setNameTiempos(String[] nameTiempos) {
        this.nameTiempos = nameTiempos;
    }
    
}