/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Wed Mar 13 01:44:23 CST 2019
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

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

    /* Cantidad */
    protected int cantidad;

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

    /* Cantidad */
    public int getCantidad() {
        return cantidad;
    }

    /* Cantidad */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

        if (this.cantidad != bean.cantidad)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        RelComida bean = new RelComida();
        bean.comidaIdcomida = this.comidaIdcomida;
        bean.alimentoIdalimento = this.alimentoIdalimento;
        bean.cantidad = this.cantidad;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("comidaIdcomida").append(" = ").append(comidaIdcomida).append("]").append(sep);
        sb.append("[").append("alimentoIdalimento").append(" = ").append(alimentoIdalimento).append("]").append(sep);
        sb.append("[").append("cantidad").append(" = ").append(cantidad).append("]").append(sep);
        return sb.toString();
    }
}