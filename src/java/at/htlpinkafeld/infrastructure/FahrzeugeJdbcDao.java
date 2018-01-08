/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.infrastructure;

import at.htlpinkafeld.pojo.Fahrzeuge;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bernhard
 */
public class FahrzeugeJdbcDao extends BaseJdbcDao<Fahrzeuge> implements Dao<Fahrzeuge> {

    public FahrzeugeJdbcDao(String tablename, String pKey) {
        super(tablename, pKey);
    }

    @Override
    protected Fahrzeuge getPojoFromResultSet(ResultSet result) throws SQLException {
        Fahrzeuge f = new Fahrzeuge(result.getString("organisation"), result.getString("ort"), result.getString("type"), 
            result.getInt("anzPers"), result.getInt("status"), result.getString("name"), result.getInt("bid"));
        f.setId(result.getInt(this.getPkName()));
        return f;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Fahrzeuge t) throws SQLException {
        String s = "UPDATE " + getTablename() + " SET organisation=?, ort=?, type=?, anzPers=?, status=?, name=?, bid=? WHERE " + getPkName() + "=?";
        PreparedStatement stmt = c.prepareStatement(s);
        stmt.setString(1, t.getOrganisation());
        stmt.setString(2, t.getOrt());
        stmt.setString(3, t.getType());
        stmt.setInt(4, t.getAnzPers());
        stmt.setInt(5, t.getStatus());
        stmt.setString(6, t.getName());
        stmt.setInt(7, t.getBid());
        stmt.setInt(8, t.getId());
        return stmt;

    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Fahrzeuge t) throws SQLException {
        String s = "INSERT INTO " + getTablename() + " (organisation, ort, type, anzPers, status, name, bid) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, t.getOrganisation());
        stmt.setString(2, t.getOrt());
        stmt.setString(3, t.getType());
        stmt.setInt(4, t.getAnzPers());
        stmt.setInt(5, t.getStatus());
        stmt.setString(6, t.getName());
        stmt.setInt(7, t.getBid());
        return stmt;
    }
}
