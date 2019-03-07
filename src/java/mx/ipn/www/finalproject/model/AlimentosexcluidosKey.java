package mx.ipn.www.finalproject.model;

public class AlimentosexcluidosKey implements java.io.Serializable, Cloneable {
    /* Paciente_idPaciente */
    protected int pacienteIdpaciente;

    /* Alimento_idAlimento */
    protected int alimentoIdalimento;

    /* Paciente_idPaciente */
    public int getPacienteIdpaciente() {
        return pacienteIdpaciente;
    }

    /* Paciente_idPaciente */
    public void setPacienteIdpaciente(int pacienteIdpaciente) {
        this.pacienteIdpaciente = pacienteIdpaciente;
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
        hashCode += new Integer(pacienteIdpaciente).hashCode();
        hashCode += new Integer(alimentoIdalimento).hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof AlimentosexcluidosKey))
            return false;

        AlimentosexcluidosKey key = (AlimentosexcluidosKey) obj;

        if (this.pacienteIdpaciente != key.pacienteIdpaciente)
            return false;

        if (this.alimentoIdalimento != key.alimentoIdalimento)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        AlimentosexcluidosKey key = new AlimentosexcluidosKey();
        key.pacienteIdpaciente = this.pacienteIdpaciente;
        key.alimentoIdalimento = this.alimentoIdalimento;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("pacienteIdpaciente").append(" = ").append(pacienteIdpaciente).append("]");
        sb.append("[").append("alimentoIdalimento").append(" = ").append(alimentoIdalimento).append("]");
        return sb.toString();
    }
}