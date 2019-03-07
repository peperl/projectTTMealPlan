package mx.ipn.www.finalproject.model;

/*
 * For Table alimento
 */
public class Alimento implements java.io.Serializable, Cloneable {
    private AlimentoKey _key = new AlimentoKey();

    /* idAlimento, PK */
    protected int idalimento;

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

    /* Estado */
    protected int estado;

    /* Categoria */
    protected int categoria;
    
    /* Unidad de Medida */
    protected String unidadDeMedida;

    /* Return the key object. */
    public AlimentoKey getKeyObject() {
        return _key;
    }

    /* idAlimento, PK */
    public int getIdalimento() {
        return idalimento;
    }

    /* idAlimento, PK */
    public void setIdalimento(int idalimento) {
        this.idalimento = idalimento;
        _key.setIdalimento(idalimento);
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

    /* Estado */
    public int getEstado() {
        return estado;
    }

    /* Estado */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /* Categoria */
    public int getCategoria() {
        return categoria;
    }

    /* Categoria */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    /* Unidad de Medida */
    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    /* Unidad de Medida */
    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Alimento))
            return false;

        Alimento bean = (Alimento) obj;

        if (this.idalimento != bean.idalimento)
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

        if (this.estado != bean.estado)
            return false;

        if (this.categoria != bean.categoria)
            return false;
        
        if (this.unidadDeMedida == null) {
            if (bean.unidadDeMedida != null)
                return false;
        }
        else if (!this.unidadDeMedida.equals(bean.unidadDeMedida)) 
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Alimento bean = new Alimento();
        bean.idalimento = this.idalimento;
        bean.nombre = this.nombre;
        bean.cantidad = this.cantidad;
        bean.proteinas = this.proteinas;
        bean.lipidos = this.lipidos;
        bean.carbohidratos = this.carbohidratos;
        bean.estado = this.estado;
        bean.categoria = this.categoria;
        bean.unidadDeMedida = this.unidadDeMedida;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idalimento").append(" = ").append(idalimento).append("]").append(sep);
        sb.append("[").append("nombre").append(" = ").append(nombre).append("]").append(sep);
        sb.append("[").append("cantidad").append(" = ").append(cantidad).append("]").append(sep);
        sb.append("[").append("proteinas").append(" = ").append(proteinas).append("]").append(sep);
        sb.append("[").append("lipidos").append(" = ").append(lipidos).append("]").append(sep);
        sb.append("[").append("carbohidratos").append(" = ").append(carbohidratos).append("]").append(sep);
        sb.append("[").append("estado").append(" = ").append(estado).append("]").append(sep);
        sb.append("[").append("categoria").append(" = ").append(categoria).append("]").append(sep);
        sb.append("[").append("unidadDeMedida").append(" = ").append(unidadDeMedida).append("]").append(sep);
        return sb.toString();
    }
}