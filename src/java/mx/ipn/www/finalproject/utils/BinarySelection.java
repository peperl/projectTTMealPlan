package mx.ipn.www.finalproject.utils;

public class BinarySelection {
    
    // javah -o BinarySelection.h -classpath TTPRoyect/build/classes mx.ipn.www.finalproject.utils.BinarySelection

    public native int getAlimento(int mealId, int foodLocation);
    public native int getCantidad(int mealId, int foodLocation);
    public native int cross(int mealId, int mealId2);
    public native int mutation(int mealId, int foodLocation);
    

    static {
         LoadLibrary.loadNativeLibrary();
     }
}
