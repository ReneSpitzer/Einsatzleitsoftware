/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.infrastructure;

import at.htlpinkafeld.pojo.Kontakt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bernhard
 */
public class KontaktJdbcDao extends BaseJdbcDao<Kontakt> implements Dao<Kontakt> {

    public KontaktJdbcDao(String tablename, String pKey) {
        super(tablename, pKey);
    }

    @Override
    protected Kontakt getPojoFromResultSet(ResultSet result) throws SQLException {
        Kontakt k = new Kontakt(result.getString("kname"), result.getString("bez"), result.getLong("funknr"), result.getInt("eid"));
        k.setId(result.getInt(this.getPkName()));
        return k;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Kontakt t) throws SQLException {
        String s = "UPDATE " + getTablename() + " SET kname=?, bez=?, funknr=?, eid=? WHERE " + getPkName() + "=?";
        PreparedStatement stmt = c.prepareStatement(s);
        stmt.setString(1, t.getKname());
        stmt.setString(2, t.getBez());
        stmt.setLong(3, t.getFunknr());
        stmt.setInt(4, t.getId());
        return stmt;

    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Kontakt t) throws SQLException {
        String s = "INSERT INTO " + getTablename() + " (kname, bez, funknr, eid) VALUES (?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, t.getKname());
        stmt.setString(2, t.getBez());
        stmt.setLong(3, t.getFunknr());
        return stmt;
    }
}
