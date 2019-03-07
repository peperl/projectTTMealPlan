package mx.ipn.www.finalproject.model;

/*
 * For Table planalimenticio
 */
public class Planalimenticio implements java.io.Serializable, Cloneable {
    private PlanalimenticioKey _key = new PlanalimenticioKey();

    /* idPlanAlimenticio, PK */
    protected int idplanalimenticio;

    /* Paciente_idPaciente */
    protected int pacienteIdpaciente;

    /* FechaCreacion */
    protected java.util.Date fechacreacion;

    /* Duracion */
    protected int duracion;

    /* GastoCalorico */
    protected double gastocalorico;

    /* Proteinas */
    protected double proteinas;

    /* Lipidos */
    protected double lipidos;

    /* Carbohidratos */
    protected double carbohidratos;

    /* NoComidas */
    protected int nocomidas;

    /* Estado */
    protected int estado;

    /* TMR */
    protected double tmr;

    /* Return the key object. */
    public PlanalimenticioKey getKeyObject() {
        return _key;
    }

    /* idPlanAlimenticio, PK */
    public int getIdplanalimenticio() {
        return idplanalimenticio;
    }

    /* idPlanAlimenticio, PK */
    public void setIdplanalimenticio(int idplanalimenticio) {
        this.idplanalimenticio = idplanalimenticio;
        _key.setIdplanalimenticio(idplanalimenticio);
    }

    /* Paciente_idPaciente */
    public int getPacienteIdpaciente() {
        return pacienteIdpaciente;
    }

    /* Paciente_idPaciente */
    public void setPacienteIdpaciente(int pacienteIdpaciente) {
        this.pacienteIdpaciente = pacienteIdpaciente;
    }

    /* FechaCreacion */
    public java.util.Date getFechacreacion() {
        return fechacreacion;
    }

    /* FechaCreacion */
    public void setFechacreacion(java.util.Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    /* Duracion */
    public int getDuracion() {
        return duracion;
    }

    /* Duracion */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /* GastoCalorico */
    public double getGastocalorico() {
        return gastocalorico;
    }

    /* GastoCalorico */
    public void setGastocalorico(double gastocalorico) {
        this.gastocalorico = gastocalorico;
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

    /* NoComidas */
    public int getNocomidas() {
        return nocomidas;
    }

    /* NoComidas */
    public void setNocomidas(int nocomidas) {
        this.nocomidas = nocomidas;
    }

    /* Estado */
    public int getEstado() {
        return estado;
    }

    /* Estado */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /* TMR */
    public double getTmr() {
        return tmr;
    }

    /* TMR */
    public void setTmr(double tmr) {
        this.tmr = tmr;
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Planalimenticio))
            return false;

        Planalimenticio bean = (Planalimenticio) obj;

        if (this.idplanalimenticio != bean.idplanalimenticio)
            return false;

        if (this.pacienteIdpaciente != bean.pacienteIdpaciente)
            return false;

        if (this.fechacreacion == null) {
            if (bean.fechacreacion != null)
                return false;
        }
        else if (!this.fechacreacion.equals(bean.fechacreacion)) 
            return false;

        if (this.duracion != bean.duracion)
            return false;

        if (this.gastocalorico != bean.gastocalorico)
            return false;

        if (this.proteinas != bean.proteinas)
            return false;

        if (this.lipidos != bean.lipidos)
            return false;

        if (this.carbohidratos != bean.carbohidratos)
            return false;

        if (this.nocomidas != bean.nocomidas)
            return false;

        if (this.estado != bean.estado)
            return false;

        if (this.tmr != bean.tmr)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Planalimenticio bean = new Planalimenticio();
        bean.idplanalimenticio = this.idplanalimenticio;
        bean.pacienteIdpaciente = this.pacienteIdpaciente;
        if (this.fechacreacion != null)
            bean.fechacreacion = (java.util.Date) this.fechacreacion.clone();
        bean.duracion = this.duracion;
        bean.gastocalorico = this.gastocalorico;
        bean.proteinas = this.proteinas;
        bean.lipidos = this.lipidos;
        bean.carbohidratos = this.carbohidratos;
        bean.nocomidas = this.nocomidas;
        bean.estado = this.estado;
        bean.tmr = this.tmr;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idplanalimenticio").append(" = ").append(idplanalimenticio).append("]").append(sep);
        sb.append("[").append("pacienteIdpaciente").append(" = ").append(pacienteIdpaciente).append("]").append(sep);
        sb.append("[").append("fechacreacion").append(" = ").append(fechacreacion).append("]").append(sep);
        sb.append("[").append("duracion").append(" = ").append(duracion).append("]").append(sep);
        sb.append("[").append("gastocalorico").append(" = ").append(gastocalorico).append("]").append(sep);
        sb.append("[").append("proteinas").append(" = ").append(proteinas).append("]").append(sep);
        sb.append("[").append("lipidos").append(" = ").append(lipidos).append("]").append(sep);
        sb.append("[").append("carbohidratos").append(" = ").append(carbohidratos).append("]").append(sep);
        sb.append("[").append("nocomidas").append(" = ").append(nocomidas).append("]").append(sep);
        sb.append("[").append("estado").append(" = ").append(estado).append("]").append(sep);
        sb.append("[").append("tmr").append(" = ").append(tmr).append("]").append(sep);
        return sb.toString();
    }
}