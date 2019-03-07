package mx.ipn.www.finalproject.model;

public class SeguimientoKey implements java.io.Serializable, Cloneable {
    /* idSeguimiento */
    protected int idseguimiento;

    /* idSeguimiento */
    public int getIdseguimiento() {
        return idseguimiento;
    }

    /* idSeguimiento */
    public void setIdseguimiento(int idseguimiento) {
        this.idseguimiento = idseguimiento;
    }

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        hashCode += new Integer(idseguimiento).hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof SeguimientoKey))
            return false;

        SeguimientoKey key = (SeguimientoKey) obj;

        if (this.idseguimiento != key.idseguimiento)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        SeguimientoKey key = new SeguimientoKey();
        key.idseguimiento = this.idseguimiento;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idseguimiento").append(" = ").append(idseguimiento).append("]");
        return sb.toString();
    }
}