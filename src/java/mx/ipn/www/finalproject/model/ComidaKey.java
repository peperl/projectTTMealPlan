package mx.ipn.www.finalproject.model;

public class ComidaKey implements java.io.Serializable, Cloneable {
    /* idComida */
    protected int idcomida;

    /* idComida */
    public int getIdcomida() {
        return idcomida;
    }

    /* idComida */
    public void setIdcomida(int idcomida) {
        this.idcomida = idcomida;
    }

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        hashCode += new Integer(idcomida).hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof ComidaKey))
            return false;

        ComidaKey key = (ComidaKey) obj;

        if (this.idcomida != key.idcomida)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        ComidaKey key = new ComidaKey();
        key.idcomida = this.idcomida;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idcomida").append(" = ").append(idcomida).append("]");
        return sb.toString();
    }
}