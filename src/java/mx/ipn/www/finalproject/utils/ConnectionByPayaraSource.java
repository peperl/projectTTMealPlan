/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.utils;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
  public Connection initConnection () throws ServletException, NamingException, NamingException, SQLException {
      ctx = new InitialContext();
      //MySqlConnector es el nombre que le di a mi recurso en payara
      ds = (DataSource) ctx.lookup("mysql_Pool");
        System.out.println("");
      conn = ds.getConnection();
      return conn;
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
