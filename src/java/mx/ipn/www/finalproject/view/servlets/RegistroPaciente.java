/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.view.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.www.finalproject.model.Alimentosexcluidos;
import mx.ipn.www.finalproject.model.Paciente;
import mx.ipn.www.finalproject.model.Planalimenticio;
import mx.ipn.www.finalproject.model.Usuario;
import mx.ipn.www.finalproject.model.dao.AlimentosexcluidosDAO;
import mx.ipn.www.finalproject.model.dao.PacienteDAO;
import mx.ipn.www.finalproject.model.dao.PlanalimenticioDAO;
import mx.ipn.www.finalproject.model.dao.UsuarioDAO;
import mx.ipn.www.finalproject.model.orm.AlimentosexcluidosDAOImpl;
import mx.ipn.www.finalproject.model.orm.PacienteDAOImpl;
import mx.ipn.www.finalproject.model.orm.PlanalimenticioDAOImpl;
import mx.ipn.www.finalproject.model.orm.UsuarioDAOImpl;
import mx.ipn.www.finalproject.utils.ConnectionByPayaraSource;
import mx.ipn.www.finalproject.utils.QRgenerator;

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
            
        String email = request.getParameter("correo");
        
        String fechaNacimientoString = request.getParameter("dateBirth");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate fechaNacimientoLocalDate = LocalDate.parse(fechaNacimientoString, formatter);

        int usuarioIdusuario;//listo
        int nutricionistaIdnutricionista;
        String nombre = request.getParameter("firstname");
        String apellidos = request.getParameter("lastname");
        Date fechanacimiento = Date.from(fechaNacimientoLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String sexo = request.getParameter("sexo");
        String telefono = request.getParameter("telephone");
        String direccion = request.getParameter("address");
        double pesoanterior = Double.parseDouble(request.getParameter("weightBefore"));
        double estatura = Double.parseDouble(request.getParameter("height"));
        double cirbraquial = Double.parseDouble(request.getParameter("branquial"));
        double cirpantorrilla = Double.parseDouble(request.getParameter("Pantorrilla"));
        String dificultadesaliment;//listo
        String enfermedades; //listo
        String tratamiento;//listo
        double proteinaanterior = Double.parseDouble(request.getParameter("actualProteins"));
        double lipidosanterior = Double.parseDouble(request.getParameter("actualCarbo"));
        double carbohidratosanterior = Double.parseDouble(request.getParameter("actualLipid"));
        double comidasanterior = Double.parseDouble(request.getParameter("actualMealsQty"));
        int actividadfisica = Integer.parseInt(request.getParameter("phisicalActivity"));
        Date fechaRegistro = new Date();
        
        int pacienteIdpaciente; //listo
        Date fechacreacion;//listo
        int duracion = Integer.parseInt(request.getParameter("timePlan"));
        int nocomidas = Integer.parseInt(request.getParameter("newMealsQty"));
        int estado = 0;
        double proteinas = Double.parseDouble(request.getParameter("proteinPercent"));
        double lipidos = Double.parseDouble(request.getParameter("CarboPercent"));
        double carbohidratos = Double.parseDouble(request.getParameter("lipPercent"));
        
        List<Alimentosexcluidos> alimentosexcluidos = new ArrayList<>();
        
        try {
            dificultadesaliment = request.getParameter("difficultiesToEat");
        } catch (Exception e) {
            dificultadesaliment = "";
        }
        try {
            enfermedades = request.getParameter("diseases");
        } catch (Exception e) {
            enfermedades = "";
        }
        try {
            tratamiento = request.getParameter("treatment");
        } catch (Exception e) {
            tratamiento = "";
        }

        try {            
            HttpSession session = request.getSession();
            nutricionistaIdnutricionista = (int) session.getAttribute("idNutricionista");

            
            ConnectionByPayaraSource connectionClass = new ConnectionByPayaraSource();
            Connection con = connectionClass.initConnection();

            Usuario usuario = new Usuario(email);
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            usuarioDAO.create(usuario, con);
            usuario = usuarioDAO.loadByEmail(usuario, con);
            usuarioIdusuario = usuario.getIdusuario();
            
            
            
            Paciente paciente = new Paciente(usuarioIdusuario, nutricionistaIdnutricionista, nombre, apellidos, fechanacimiento, sexo, telefono, direccion, pesoanterior, estatura, cirbraquial, cirpantorrilla, dificultadesaliment, enfermedades, tratamiento, proteinaanterior, lipidosanterior, carbohidratosanterior, comidasanterior, actividadfisica, fechaRegistro, estado);
            PacienteDAO pacienteDAO = new PacienteDAOImpl();
            pacienteDAO.create(paciente, con);
            paciente = pacienteDAO.loadByName(paciente, con);
            
            
            pacienteIdpaciente = paciente.getIdpaciente();
            fechacreacion = new Date();
            
            
            Planalimenticio planalimenticio = new Planalimenticio(pacienteIdpaciente, fechacreacion, duracion, nocomidas, estado, proteinas, lipidos, carbohidratos);
            PlanalimenticioDAO planalimenticioDAO = new PlanalimenticioDAOImpl();
            planalimenticioDAO.create(planalimenticio, con);
            planalimenticio = planalimenticioDAO.loadLastPlan(planalimenticio, con);
            
            String[] alimEv = request.getParameter("alimEv").split(",");
            if (!alimEv[0].equals("") & alimEv[0] != null) {
                int[] alimentoIdalimentos =  new int[alimEv.length];
                int cont = 0;
                for (String string : alimEv) {
                    alimentoIdalimentos[cont++] = Integer.parseInt(string);
                }
                for (int alimentoIdalimento : alimentoIdalimentos) {
                    Alimentosexcluidos aux = new Alimentosexcluidos(pacienteIdpaciente, alimentoIdalimento);
                    alimentosexcluidos.add(aux);
                }
                AlimentosexcluidosDAO alimentosexcluidosDAO = new AlimentosexcluidosDAOImpl();
                for (Alimentosexcluidos alimentosexcluido : alimentosexcluidos) {
                    alimentosexcluidosDAO.create(alimentosexcluido, con);
                }
            }
            connectionClass.destroy();
            
            String qr = QRgenerator.generateQRContent(usuarioIdusuario + "");
            
            
            QRgenerator.generateQRImage(qr, constanteQR.ConstanteQR.PATH_QR + usuarioIdusuario);
            
            
            session.setAttribute("qrid", usuarioIdusuario);
            session.setAttribute("pacienteIdpaciente", paciente);
            session.setAttribute("idPlanAlimenticio", planalimenticio);
            session.setAttribute("namePaciente", paciente.getNombre() + " " + paciente.getApellidos());
            ServletContext sc = request.getServletContext();
            String path = sc.getContextPath();
            response.sendRedirect( path + "/pages/Nutricionista/muestraCodigo.jsp");
        }   catch (NamingException | SQLException ex) {
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
