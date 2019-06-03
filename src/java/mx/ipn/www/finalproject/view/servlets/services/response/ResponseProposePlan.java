/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.view.servlets.services.response;

import java.util.ArrayList;
import java.util.List;
import mx.ipn.www.finalproject.model.Alimento;

/**
 *
 * @author pepe
 */
public class ResponseProposePlan {

    /* idAlimento, PK */
    protected int idalimento;

    /* Nombre */
    protected String nombre;

    /* Cantidad */
    protected double cantidad;

    /* Cantidad */
    protected String unidad;

    /* Proteinas */
    protected double proteinas;

    /* Lipidos */
    protected double lipidos;

    /* Carbohidratos */
    protected double carbohidratos;

    /* Estado */
    protected int estado;

    /* Categoria */
    protected int categoria;
    
    protected int quantity;

    public ResponseProposePlan(Alimento a, int quantity) {
        this.idalimento = a.getIdalimento();
        this.nombre = a.getNombre();
        this.cantidad = a.getCantidad();
        this.unidad = a.getUnidad();
        this.proteinas = a.getProteinas();
        this.lipidos = a.getLipidos();
        this.carbohidratos = a.getCarbohidratos();
        this.estado = a.getEstado();
        this.categoria = a.getCategoria();
        this.quantity = quantity;
    }
    
}
