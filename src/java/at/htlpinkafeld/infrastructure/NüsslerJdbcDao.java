/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.infrastructure;

import at.htlpinkafeld.pojo.Nuessler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bernhard
 */
public class NüsslerJdbcDao extends BaseJdbcDao<Nuessler> implements NüsslerDao {

    public NüsslerJdbcDao(String tablename, String pKey) {
        super(tablename, pKey);
    }

    @Override
    protected Nuessler getPojoFromResultSet(ResultSet result) throws SQLException {
        Nuessler n = new Nuessler(result.getInt("unr"), result.getString("stoffname"), result.getInt("merkblattnr"),
                                 result.getString("info"), result.getInt("aegl21"), result.getInt("aegl22"), result.getDouble("agw"));
        n.setId(result.getInt(this.getPkName()));
        return n;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Nuessler t) throws SQLException {
        String s = "UPDATE " + getTablename() + " SET unnr=?, stoffname=?, merkblattnr=?, info=?, aegl21=?, aegl22=?, agw=?"
                + " WHERE " + getPkName() + "=?";
        PreparedStatement stmt = c.prepareStatement(s);
        stmt.setInt(1, t.getUnnr());
        stmt.setString(2, t.getStoffname());
        stmt.setInt(3, t.getMerkblattnr());
        stmt.setString(4, t.getInfo());
        stmt.setInt(5, t.getAegl21());
        stmt.setInt(6, t.getAegl22());
        stmt.setDouble(7, t.getAgw());
        stmt.setInt(8, t.getId());
        return stmt;

    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Nuessler t) throws SQLException {
        String s = "INSERT INTO " + getTablename() + " (nid, unnr, stoffname, merkblattnr, info, aegl21, aegl22, agw) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, t.getId());
        stmt.setInt(2, t.getUnnr());
        stmt.setString(3, t.getStoffname());
        stmt.setInt(4, t.getMerkblattnr());
        stmt.setString(5, t.getInfo());
        stmt.setInt(6, t.getAegl21());
        stmt.setInt(7, t.getAegl22());
        stmt.setDouble(8, t.getAgw());
        return stmt;
    }
}
