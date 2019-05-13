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
    
    public Individual(MealPlanInformation mpi, Map<Integer, List<Alimento>> foodByCategory, ObjectiveCalories objectiveCalories, BinarySelection bs ) {
        this.binarySelection = bs;
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
    
    Individual(MealPlanInformation mpi, Map<Integer, List<Alimento>> foodByCategory, ObjectiveCalories objectiveCalories, BinarySelection bs, int id) {
        this.binarySelection = bs;
        this.mpi = mpi;
        this.foodByCategory = foodByCategory;
        this.objectiveCalories = objectiveCalories;
        this.id = id;
        
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
        diet = new ArrayList<>();
        for (Meal mealDistribution : mpi.getMealDistribution()) {
            List<Alimento> aux = new ArrayList<>();
            int selector = 0;
            for (Integer category : mealDistribution.getCategoria()) {
                int food = binarySelection.getAlimento(id, selector);
                int qty = binarySelection.getCantidad(id, selector++);
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
        if (aptitud < 0.08) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MealPlanInformation getMpi() {
        return mpi;
    }

    public void setMpi(MealPlanInformation mpi) {
        this.mpi = mpi;
    }

    public BinarySelection getBinarySelection() {
        return binarySelection;
    }

    public void setBinarySelection(BinarySelection binarySelection) {
        this.binarySelection = binarySelection;
    }

    public Map<Integer, List<Alimento>> getFoodByCategory() {
        return foodByCategory;
    }

    public void setFoodByCategory(Map<Integer, List<Alimento>> foodByCategory) {
        this.foodByCategory = foodByCategory;
    }

    public List<List<Alimento>> getDiet() {
        return diet;
    }

    public void setDiet(List<List<Alimento>> diet) {
        this.diet = diet;
    }

    public ObjectiveCalories getObjectiveCalories() {
        return objectiveCalories;
    }

    public void setObjectiveCalories(ObjectiveCalories objectiveCalories) {
        this.objectiveCalories = objectiveCalories;
    }
    
    @Override
    public String toString() {
        return "Individual{" + "id=" + id + ", aptitud=" + aptitud + ", mpi=" + mpi + ", binarySelection=" + binarySelection + ", foodByCategory=" + foodByCategory + ", diet=" + diet + ", objectiveCalories=" + objectiveCalories + '}';
    }
    
    
}

