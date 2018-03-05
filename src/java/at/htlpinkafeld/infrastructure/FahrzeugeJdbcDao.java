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
public class FahrzeugeJdbcDao extends BaseJdbcDao<Fahrzeuge> implements FahrzeugeDao {

    public FahrzeugeJdbcDao(String tablename, String pKey) {
        super(tablename, pKey);
    }

    @Override
    protected Fahrzeuge getPojoFromResultSet(ResultSet result) throws SQLException {
        Fahrzeuge f = new Fahrzeuge(result.getString("organisation"), result.getString("ort"), result.getString("type"), 
            result.getInt("anzPers"), result.getBoolean("verfuegbar"), result.getString("name"), result.getInt("bid"));
        f.setId(result.getInt(this.getPkName()));
        return f;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Fahrzeuge t) throws SQLException {
        String s = "UPDATE " + getTablename() + " SET organisation=?, ort=?, type=?, anzPers=?, verfuegbar=?, name=?, bid=? WHERE " + getPkName() + "=?";
        PreparedStatement stmt = c.prepareStatement(s);
        stmt.setString(1, t.getOrganisation());
        stmt.setString(2, t.getOrt());
        stmt.setString(3, t.getType());
        stmt.setInt(4, t.getAnzPers());
        stmt.setBoolean(5, t.isVerfuegbar());
        stmt.setString(6, t.getName());
        stmt.setInt(7, t.getBid());
        stmt.setInt(8, t.getId());
        return stmt;

    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Fahrzeuge t) throws SQLException {
        String s = "INSERT INTO " + getTablename() + " (fid,organisation, ort, type, anzPers, verfuegbar, name, bid) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, t.getId());
        stmt.setString(2, t.getOrganisation());
        stmt.setString(3, t.getOrt());
        stmt.setString(4, t.getType());
        stmt.setInt(5, t.getAnzPers());
        stmt.setBoolean(6, t.isVerfuegbar());
        stmt.setString(7, t.getName());
        stmt.setInt(8, t.getBid());
        return stmt;
    }
}
