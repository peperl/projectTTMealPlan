package mx.ipn.www.finalproject.controller.geneticAlgorithm.beans;

import java.util.ArrayList;
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
    private List<List<Alimento>> diet;
    private ObjectiveCalories objectiveCalories;
    
    Individual(MealPlanInformation mpi, Map<Integer, List<Alimento>> foodByCategory, ObjectiveCalories objectiveCalories) {
        this.binarySelection = new BinarySelection();
        this.mpi = mpi;
        this.foodByCategory = foodByCategory;
        this.objectiveCalories = objectiveCalories;
        Random random = new Random();
        diet = new ArrayList<>();
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
        double prot = 0,lip = 0,carb = 0;
        double objective = objectiveCalories.getCarb()+objectiveCalories.getLip() + objectiveCalories.getProt();
        double result;
        for (Meal mealDistribution : mpi.getMealDistribution()) {
            List<Alimento> aux = new ArrayList<>();
            for (Integer category : mealDistribution.getCategoria()) {
                int food = binarySelection.getAlimento(id, 0);
                int qty = binarySelection.getCantidad(id, 0);
                List<Alimento> alimentos = foodByCategory.get(category);
                Alimento alimento = alimentos.get(food % alimentos.size());
                prot+= alimento.getProteinas() * qty;
                lip += alimento.getLipidos() * qty;
                carb += alimento.getCarbohidratos() * qty;
                aux.add(alimento);
            }
            diet.add(aux);
        }
        result = ((prot + lip + carb) - objective) / objective;
        if (result < 0) {
            result *= -1;
        }
        this.aptitud = result;
        if (aptitud < 0.30) {
            System.out.println("aptitud " + aptitud);
            System.out.println(prot + " " + lip + " " + carb );
            System.out.print(objectiveCalories.getProt() +" ");
            System.out.print(objectiveCalories.getLip() + " ");
            System.out.println(objectiveCalories.getCarb());
        }
        
    }
    
    public double getAptitud() {
        return aptitud;
    }

    public void setAptitud(float aptitud) {
        this.aptitud = aptitud;
    }
}

