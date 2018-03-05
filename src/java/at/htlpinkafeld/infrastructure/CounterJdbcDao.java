/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.infrastructure;

import at.htlpinkafeld.pojo.Counter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bernhard Fuchs
 */

public class CounterJdbcDao extends BaseJdbcDao<Counter> implements CounterDao {

    public CounterJdbcDao(String tablename, String pKey) {
        super(tablename, pKey);
    }

    @Override
    protected Counter getPojoFromResultSet(ResultSet result) throws SQLException {
        Counter b = new Counter(result.getInt("cntBenutzer"), result.getInt("cntEinsatz"),  
                result.getInt("cntEigeneinsatz"), result.getInt("cntFremdeinsatz"), 
                result.getInt("cntFahrzeuge"), result.getInt("cntFunkgeraet"), result.getInt("cntKontakt"),
                result.getInt("cntNuessler"), result.getInt("cntPerson"), result.getInt("cntZeitaufzeichnung"));
        b.setId(result.getInt(this.getPkName()));
        return b;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Counter t) throws SQLException {
        String s = "UPDATE " + getTablename() + " SET cntBenutzer=?, cntEinsatz=?, cnt=Eigeneinsatz?, cntFremdeinsatz=?, cntFahrzeuge=?, "
                + "cnt=Funkgeraet?, cntKontakt=?, "
                + "cntNuessler=?, cntPerson=?, cntZeitaufzeichnung=? WHERE " + getPkName() + "=?";
        PreparedStatement stmt = c.prepareStatement(s);
        stmt.setInt(1, t.getCntBenutzer());
        stmt.setInt(2, t.getCntEinsatz());
        stmt.setInt(3, t.getCntEigeneinsatz());
        stmt.setInt(4, t.getCntFremdeinsatz());
        stmt.setInt(5, t.getCntFahrzeuge());
        stmt.setInt(6, t.getCntFunkgeraet());
        stmt.setInt(7, t.getCntKontakt());
        stmt.setInt(8, t.getCntNuessler());
        stmt.setInt(9, t.getCntPerson());
        stmt.setInt(10, t.getCntZeitaufzeichnung());
        stmt.setInt(11, t.getId());
        return stmt;

    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Counter t) throws SQLException {
        String s = "INSERT INTO " + getTablename() + " (cid, cntBenutzer, cntEinsatz, cntEigeneinsatz, cntFremdeinsatz, cntFahrzeuge, "
                + "cntFunkgeraet, cntKontakt, cntNuessler, cntPerson, cntZeitaufzeichnung) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, t.getId());
        stmt.setInt(2, t.getCntBenutzer());
        stmt.setInt(3, t.getCntEinsatz());
        stmt.setInt(4, t.getCntEigeneinsatz());
        stmt.setInt(5, t.getCntFremdeinsatz());
        stmt.setInt(6, t.getCntFahrzeuge());
        stmt.setInt(7, t.getCntFunkgeraet());
        stmt.setInt(8, t.getCntKontakt());
        stmt.setInt(9, t.getCntNuessler());
        stmt.setInt(10, t.getCntPerson());
        stmt.setInt(11, t.getCntZeitaufzeichnung());
        
        return stmt;
    }
}
