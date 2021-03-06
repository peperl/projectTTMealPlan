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
    private List<List<Integer>> dietQty;
    private ObjectiveCalories objectiveCalories;
    private double protein, lipid, carbos;
    
    public Individual(MealPlanInformation mpi, Map<Integer, List<Alimento>> foodByCategory, ObjectiveCalories objectiveCalories, BinarySelection bs ) {
        this.binarySelection = bs;
        this.mpi = mpi;
        this.foodByCategory = foodByCategory;
        this.objectiveCalories = objectiveCalories;
        Random random = new Random();
        diet = new ArrayList<>();
        dietQty = new ArrayList<>();
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
    
    public Individual(MealPlanInformation mpi, Map<Integer, List<Alimento>> foodByCategory, ObjectiveCalories objectiveCalories, BinarySelection bs, int id) {
        this.binarySelection = bs;
        this.mpi = mpi;
        this.foodByCategory = foodByCategory;
        this.objectiveCalories = objectiveCalories;
        this.id = id;
        diet = new ArrayList<>();
        dietQty = new ArrayList<>();
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
            List<Integer> auxQty = new ArrayList<>();
            int selector = 0;
            for (Integer category : mealDistribution.getCategoria()) {
                int food = binarySelection.getAlimento(id, selector);
                int qty = binarySelection.getCantidad(id, selector++);
                List<Alimento> alimentos = foodByCategory.get(category);
                Alimento alimento = alimentos.get(food % alimentos.size());
                prot+= alimento.getProteinas() * qty;
                lip += alimento.getLipidos() * qty;
                carb += alimento.getCarbohidratos() * qty;
                auxQty.add(qty);
                aux.add(alimento);
            }
            dietQty.add(auxQty);
            diet.add(aux);
        }
        result = ((prot + lip + carb) - objective) / objective;
        this.protein = prot;
        this.lipid = lip;
        this.carbos = carb;
        if (result < 0) {
            result *= -1;
        }
        this.aptitud = result; 
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

    public List<List<Integer>> getDietQty() {
        return dietQty;
    }

    public void setDietQty(List<List<Integer>> dietQty) {
        this.dietQty = dietQty;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getLipid() {
        return lipid;
    }

    public void setLipid(double lipid) {
        this.lipid = lipid;
    }

    public double getCarbos() {
        return carbos;
    }

    public void setCarbos(double carbos) {
        this.carbos = carbos;
    }
    
    @Override
    public String toString() {
        return "Individual{" + "id=" + id + ", aptitud=" + aptitud + ", mpi=" + mpi + ", binarySelection=" + binarySelection + ", foodByCategory=" + foodByCategory + ", diet=" + diet + ", objectiveCalories=" + objectiveCalories + '}';
    }
    
    
}

