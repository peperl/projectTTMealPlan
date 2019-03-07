package mx.ipn.www.finalproject.model;

public class PacienteKey implements java.io.Serializable, Cloneable {
    /* idPaciente */
    protected int idpaciente;

    /* idPaciente */
    public int getIdpaciente() {
        return idpaciente;
    }

    /* idPaciente */
    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        hashCode += new Integer(idpaciente).hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof PacienteKey))
            return false;

        PacienteKey key = (PacienteKey) obj;

        if (this.idpaciente != key.idpaciente)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        PacienteKey key = new PacienteKey();
        key.idpaciente = this.idpaciente;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idpaciente").append(" = ").append(idpaciente).append("]");
        return sb.toString();
    }
}