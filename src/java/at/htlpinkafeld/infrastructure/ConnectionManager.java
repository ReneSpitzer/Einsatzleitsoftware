/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Bernhard
 */
public class ConnectionManager {
	private volatile static ConnectionManager connectionManager = null;
	private Connection connection = null;
 
	private ConnectionManager() throws SQLException {
 
    	     try { // load driver
          	     Class.forName("com.mysql.jdbc.Driver");
      	           
	            connection = DriverManager.getConnection("jdbc:mysql://mysql57b.ssl-net.net/h26u287_EinsatzleitSW", "h26u287", "fidelio!@");
    	     } catch (ClassNotFoundException ex) {
                   Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);    
            }
	}
 
	public synchronized static ConnectionManager getInstance() throws SQLException {
    		if (connectionManager == null) 
            	   connectionManager = new ConnectionManager();
    		return connectionManager;
	}
 
	public Connection getConnection() { return connection; }
 
	public static void closeConnection() {
          //close the connection only if there is a instance
          //--> closeConnection() can always be called. 
          //(e.g. if non JDBC-Dao's are used  --> ConnectionManager is not instantiated)
          if (connectionManager  != null) {
             try {
                connectionManager .connection.close();
             } catch (SQLException ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
             }
          }
       }
}

