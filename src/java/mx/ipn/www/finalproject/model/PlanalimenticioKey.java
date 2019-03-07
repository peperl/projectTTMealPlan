package mx.ipn.www.finalproject.model;

public class PlanalimenticioKey implements java.io.Serializable, Cloneable {
    /* idPlanAlimenticio */
    protected int idplanalimenticio;

    /* idPlanAlimenticio */
    public int getIdplanalimenticio() {
        return idplanalimenticio;
    }

    /* idPlanAlimenticio */
    public void setIdplanalimenticio(int idplanalimenticio) {
        this.idplanalimenticio = idplanalimenticio;
    }

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        hashCode += new Integer(idplanalimenticio).hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof PlanalimenticioKey))
            return false;

        PlanalimenticioKey key = (PlanalimenticioKey) obj;

        if (this.idplanalimenticio != key.idplanalimenticio)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        PlanalimenticioKey key = new PlanalimenticioKey();
        key.idplanalimenticio = this.idplanalimenticio;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idplanalimenticio").append(" = ").append(idplanalimenticio).append("]");
        return sb.toString();
    }
}