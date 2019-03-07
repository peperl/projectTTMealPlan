package mx.ipn.www.finalproject.model;

/*
 * For Table seguimiento
 */
public class Seguimiento implements java.io.Serializable, Cloneable {
    private SeguimientoKey _key = new SeguimientoKey();

    /* idSeguimiento, PK */
    protected int idseguimiento;

    /* Cumplimiento */
    protected String cumplimiento;

    /* Fecha */
    protected java.util.Date fecha;

    /* Comida_idComida */
    protected int comidaIdcomida;

    /* AlimentosEquivalentes_idAlimentosEquivalentes */
    protected int alimentosequivalentesIdalimentosequivalentes;

    /* Return the key object. */
    public SeguimientoKey getKeyObject() {
        return _key;
    }

    /* idSeguimiento, PK */
    public int getIdseguimiento() {
        return idseguimiento;
    }

    /* idSeguimiento, PK */
    public void setIdseguimiento(int idseguimiento) {
        this.idseguimiento = idseguimiento;
        _key.setIdseguimiento(idseguimiento);
    }

    /* Cumplimiento */
    public String getCumplimiento() {
        return cumplimiento;
    }

    /* Cumplimiento */
    public void setCumplimiento(String cumplimiento) {
        this.cumplimiento = cumplimiento;
    }

    /* Fecha */
    public java.util.Date getFecha() {
        return fecha;
    }

    /* Fecha */
    public void setFecha(java.util.Date fecha) {
        this.fecha = fecha;
    }

    /* Comida_idComida */
    public int getComidaIdcomida() {
        return comidaIdcomida;
    }

    /* Comida_idComida */
    public void setComidaIdcomida(int comidaIdcomida) {
        this.comidaIdcomida = comidaIdcomida;
    }

    /* AlimentosEquivalentes_idAlimentosEquivalentes */
    public int getAlimentosequivalentesIdalimentosequivalentes() {
        return alimentosequivalentesIdalimentosequivalentes;
    }

    /* AlimentosEquivalentes_idAlimentosEquivalentes */
    public void setAlimentosequivalentesIdalimentosequivalentes(int alimentosequivalentesIdalimentosequivalentes) {
        this.alimentosequivalentesIdalimentosequivalentes = alimentosequivalentesIdalimentosequivalentes;
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Seguimiento))
            return false;

        Seguimiento bean = (Seguimiento) obj;

        if (this.idseguimiento != bean.idseguimiento)
            return false;

        if (this.cumplimiento == null) {
            if (bean.cumplimiento != null)
                return false;
        }
        else if (!this.cumplimiento.equals(bean.cumplimiento)) 
            return false;

        if (this.fecha == null) {
            if (bean.fecha != null)
                return false;
        }
        else if (!this.fecha.equals(bean.fecha)) 
            return false;

        if (this.comidaIdcomida != bean.comidaIdcomida)
            return false;

        if (this.alimentosequivalentesIdalimentosequivalentes != bean.alimentosequivalentesIdalimentosequivalentes)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Seguimiento bean = new Seguimiento();
        bean.idseguimiento = this.idseguimiento;
        bean.cumplimiento = this.cumplimiento;
        if (this.fecha != null)
            bean.fecha = (java.util.Date) this.fecha.clone();
        bean.comidaIdcomida = this.comidaIdcomida;
        bean.alimentosequivalentesIdalimentosequivalentes = this.alimentosequivalentesIdalimentosequivalentes;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idseguimiento").append(" = ").append(idseguimiento).append("]").append(sep);
        sb.append("[").append("cumplimiento").append(" = ").append(cumplimiento).append("]").append(sep);
        sb.append("[").append("fecha").append(" = ").append(fecha).append("]").append(sep);
        sb.append("[").append("comidaIdcomida").append(" = ").append(comidaIdcomida).append("]").append(sep);
        sb.append("[").append("alimentosequivalentesIdalimentosequivalentes").append(" = ").append(alimentosequivalentesIdalimentosequivalentes).append("]").append(sep);
        return sb.toString();
    }
}