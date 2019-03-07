package mx.ipn.www.finalproject.model;

/*
 * For Table usuario
 */
public class Usuario implements java.io.Serializable, Cloneable {
    private UsuarioKey _key = new UsuarioKey();

    /* idUsuario, PK */
    protected int idusuario;

    /* Correo */
    protected String correo;

    /* Pass */
    protected String pass;

    /* Return the key object. */
    public UsuarioKey getKeyObject() {
        return _key;
    }

    /* idUsuario, PK */
    public int getIdusuario() {
        return idusuario;
    }

    /* idUsuario, PK */
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
        _key.setIdusuario(idusuario);
    }

    /* Correo */
    public String getCorreo() {
        return correo;
    }

    /* Correo */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /* Pass */
    public String getPass() {
        return pass;
    }

    /* Pass */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Usuario))
            return false;

        Usuario bean = (Usuario) obj;

        if (this.idusuario != bean.idusuario)
            return false;

        if (this.correo == null) {
            if (bean.correo != null)
                return false;
        }
        else if (!this.correo.equals(bean.correo)) 
            return false;

        if (this.pass == null) {
            if (bean.pass != null)
                return false;
        }
        else if (!this.pass.equals(bean.pass)) 
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Usuario bean = new Usuario();
        bean.idusuario = this.idusuario;
        bean.correo = this.correo;
        bean.pass = this.pass;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idusuario").append(" = ").append(idusuario).append("]").append(sep);
        sb.append("[").append("correo").append(" = ").append(correo).append("]").append(sep);
        sb.append("[").append("pass").append(" = ").append(pass).append("]").append(sep);
        return sb.toString();
    }
}