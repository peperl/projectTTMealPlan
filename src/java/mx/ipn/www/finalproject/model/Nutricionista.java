package mx.ipn.www.finalproject.model;

/*
 * For Table nutricionista
 */
public class Nutricionista implements java.io.Serializable, Cloneable {
    private NutricionistaKey _key = new NutricionistaKey();

    /* idNutricionista, PK */
    protected int idnutricionista;

    /* Usuario_idUsuario */
    protected int usuarioIdusuario;

    /* Nombre */
    protected String nombre;

    /* Cedula */
    protected String cedula;

    /* FechaNacimiento */
    protected java.util.Date fechanacimiento;

    /* EscuelaProcedencia */
    protected String escuelaprocedencia;

    /* Telefono */
    protected String telefono;

    /* Direccion */
    protected String direccion;

    /* Estado */
    protected int estado;

    /* FechaRegistro */
    protected java.util.Date fecharegistro;

    /* FechaAceptado */
    protected java.util.Date fechaaceptado;

    /* Return the key object. */
    public NutricionistaKey getKeyObject() {
        return _key;
    }

    /* idNutricionista, PK */
    public int getIdnutricionista() {
        return idnutricionista;
    }

    /* idNutricionista, PK */
    public void setIdnutricionista(int idnutricionista) {
        this.idnutricionista = idnutricionista;
        _key.setIdnutricionista(idnutricionista);
    }

    /* Usuario_idUsuario */
    public int getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    /* Usuario_idUsuario */
    public void setUsuarioIdusuario(int usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    /* Nombre */
    public String getNombre() {
        return nombre;
    }

    /* Nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /* Cedula */
    public String getCedula() {
        return cedula;
    }

    /* Cedula */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /* FechaNacimiento */
    public java.util.Date getFechanacimiento() {
        return fechanacimiento;
    }

    /* FechaNacimiento */
    public void setFechanacimiento(java.util.Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    /* EscuelaProcedencia */
    public String getEscuelaprocedencia() {
        return escuelaprocedencia;
    }

    /* EscuelaProcedencia */
    public void setEscuelaprocedencia(String escuelaprocedencia) {
        this.escuelaprocedencia = escuelaprocedencia;
    }

    /* Telefono */
    public String getTelefono() {
        return telefono;
    }

    /* Telefono */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /* Direccion */
    public String getDireccion() {
        return direccion;
    }

    /* Direccion */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /* Estado */
    public int getEstado() {
        return estado;
    }

    /* Estado */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /* FechaRegistro */
    public java.util.Date getFecharegistro() {
        return fecharegistro;
    }

    /* FechaRegistro */
    public void setFecharegistro(java.util.Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /* FechaAceptado */
    public java.util.Date getFechaaceptado() {
        return fechaaceptado;
    }

    /* FechaAceptado */
    public void setFechaaceptado(java.util.Date fechaaceptado) {
        this.fechaaceptado = fechaaceptado;
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Nutricionista))
            return false;

        Nutricionista bean = (Nutricionista) obj;

        if (this.idnutricionista != bean.idnutricionista)
            return false;

        if (this.usuarioIdusuario != bean.usuarioIdusuario)
            return false;

        if (this.nombre == null) {
            if (bean.nombre != null)
                return false;
        }
        else if (!this.nombre.equals(bean.nombre)) 
            return false;

        if (this.cedula == null) {
            if (bean.cedula != null)
                return false;
        }
        else if (!this.cedula.equals(bean.cedula)) 
            return false;

        if (this.fechanacimiento == null) {
            if (bean.fechanacimiento != null)
                return false;
        }
        else if (!this.fechanacimiento.equals(bean.fechanacimiento)) 
            return false;

        if (this.escuelaprocedencia == null) {
            if (bean.escuelaprocedencia != null)
                return false;
        }
        else if (!this.escuelaprocedencia.equals(bean.escuelaprocedencia)) 
            return false;

        if (this.telefono == null) {
            if (bean.telefono != null)
                return false;
        }
        else if (!this.telefono.equals(bean.telefono)) 
            return false;

        if (this.direccion == null) {
            if (bean.direccion != null)
                return false;
        }
        else if (!this.direccion.equals(bean.direccion)) 
            return false;

        if (this.estado != bean.estado)
            return false;

        if (this.fecharegistro == null) {
            if (bean.fecharegistro != null)
                return false;
        }
        else if (!this.fecharegistro.equals(bean.fecharegistro)) 
            return false;

        if (this.fechaaceptado == null) {
            if (bean.fechaaceptado != null)
                return false;
        }
        else if (!this.fechaaceptado.equals(bean.fechaaceptado)) 
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Nutricionista bean = new Nutricionista();
        bean.idnutricionista = this.idnutricionista;
        bean.usuarioIdusuario = this.usuarioIdusuario;
        bean.nombre = this.nombre;
        bean.cedula = this.cedula;
        if (this.fechanacimiento != null)
            bean.fechanacimiento = (java.util.Date) this.fechanacimiento.clone();
        bean.escuelaprocedencia = this.escuelaprocedencia;
        bean.telefono = this.telefono;
        bean.direccion = this.direccion;
        bean.estado = this.estado;
        if (this.fecharegistro != null)
            bean.fecharegistro = (java.util.Date) this.fecharegistro.clone();
        if (this.fechaaceptado != null)
            bean.fechaaceptado = (java.util.Date) this.fechaaceptado.clone();
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idnutricionista").append(" = ").append(idnutricionista).append("]").append(sep);
        sb.append("[").append("usuarioIdusuario").append(" = ").append(usuarioIdusuario).append("]").append(sep);
        sb.append("[").append("nombre").append(" = ").append(nombre).append("]").append(sep);
        sb.append("[").append("cedula").append(" = ").append(cedula).append("]").append(sep);
        sb.append("[").append("fechanacimiento").append(" = ").append(fechanacimiento).append("]").append(sep);
        sb.append("[").append("escuelaprocedencia").append(" = ").append(escuelaprocedencia).append("]").append(sep);
        sb.append("[").append("telefono").append(" = ").append(telefono).append("]").append(sep);
        sb.append("[").append("direccion").append(" = ").append(direccion).append("]").append(sep);
        sb.append("[").append("estado").append(" = ").append(estado).append("]").append(sep);
        sb.append("[").append("fecharegistro").append(" = ").append(fecharegistro).append("]").append(sep);
        sb.append("[").append("fechaaceptado").append(" = ").append(fechaaceptado).append("]").append(sep);
        return sb.toString();
    }
}