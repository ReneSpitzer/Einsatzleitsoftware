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
    private DataSource datSrc;
    private volatile static ConnectionManager connectionManager = null;
    
    private ConnectionManager(){
        String dsName = "jdbc/EinsatzleitSW";
        try{
            Context ctx = new javax.naming.InitialContext();
            datSrc = (DataSource) ctx.lookup("java:comp/env/" + dsName);
        } catch (NamingException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection() throws SQLException{
        return this.datSrc.getConnection();
    }
    
    public static synchronized ConnectionManager getInstance(){
        
        if(connectionManager == null){
            connectionManager = new ConnectionManager();
        }
        
        return connectionManager;
    }
}

