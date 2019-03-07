package mx.ipn.www.finalproject.model;

public class AlimentoKey implements java.io.Serializable, Cloneable {
    /* idAlimento */
    protected int idalimento;

    /* idAlimento */
    public int getIdalimento() {
        return idalimento;
    }

    /* idAlimento */
    public void setIdalimento(int idalimento) {
        this.idalimento = idalimento;
    }

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        hashCode += new Integer(idalimento).hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof AlimentoKey))
            return false;

        AlimentoKey key = (AlimentoKey) obj;

        if (this.idalimento != key.idalimento)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        AlimentoKey key = new AlimentoKey();
        key.idalimento = this.idalimento;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idalimento").append(" = ").append(idalimento).append("]");
        return sb.toString();
    }
}