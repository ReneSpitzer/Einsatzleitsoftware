/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.infrastructure;

import at.htlpinkafeld.pojo.Funkgeraet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bernhard
 */
public class FunkgeraetJdbcDao extends BaseJdbcDao<Funkgeraet> implements Dao<Funkgeraet> {

    public FunkgeraetJdbcDao(String tablename, String pKey) {
        super(tablename, pKey);
    }

    @Override
    protected Funkgeraet getPojoFromResultSet(ResultSet result) throws SQLException {
        Funkgeraet f = new Funkgeraet(result.getString("bez"), result.getInt("nr"), result.getInt("fid"), result.getInt("kid"));
        f.setId(result.getInt(this.getPkName()));
        return f;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Funkgeraet t) throws SQLException {
        String s = "UPDATE " + getTablename() + " SET bez=?, nr=?, fid=?, kid=? WHERE " + getPkName() + "=?";
        PreparedStatement stmt = c.prepareStatement(s);
        stmt.setString(1, t.getBez());
        stmt.setInt(2, t.getNr());
        stmt.setInt(3, t.getFid());
        stmt.setInt(4, t.getKid());
        stmt.setInt(5, t.getId());
        return stmt;

    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Funkgeraet t) throws SQLException {
        String s = "INSERT INTO " + getTablename() + " (bez, nr, fid, kid) VALUES (?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, t.getBez());
        stmt.setInt(2, t.getNr());
        return stmt;
    }
}
