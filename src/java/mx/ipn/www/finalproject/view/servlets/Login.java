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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.www.finalproject.model.Nutricionista;
import mx.ipn.www.finalproject.model.Usuario;
import mx.ipn.www.finalproject.model.UsuarioKey;
import mx.ipn.www.finalproject.model.dao.NutricionistaDAO;
import mx.ipn.www.finalproject.model.dao.UsuarioDAO;
import mx.ipn.www.finalproject.model.orm.NutricionistaDAOImpl;
import mx.ipn.www.finalproject.model.orm.UsuarioDAOImpl;
import mx.ipn.www.finalproject.utils.ConnectionByPayaraSource;

/**
 *
 * @author pepe
 */
public class Login extends HttpServlet {

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
        String correo = request.getParameter("emailadress");
        String pass = request.getParameter("password");
        Usuario result = null;
        try {        
            Usuario usuario = new Usuario(correo, pass);
            ConnectionByPayaraSource connector = new ConnectionByPayaraSource();
            Connection conn;

            conn = connector.initConnection();
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            result = usuarioDAO.loadForLoginNuricionista(usuario, conn);
            
        
            if (result != null) {
                NutricionistaDAO dao = new NutricionistaDAOImpl();
                
                Nutricionista nutricionista = dao.loadByUser(result.getKeyObject(), conn);
                HttpSession session = request.getSession();
                session.setAttribute("idNutricionista", nutricionista.getIdnutricionista());
                session.setAttribute("nameNutricionista", nutricionista.getNombre());
                //ServletContext sc = request.getServletContext();
                //String path = sc.getContextPath();
                //response.sendRedirect( path + "/pages/Nutricionista/muestraCodigo.jsp");

                response.sendRedirect("./pages/Nutricionista/BlankN.jsp");

            } else {
                response.sendRedirect("./pages/login.html?loginError=yes");
            }
            connector.destroy();
        } catch (NamingException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
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


