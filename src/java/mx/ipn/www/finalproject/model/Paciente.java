package mx.ipn.www.finalproject.model;

/*
 * For Table paciente
 */
public class Paciente implements java.io.Serializable, Cloneable {
    private PacienteKey _key = new PacienteKey();

    /* idPaciente, PK */
    protected int idpaciente;

    /* Usuario_idUsuario */
    protected int usuarioIdusuario;

    /* Nutricionista_idNutricionista */
    protected int nutricionistaIdnutricionista;

    /* Nombre */
    protected String nombre;

    /* Apellidos */
    protected String apellidos;

    /* FechaNacimiento */
    protected java.util.Date fechanacimiento;

    /* Ocupacion */
    protected String ocupacion;

    /* Telefono */
    protected String telefono;

    /* Direccion */
    protected String direccion;

    /* PesoAnterior */
    protected double pesoanterior;

    /* Estatura */
    protected double estatura;

    /* CirBraquial */
    protected double cirbraquial;

    /* CirPantorrilla */
    protected String cirpantorrilla;

    /* DificultadesAliment */
    protected String dificultadesaliment;

    /* Enfermedades */
    protected String enfermedades;

    /* Tratamiento */
    protected String tratamiento;

    /* ProteinaAnterior */
    protected double proteinaanterior;

    /* LipidosAnterior */
    protected double lipidosanterior;

    /* CarbohidratosAnterior */
    protected double carbohidratosanterior;

    /* ComidasAnterior */
    protected double comidasanterior;

    /* ActividadFisica */
    protected double actividadfisica;

    /* FechaRegistro */
    protected String fecharegistro;

    /* Estado */
    protected int estado;

    /* Return the key object. */
    public PacienteKey getKeyObject() {
        return _key;
    }

    /* idPaciente, PK */
    public int getIdpaciente() {
        return idpaciente;
    }

    /* idPaciente, PK */
    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
        _key.setIdpaciente(idpaciente);
    }

    /* Usuario_idUsuario */
    public int getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    /* Usuario_idUsuario */
    public void setUsuarioIdusuario(int usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    /* Nutricionista_idNutricionista */
    public int getNutricionistaIdnutricionista() {
        return nutricionistaIdnutricionista;
    }

    /* Nutricionista_idNutricionista */
    public void setNutricionistaIdnutricionista(int nutricionistaIdnutricionista) {
        this.nutricionistaIdnutricionista = nutricionistaIdnutricionista;
    }

    /* Nombre */
    public String getNombre() {
        return nombre;
    }

    /* Nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /* Apellidos */
    public String getApellidos() {
        return apellidos;
    }

    /* Apellidos */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /* FechaNacimiento */
    public java.util.Date getFechanacimiento() {
        return fechanacimiento;
    }

    /* FechaNacimiento */
    public void setFechanacimiento(java.util.Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    /* Ocupacion */
    public String getOcupacion() {
        return ocupacion;
    }

    /* Ocupacion */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
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

    /* PesoAnterior */
    public double getPesoanterior() {
        return pesoanterior;
    }

    /* PesoAnterior */
    public void setPesoanterior(double pesoanterior) {
        this.pesoanterior = pesoanterior;
    }

    /* Estatura */
    public double getEstatura() {
        return estatura;
    }

    /* Estatura */
    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    /* CirBraquial */
    public double getCirbraquial() {
        return cirbraquial;
    }

    /* CirBraquial */
    public void setCirbraquial(double cirbraquial) {
        this.cirbraquial = cirbraquial;
    }

    /* CirPantorrilla */
    public String getCirpantorrilla() {
        return cirpantorrilla;
    }

    /* CirPantorrilla */
    public void setCirpantorrilla(String cirpantorrilla) {
        this.cirpantorrilla = cirpantorrilla;
    }

    /* DificultadesAliment */
    public String getDificultadesaliment() {
        return dificultadesaliment;
    }

    /* DificultadesAliment */
    public void setDificultadesaliment(String dificultadesaliment) {
        this.dificultadesaliment = dificultadesaliment;
    }

    /* Enfermedades */
    public String getEnfermedades() {
        return enfermedades;
    }

    /* Enfermedades */
    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    /* Tratamiento */
    public String getTratamiento() {
        return tratamiento;
    }

    /* Tratamiento */
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    /* ProteinaAnterior */
    public double getProteinaanterior() {
        return proteinaanterior;
    }

    /* ProteinaAnterior */
    public void setProteinaanterior(double proteinaanterior) {
        this.proteinaanterior = proteinaanterior;
    }

    /* LipidosAnterior */
    public double getLipidosanterior() {
        return lipidosanterior;
    }

    /* LipidosAnterior */
    public void setLipidosanterior(double lipidosanterior) {
        this.lipidosanterior = lipidosanterior;
    }

    /* CarbohidratosAnterior */
    public double getCarbohidratosanterior() {
        return carbohidratosanterior;
    }

    /* CarbohidratosAnterior */
    public void setCarbohidratosanterior(double carbohidratosanterior) {
        this.carbohidratosanterior = carbohidratosanterior;
    }

    /* ComidasAnterior */
    public double getComidasanterior() {
        return comidasanterior;
    }

    /* ComidasAnterior */
    public void setComidasanterior(double comidasanterior) {
        this.comidasanterior = comidasanterior;
    }

    /* ActividadFisica */
    public double getActividadfisica() {
        return actividadfisica;
    }

    /* ActividadFisica */
    public void setActividadfisica(double actividadfisica) {
        this.actividadfisica = actividadfisica;
    }

    /* FechaRegistro */
    public String getFecharegistro() {
        return fecharegistro;
    }

    /* FechaRegistro */
    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /* Estado */
    public int getEstado() {
        return estado;
    }

    /* Estado */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Paciente))
            return false;

        Paciente bean = (Paciente) obj;

        if (this.idpaciente != bean.idpaciente)
            return false;

        if (this.usuarioIdusuario != bean.usuarioIdusuario)
            return false;

        if (this.nutricionistaIdnutricionista != bean.nutricionistaIdnutricionista)
            return false;

        if (this.nombre == null) {
            if (bean.nombre != null)
                return false;
        }
        else if (!this.nombre.equals(bean.nombre)) 
            return false;

        if (this.apellidos == null) {
            if (bean.apellidos != null)
                return false;
        }
        else if (!this.apellidos.equals(bean.apellidos)) 
            return false;

        if (this.fechanacimiento == null) {
            if (bean.fechanacimiento != null)
                return false;
        }
        else if (!this.fechanacimiento.equals(bean.fechanacimiento)) 
            return false;

        if (this.ocupacion == null) {
            if (bean.ocupacion != null)
                return false;
        }
        else if (!this.ocupacion.equals(bean.ocupacion)) 
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

        if (this.pesoanterior != bean.pesoanterior)
            return false;

        if (this.estatura != bean.estatura)
            return false;

        if (this.cirbraquial != bean.cirbraquial)
            return false;

        if (this.cirpantorrilla == null) {
            if (bean.cirpantorrilla != null)
                return false;
        }
        else if (!this.cirpantorrilla.equals(bean.cirpantorrilla)) 
            return false;

        if (this.dificultadesaliment == null) {
            if (bean.dificultadesaliment != null)
                return false;
        }
        else if (!this.dificultadesaliment.equals(bean.dificultadesaliment)) 
            return false;

        if (this.enfermedades == null) {
            if (bean.enfermedades != null)
                return false;
        }
        else if (!this.enfermedades.equals(bean.enfermedades)) 
            return false;

        if (this.tratamiento == null) {
            if (bean.tratamiento != null)
                return false;
        }
        else if (!this.tratamiento.equals(bean.tratamiento)) 
            return false;

        if (this.proteinaanterior != bean.proteinaanterior)
            return false;

        if (this.lipidosanterior != bean.lipidosanterior)
            return false;

        if (this.carbohidratosanterior != bean.carbohidratosanterior)
            return false;

        if (this.comidasanterior != bean.comidasanterior)
            return false;

        if (this.actividadfisica != bean.actividadfisica)
            return false;

        if (this.fecharegistro == null) {
            if (bean.fecharegistro != null)
                return false;
        }
        else if (!this.fecharegistro.equals(bean.fecharegistro)) 
            return false;

        if (this.estado != bean.estado)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Paciente bean = new Paciente();
        bean.idpaciente = this.idpaciente;
        bean.usuarioIdusuario = this.usuarioIdusuario;
        bean.nutricionistaIdnutricionista = this.nutricionistaIdnutricionista;
        bean.nombre = this.nombre;
        bean.apellidos = this.apellidos;
        if (this.fechanacimiento != null)
            bean.fechanacimiento = (java.util.Date) this.fechanacimiento.clone();
        bean.ocupacion = this.ocupacion;
        bean.telefono = this.telefono;
        bean.direccion = this.direccion;
        bean.pesoanterior = this.pesoanterior;
        bean.estatura = this.estatura;
        bean.cirbraquial = this.cirbraquial;
        bean.cirpantorrilla = this.cirpantorrilla;
        bean.dificultadesaliment = this.dificultadesaliment;
        bean.enfermedades = this.enfermedades;
        bean.tratamiento = this.tratamiento;
        bean.proteinaanterior = this.proteinaanterior;
        bean.lipidosanterior = this.lipidosanterior;
        bean.carbohidratosanterior = this.carbohidratosanterior;
        bean.comidasanterior = this.comidasanterior;
        bean.actividadfisica = this.actividadfisica;
        bean.fecharegistro = this.fecharegistro;
        bean.estado = this.estado;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idpaciente").append(" = ").append(idpaciente).append("]").append(sep);
        sb.append("[").append("usuarioIdusuario").append(" = ").append(usuarioIdusuario).append("]").append(sep);
        sb.append("[").append("nutricionistaIdnutricionista").append(" = ").append(nutricionistaIdnutricionista).append("]").append(sep);
        sb.append("[").append("nombre").append(" = ").append(nombre).append("]").append(sep);
        sb.append("[").append("apellidos").append(" = ").append(apellidos).append("]").append(sep);
        sb.append("[").append("fechanacimiento").append(" = ").append(fechanacimiento).append("]").append(sep);
        sb.append("[").append("ocupacion").append(" = ").append(ocupacion).append("]").append(sep);
        sb.append("[").append("telefono").append(" = ").append(telefono).append("]").append(sep);
        sb.append("[").append("direccion").append(" = ").append(direccion).append("]").append(sep);
        sb.append("[").append("pesoanterior").append(" = ").append(pesoanterior).append("]").append(sep);
        sb.append("[").append("estatura").append(" = ").append(estatura).append("]").append(sep);
        sb.append("[").append("cirbraquial").append(" = ").append(cirbraquial).append("]").append(sep);
        sb.append("[").append("cirpantorrilla").append(" = ").append(cirpantorrilla).append("]").append(sep);
        sb.append("[").append("dificultadesaliment").append(" = ").append(dificultadesaliment).append("]").append(sep);
        sb.append("[").append("enfermedades").append(" = ").append(enfermedades).append("]").append(sep);
        sb.append("[").append("tratamiento").append(" = ").append(tratamiento).append("]").append(sep);
        sb.append("[").append("proteinaanterior").append(" = ").append(proteinaanterior).append("]").append(sep);
        sb.append("[").append("lipidosanterior").append(" = ").append(lipidosanterior).append("]").append(sep);
        sb.append("[").append("carbohidratosanterior").append(" = ").append(carbohidratosanterior).append("]").append(sep);
        sb.append("[").append("comidasanterior").append(" = ").append(comidasanterior).append("]").append(sep);
        sb.append("[").append("actividadfisica").append(" = ").append(actividadfisica).append("]").append(sep);
        sb.append("[").append("fecharegistro").append(" = ").append(fecharegistro).append("]").append(sep);
        sb.append("[").append("estado").append(" = ").append(estado).append("]").append(sep);
        return sb.toString();
    }
}