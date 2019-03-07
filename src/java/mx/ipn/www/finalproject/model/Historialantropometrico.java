package mx.ipn.www.finalproject.model;

/*
 * For Table historialantropometrico
 */
public class Historialantropometrico implements java.io.Serializable, Cloneable {
    private HistorialantropometricoKey _key = new HistorialantropometricoKey();

    /* idRegistro, PK */
    protected int idregistro;

    /* Paciente_idPaciente */
    protected int pacienteIdpaciente;

    /* Fecha */
    protected java.util.Date fecha;

    /* Peso */
    protected double peso;

    /* IMC */
    protected double imc;

    /* Grasa */
    protected double grasa;

    /* Return the key object. */
    public HistorialantropometricoKey getKeyObject() {
        return _key;
    }

    /* idRegistro, PK */
    public int getIdregistro() {
        return idregistro;
    }

    /* idRegistro, PK */
    public void setIdregistro(int idregistro) {
        this.idregistro = idregistro;
        _key.setIdregistro(idregistro);
    }

    /* Paciente_idPaciente */
    public int getPacienteIdpaciente() {
        return pacienteIdpaciente;
    }

    /* Paciente_idPaciente */
    public void setPacienteIdpaciente(int pacienteIdpaciente) {
        this.pacienteIdpaciente = pacienteIdpaciente;
    }

    /* Fecha */
    public java.util.Date getFecha() {
        return fecha;
    }

    /* Fecha */
    public void setFecha(java.util.Date fecha) {
        this.fecha = fecha;
    }

    /* Peso */
    public double getPeso() {
        return peso;
    }

    /* Peso */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /* IMC */
    public double getImc() {
        return imc;
    }

    /* IMC */
    public void setImc(double imc) {
        this.imc = imc;
    }

    /* Grasa */
    public double getGrasa() {
        return grasa;
    }

    /* Grasa */
    public void setGrasa(double grasa) {
        this.grasa = grasa;
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Historialantropometrico))
            return false;

        Historialantropometrico bean = (Historialantropometrico) obj;

        if (this.idregistro != bean.idregistro)
            return false;

        if (this.pacienteIdpaciente != bean.pacienteIdpaciente)
            return false;

        if (this.fecha == null) {
            if (bean.fecha != null)
                return false;
        }
        else if (!this.fecha.equals(bean.fecha)) 
            return false;

        if (this.peso != bean.peso)
            return false;

        if (this.imc != bean.imc)
            return false;

        if (this.grasa != bean.grasa)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Historialantropometrico bean = new Historialantropometrico();
        bean.idregistro = this.idregistro;
        bean.pacienteIdpaciente = this.pacienteIdpaciente;
        if (this.fecha != null)
            bean.fecha = (java.util.Date) this.fecha.clone();
        bean.peso = this.peso;
        bean.imc = this.imc;
        bean.grasa = this.grasa;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idregistro").append(" = ").append(idregistro).append("]").append(sep);
        sb.append("[").append("pacienteIdpaciente").append(" = ").append(pacienteIdpaciente).append("]").append(sep);
        sb.append("[").append("fecha").append(" = ").append(fecha).append("]").append(sep);
        sb.append("[").append("peso").append(" = ").append(peso).append("]").append(sep);
        sb.append("[").append("imc").append(" = ").append(imc).append("]").append(sep);
        sb.append("[").append("grasa").append(" = ").append(grasa).append("]").append(sep);
        return sb.toString();
    }
}