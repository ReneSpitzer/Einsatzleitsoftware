/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.infrastructure;

import java.sql.Connection;
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
     private static volatile ConnectionManager inst = null;
    private DataSource ds = null;

    public static synchronized ConnectionManager getInstance()
    {
        if(inst == null)
            inst = new ConnectionManager();
        return inst;
    }
    
    private ConnectionManager()
    {
        try{
            Context ctx = new InitialContext();
            ds = (DataSource)ctx.lookup("java:comp/env/jdbc/company");
        } catch (NamingException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection()
    {
        Connection retVal = null;
        
        try {
            retVal = ds.getConnection();
        } catch (SQLException ex) {
            System.err.println(ex.getStackTrace());
        }
        return retVal;
    }
    
    public WrappedConnection getWrappedConnection() throws SQLException {
            return new WrappedConnection(this.ds.getConnection(), true);
    }
}
