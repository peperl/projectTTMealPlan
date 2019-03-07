package mx.ipn.www.finalproject.model;

/*
 * For Table alimentosequivalentes
 */
public class Alimentosequivalentes implements java.io.Serializable, Cloneable {
    private AlimentosequivalentesKey _key = new AlimentosequivalentesKey();

    /* idAlimentosEquivalentes, PK */
    protected int idalimentosequivalentes;

    /* Nombre */
    protected String nombre;

    /* Cantidad */
    protected double cantidad;

    /* Proteinas */
    protected double proteinas;

    /* Lipidos */
    protected double lipidos;

    /* Carbohidratos */
    protected double carbohidratos;

    /* Return the key object. */
    public AlimentosequivalentesKey getKeyObject() {
        return _key;
    }

    /* idAlimentosEquivalentes, PK */
    public int getIdalimentosequivalentes() {
        return idalimentosequivalentes;
    }

    /* idAlimentosEquivalentes, PK */
    public void setIdalimentosequivalentes(int idalimentosequivalentes) {
        this.idalimentosequivalentes = idalimentosequivalentes;
        _key.setIdalimentosequivalentes(idalimentosequivalentes);
    }

    /* Nombre */
    public String getNombre() {
        return nombre;
    }

    /* Nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /* Cantidad */
    public double getCantidad() {
        return cantidad;
    }

    /* Cantidad */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /* Proteinas */
    public double getProteinas() {
        return proteinas;
    }

    /* Proteinas */
    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    /* Lipidos */
    public double getLipidos() {
        return lipidos;
    }

    /* Lipidos */
    public void setLipidos(double lipidos) {
        this.lipidos = lipidos;
    }

    /* Carbohidratos */
    public double getCarbohidratos() {
        return carbohidratos;
    }

    /* Carbohidratos */
    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Alimentosequivalentes))
            return false;

        Alimentosequivalentes bean = (Alimentosequivalentes) obj;

        if (this.idalimentosequivalentes != bean.idalimentosequivalentes)
            return false;

        if (this.nombre == null) {
            if (bean.nombre != null)
                return false;
        }
        else if (!this.nombre.equals(bean.nombre)) 
            return false;

        if (this.cantidad != bean.cantidad)
            return false;

        if (this.proteinas != bean.proteinas)
            return false;

        if (this.lipidos != bean.lipidos)
            return false;

        if (this.carbohidratos != bean.carbohidratos)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Alimentosequivalentes bean = new Alimentosequivalentes();
        bean.idalimentosequivalentes = this.idalimentosequivalentes;
        bean.nombre = this.nombre;
        bean.cantidad = this.cantidad;
        bean.proteinas = this.proteinas;
        bean.lipidos = this.lipidos;
        bean.carbohidratos = this.carbohidratos;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idalimentosequivalentes").append(" = ").append(idalimentosequivalentes).append("]").append(sep);
        sb.append("[").append("nombre").append(" = ").append(nombre).append("]").append(sep);
        sb.append("[").append("cantidad").append(" = ").append(cantidad).append("]").append(sep);
        sb.append("[").append("proteinas").append(" = ").append(proteinas).append("]").append(sep);
        sb.append("[").append("lipidos").append(" = ").append(lipidos).append("]").append(sep);
        sb.append("[").append("carbohidratos").append(" = ").append(carbohidratos).append("]").append(sep);
        return sb.toString();
    }
}