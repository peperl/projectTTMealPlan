/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.utils;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import javax.servlet.ServletException;

/**
 *
 * @author pepe
 */
public class ConnectionByPayaraSource {
    
    private InitialContext ctx = null;
    private DataSource ds = null;
    private Connection conn = null;
        
  public Connection initConnection () throws ServletException {
    try {
      ctx = new InitialContext();
      //MySqlConnector es el nombre que le di a mi recurso en payara
      ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MySqlConnector");
      conn = ds.getConnection();
    }
    catch (SQLException se) {
      System.out.println("SQLException: "+se.getMessage());
    }
    catch (NamingException ne) {
      System.out.println("NamingException: "+ne.getMessage());
    }
    return null;
  }

  public void destroy () {
    try {
      if (conn != null)
        conn.close();
      if (ctx != null)
        ctx.close();
    }   
    catch (SQLException se) {
      System.out.println("SQLException: "+se.getMessage());
    }
    catch (NamingException ne) {
      System.out.println("NamingException: "+ne.getMessage());
    }
  }
}
