/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.infrastructure;

import at.htlpinkafeld.pojo.Zeitaufzeichnung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bernhard
 */
public class ZeitaufzeichnungJdbcDao extends BaseJdbcDao<Zeitaufzeichnung> implements ZeitaufzeichnungDao {

    public ZeitaufzeichnungJdbcDao(String tablename, String pKey) {
        super(tablename, pKey);
    }

    @Override
    protected Zeitaufzeichnung getPojoFromResultSet(ResultSet result) throws SQLException {
        Zeitaufzeichnung z = new Zeitaufzeichnung(result.getDate("aenderungszeitpunkt"), result.getString("aenderung"), 
                result.getInt("eid"), result.getInt("bid"));
        z.setId(result.getInt(this.getPkName()));
        return z;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Zeitaufzeichnung t) throws SQLException {
        String s = "UPDATE " + getTablename() + " SET aenderungszeitpunkt=?, aenderung=?, eid=?, bid=? WHERE " + getPkName() + "=?";
        PreparedStatement stmt = c.prepareStatement(s);
        stmt.setDate(1, t.getAenderungszeitpunkt());
        stmt.setString(2, t.getAenderung());
        stmt.setInt(3, t.getEid());
        stmt.setInt(4, t.getBid());
        stmt.setInt(5, t.getId());
        return stmt;

    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Zeitaufzeichnung t) throws SQLException {
        String s = "INSERT INTO " + getTablename() + " (aenderungszeitpunkt, aenderung, eid, bid) VALUES (?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
        stmt.setDate(1, t.getAenderungszeitpunkt());
        stmt.setString(2, t.getAenderung());
        stmt.setInt(3, t.getEid());
        stmt.setInt(4, t.getBid());
        return stmt;
    }
}
