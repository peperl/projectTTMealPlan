package mx.ipn.www.finalproject.model;

public class UsuarioKey implements java.io.Serializable, Cloneable {
    /* idUsuario */
    protected int idusuario;

    /* idUsuario */
    public int getIdusuario() {
        return idusuario;
    }

    /* idUsuario */
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        hashCode += new Integer(idusuario).hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof UsuarioKey))
            return false;

        UsuarioKey key = (UsuarioKey) obj;

        if (this.idusuario != key.idusuario)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        UsuarioKey key = new UsuarioKey();
        key.idusuario = this.idusuario;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idusuario").append(" = ").append(idusuario).append("]");
        return sb.toString();
    }
}