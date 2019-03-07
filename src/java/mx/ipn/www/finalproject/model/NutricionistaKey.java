package mx.ipn.www.finalproject.model;

public class NutricionistaKey implements java.io.Serializable, Cloneable {
    /* idNutricionista */
    protected int idnutricionista;

    /* idNutricionista */
    public int getIdnutricionista() {
        return idnutricionista;
    }

    /* idNutricionista */
    public void setIdnutricionista(int idnutricionista) {
        this.idnutricionista = idnutricionista;
    }

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        hashCode += new Integer(idnutricionista).hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof NutricionistaKey))
            return false;

        NutricionistaKey key = (NutricionistaKey) obj;

        if (this.idnutricionista != key.idnutricionista)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        NutricionistaKey key = new NutricionistaKey();
        key.idnutricionista = this.idnutricionista;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idnutricionista").append(" = ").append(idnutricionista).append("]");
        return sb.toString();
    }
}