package mx.ipn.www.finalproject.utils;

public class BinarySelection {
    
    
    native int getAlimento(int mealId, int foodLocation);
    native int getCantidad(int mealId, int foodLocation);

     static {
         System.loadLibrary("BinarySelection");
     }
}
