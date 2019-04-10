/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.view.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.ipn.www.finalproject.model.Paciente;
import mx.ipn.www.finalproject.model.Usuario;
import mx.ipn.www.finalproject.model.dao.UsuarioDAO;
import mx.ipn.www.finalproject.model.orm.UsuarioDAOImpl;
import mx.ipn.www.finalproject.utils.ConnectionByPayaraSource;

/**
 *
 * @author pepe
 */
public class RegistroPaciente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        /*
            &dateBirth=05%2F25%2F1996
            &estadoCivil=Soltero
            &Aextras=Design
            &AextrasDisease=Code
            &difficultiesToEat=MUELAS+DEL+JUICIO%0D%0A
            &diseases=DIabetes
            &treatment=CLORURO+DE+SODIO
            &newMealsQty=5
            &timePlan=4
            &speed=Lento
            &finish=Guardar
        */
            
        String email = request.getParameter("correo");
        
        int usuarioIdusuario;
        int nutricionistaIdnutricionista;
        String nombre = request.getParameter("firstname");
        String apellidos = request.getParameter("lastname");
        Date fechanacimiento;
        String ocupacion = request.getParameter("ocupacion");
        String telefono = request.getParameter("telephone");
        String direccion = request.getParameter("address");
        double pesoanterior = Double.parseDouble(request.getParameter("weightBefore"));
        double estatura = Double.parseDouble(request.getParameter("height"));
        double cirbraquial = Double.parseDouble(request.getParameter("branquial"));
        double cirpantorrilla = Double.parseDouble(request.getParameter("Pantorrilla"));
        String dificultadesaliment;
        String enfermedades;
        String tratamiento;
        double proteinaanterior = Double.parseDouble(request.getParameter("actualProteins"));
        double lipidosanterior = Double.parseDouble(request.getParameter("actualCarbo"));
        double carbohidratosanterior = Double.parseDouble(request.getParameter("actualLipid"));
        double comidasanterior = Double.parseDouble(request.getParameter("actualMealsQty"));
        double actividadfisica = Double.parseDouble(request.getParameter("phisicalActivity"));
        
        try {            
            ConnectionByPayaraSource connectionClass = new ConnectionByPayaraSource();
            Connection con = connectionClass.initConnection();
            Usuario usuario = new Usuario(email);
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            //Registrar usuario y obtener el id del usuario
            
        }   catch (NamingException ex) {
            Logger.getLogger(RegistroPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
