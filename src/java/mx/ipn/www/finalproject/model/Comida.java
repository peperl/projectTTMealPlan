/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Wed Mar 13 01:44:23 CST 2019
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package mx.ipn.www.finalproject.model;

import java.time.LocalTime;

/*
 * For Table comida
 */
public class Comida implements java.io.Serializable, Cloneable {
    private ComidaKey _key = new ComidaKey();

    /* idComida, PK */
    protected int idcomida;

    /* PlanAlimenticio_idPlanAlimenticio */
    protected int planalimenticioIdplanalimenticio;

    /* Nombre */
    protected String nombre;

    /* Dia */
    protected String dia;

    /* Numero */
    protected int numero;

    /* Hora */
    protected LocalTime hora;

    /* Return the key object. */
    public ComidaKey getKeyObject() {
        return _key;
    }

    /* idComida, PK */
    public int getIdcomida() {
        return idcomida;
    }

    /* idComida, PK */
    public void setIdcomida(int idcomida) {
        this.idcomida = idcomida;
        _key.setIdcomida(idcomida);
    }

    /* PlanAlimenticio_idPlanAlimenticio */
    public int getPlanalimenticioIdplanalimenticio() {
        return planalimenticioIdplanalimenticio;
    }

    /* PlanAlimenticio_idPlanAlimenticio */
    public void setPlanalimenticioIdplanalimenticio(int planalimenticioIdplanalimenticio) {
        this.planalimenticioIdplanalimenticio = planalimenticioIdplanalimenticio;
    }

    /* Nombre */
    public String getNombre() {
        return nombre;
    }

    /* Nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /* Dia */
    public String getDia() {
        return dia;
    }

    /* Dia */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /* Numero */
    public int getNumero() {
        return numero;
    }

    /* Numero */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /* Hora */
    public LocalTime getHora() {
        return hora;
    }

    /* Hora */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Comida))
            return false;

        Comida bean = (Comida) obj;

        if (this.idcomida != bean.idcomida)
            return false;

        if (this.planalimenticioIdplanalimenticio != bean.planalimenticioIdplanalimenticio)
            return false;

        if (this.nombre == null) {
            if (bean.nombre != null)
                return false;
        }
        else if (!this.nombre.equals(bean.nombre)) 
            return false;

        if (this.dia == null) {
            if (bean.dia != null)
                return false;
        }
        else if (!this.dia.equals(bean.dia)) 
            return false;

        if (this.numero != bean.numero)
            return false;

        if (this.hora == null) {
            if (bean.hora != null)
                return false;
        }
        else if (!this.hora.equals(bean.hora)) 
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Comida bean = new Comida();
        bean.idcomida = this.idcomida;
        bean.planalimenticioIdplanalimenticio = this.planalimenticioIdplanalimenticio;
        bean.nombre = this.nombre;
        bean.dia = this.dia;
        bean.numero = this.numero;
        if (this.hora != null)
            bean.hora = this.hora;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("idcomida").append(" = ").append(idcomida).append("]").append(sep);
        sb.append("[").append("planalimenticioIdplanalimenticio").append(" = ").append(planalimenticioIdplanalimenticio).append("]").append(sep);
        sb.append("[").append("nombre").append(" = ").append(nombre).append("]").append(sep);
        sb.append("[").append("dia").append(" = ").append(dia).append("]").append(sep);
        sb.append("[").append("numero").append(" = ").append(numero).append("]").append(sep);
        sb.append("[").append("hora").append(" = ").append(hora).append("]").append(sep);
        return sb.toString();
    }
}