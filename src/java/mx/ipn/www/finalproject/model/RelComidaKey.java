package mx.ipn.www.finalproject.model;

public class RelComidaKey implements java.io.Serializable, Cloneable {
    /* Comida_idComida */
    protected int comidaIdcomida;

    /* Alimento_idAlimento */
    protected int alimentoIdalimento;

    /* Comida_idComida */
    public int getComidaIdcomida() {
        return comidaIdcomida;
    }

    /* Comida_idComida */
    public void setComidaIdcomida(int comidaIdcomida) {
        this.comidaIdcomida = comidaIdcomida;
    }

    /* Alimento_idAlimento */
    public int getAlimentoIdalimento() {
        return alimentoIdalimento;
    }

    /* Alimento_idAlimento */
    public void setAlimentoIdalimento(int alimentoIdalimento) {
        this.alimentoIdalimento = alimentoIdalimento;
    }

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        hashCode += new Integer(comidaIdcomida).hashCode();
        hashCode += new Integer(alimentoIdalimento).hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof RelComidaKey))
            return false;

        RelComidaKey key = (RelComidaKey) obj;

        if (this.comidaIdcomida != key.comidaIdcomida)
            return false;

        if (this.alimentoIdalimento != key.alimentoIdalimento)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        RelComidaKey key = new RelComidaKey();
        key.comidaIdcomida = this.comidaIdcomida;
        key.alimentoIdalimento = this.alimentoIdalimento;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("comidaIdcomida").append(" = ").append(comidaIdcomida).append("]");
        sb.append("[").append("alimentoIdalimento").append(" = ").append(alimentoIdalimento).append("]");
        return sb.toString();
    }
}