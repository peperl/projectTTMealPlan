package mx.ipn.www.finalproject.model;

public class AlimentosequivalentesKey implements java.io.Serializable, Cloneable {
    /* idAlimentosEquivalentes */
    protected int idalimentosequivalentes;

    /* idAlimentosEquivalentes */
    public int getIdalimentosequivalentes() {
        return idalimentosequivalentes;
    }

    /* idAlimentosEquivalentes */
    public void setIdalimentosequivalentes(int idalimentosequivalentes) {
        this.idalimentosequivalentes = idalimentosequivalentes;
    }

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        hashCode += new Integer(idalimentosequivalentes).hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof AlimentosequivalentesKey))
            return false;

        AlimentosequivalentesKey key = (AlimentosequivalentesKey) obj;

        if (this.idalimentosequivalentes != key.idalimentosequivalentes)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        AlimentosequivalentesKey key = new AlimentosequivalentesKey();
        key.idalimentosequivalentes = this.idalimentosequivalentes;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idalimentosequivalentes").append(" = ").append(idalimentosequivalentes).append("]");
        return sb.toString();
    }
}