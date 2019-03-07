package mx.ipn.www.finalproject.model;

public class HistorialantropometricoKey implements java.io.Serializable, Cloneable {
    /* idRegistro */
    protected int idregistro;

    /* idRegistro */
    public int getIdregistro() {
        return idregistro;
    }

    /* idRegistro */
    public void setIdregistro(int idregistro) {
        this.idregistro = idregistro;
    }

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        hashCode += new Integer(idregistro).hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof HistorialantropometricoKey))
            return false;

        HistorialantropometricoKey key = (HistorialantropometricoKey) obj;

        if (this.idregistro != key.idregistro)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        HistorialantropometricoKey key = new HistorialantropometricoKey();
        key.idregistro = this.idregistro;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idregistro").append(" = ").append(idregistro).append("]");
        return sb.toString();
    }
}