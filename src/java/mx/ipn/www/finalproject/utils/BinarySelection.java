package mx.ipn.www.finalproject.utils;

public class BinarySelection {
    
    // javah -o BinarySelection.h -classpath TTPRoyect/build/classes mx.ipn.www.finalproject.utils.BinarySelection

    native int getAlimento(int mealId, int foodLocation);
    native int getCantidad(int mealId, int foodLocation);
    native int cross(int mealId, int mealId2);
    native int mutation(int mealId, int foodLocation);
    

     static {
         System.loadLibrary("BinarySelection");
     }
}
