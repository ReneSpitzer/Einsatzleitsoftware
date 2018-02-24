/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.infrastructure;

import at.htlpinkafeld.pojo.Nüssler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bernhard
 */
public class NüsslerJdbcDao extends BaseJdbcDao<Nüssler> implements NüsslerDao {

    public NüsslerJdbcDao(String tablename, String pKey) {
        super(tablename, pKey);
    }

    @Override
    protected Nüssler getPojoFromResultSet(ResultSet result) throws SQLException {
        Nüssler n = new Nüssler(result.getInt("UNnr"), result.getString("stoffname"), result.getInt("merkblattnr"),
                                  result.getInt("radius_innen"), result.getInt("radius_außen"), result.getString("info"));
        n.setId(result.getInt(this.getPkName()));
        return n;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Nüssler t) throws SQLException {
        String s = "UPDATE " + getTablename() + " SET UNnr=?, stoffname=?, merkblattnr=?, radius_innen=?, radius_außen=?, info=?"
                + " WHERE " + getPkName() + "=?";
        PreparedStatement stmt = c.prepareStatement(s);
        stmt.setInt(1, t.getUNnr());
        stmt.setString(2, t.getStoffname());
        stmt.setInt(3, t.getMerkblattnr());
        stmt.setInt(4, t.getRadius_innen());
        stmt.setInt(5, t.getRadius_außen());
        stmt.setString(6, t.getInfo());
        stmt.setInt(7, t.getId());
        return stmt;

    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Nüssler t) throws SQLException {
        String s = "INSERT INTO " + getTablename() + " (UNnr, stoffname, merkblattnr, radius_innen, radius_außen, info) VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, t.getUNnr());
        stmt.setString(2, t.getStoffname());
        stmt.setInt(3, t.getMerkblattnr());
        stmt.setInt(4, t.getRadius_innen());
        stmt.setInt(5, t.getRadius_außen());
        stmt.setString(6, t.getInfo());
        return stmt;
    }
}
