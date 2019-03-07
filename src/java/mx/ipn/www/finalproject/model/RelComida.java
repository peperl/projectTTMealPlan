package mx.ipn.www.finalproject.model;

/*
 * For Table rel_comida
 */
public class RelComida implements java.io.Serializable, Cloneable {
    private RelComidaKey _key = new RelComidaKey();

    /* Comida_idComida, PK */
    protected int comidaIdcomida;

    /* Alimento_idAlimento, PK */
    protected int alimentoIdalimento;

    /* Return the key object. */
    public RelComidaKey getKeyObject() {
        return _key;
    }

    /* Comida_idComida, PK */
    public int getComidaIdcomida() {
        return comidaIdcomida;
    }

    /* Comida_idComida, PK */
    public void setComidaIdcomida(int comidaIdcomida) {
        this.comidaIdcomida = comidaIdcomida;
        _key.setComidaIdcomida(comidaIdcomida);
    }

    /* Alimento_idAlimento, PK */
    public int getAlimentoIdalimento() {
        return alimentoIdalimento;
    }

    /* Alimento_idAlimento, PK */
    public void setAlimentoIdalimento(int alimentoIdalimento) {
        this.alimentoIdalimento = alimentoIdalimento;
        _key.setAlimentoIdalimento(alimentoIdalimento);
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof RelComida))
            return false;

        RelComida bean = (RelComida) obj;

        if (this.comidaIdcomida != bean.comidaIdcomida)
            return false;

        if (this.alimentoIdalimento != bean.alimentoIdalimento)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        RelComida bean = new RelComida();
        bean.comidaIdcomida = this.comidaIdcomida;
        bean.alimentoIdalimento = this.alimentoIdalimento;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("comidaIdcomida").append(" = ").append(comidaIdcomida).append("]").append(sep);
        sb.append("[").append("alimentoIdalimento").append(" = ").append(alimentoIdalimento).append("]").append(sep);
        return sb.toString();
    }
}