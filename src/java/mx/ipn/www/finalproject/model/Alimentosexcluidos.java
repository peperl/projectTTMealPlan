package mx.ipn.www.finalproject.model;

/*
 * For Table alimentosexcluidos
 */
public class Alimentosexcluidos implements java.io.Serializable, Cloneable {
    private AlimentosexcluidosKey _key = new AlimentosexcluidosKey();

    /* Paciente_idPaciente, PK */
    protected int pacienteIdpaciente;

    /* Alimento_idAlimento, PK */
    protected int alimentoIdalimento;

    /* Return the key object. */
    public AlimentosexcluidosKey getKeyObject() {
        return _key;
    }

    /* Paciente_idPaciente, PK */
    public int getPacienteIdpaciente() {
        return pacienteIdpaciente;
    }

    /* Paciente_idPaciente, PK */
    public void setPacienteIdpaciente(int pacienteIdpaciente) {
        this.pacienteIdpaciente = pacienteIdpaciente;
        _key.setPacienteIdpaciente(pacienteIdpaciente);
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

        if (obj == null || !(obj instanceof Alimentosexcluidos))
            return false;

        Alimentosexcluidos bean = (Alimentosexcluidos) obj;

        if (this.pacienteIdpaciente != bean.pacienteIdpaciente)
            return false;

        if (this.alimentoIdalimento != bean.alimentoIdalimento)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Alimentosexcluidos bean = new Alimentosexcluidos();
        bean.pacienteIdpaciente = this.pacienteIdpaciente;
        bean.alimentoIdalimento = this.alimentoIdalimento;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("pacienteIdpaciente").append(" = ").append(pacienteIdpaciente).append("]").append(sep);
        sb.append("[").append("alimentoIdalimento").append(" = ").append(alimentoIdalimento).append("]").append(sep);
        return sb.toString();
    }
}