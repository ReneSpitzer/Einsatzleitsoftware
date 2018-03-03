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
        Counter b = new Counter(result.getInt("cnt"));
        b.setId(result.getInt(this.getPkName()));
        return b;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Counter t) throws SQLException {
        String s = "UPDATE " + getTablename() + " SET cnt=? WHERE " + getPkName() + "=?";
        PreparedStatement stmt = c.prepareStatement(s);
        stmt.setInt(1, t.getCnt());
        stmt.setInt(2, t.getId());
        return stmt;

    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Counter t) throws SQLException {
        String s = "INSERT INTO " + getTablename() + " (cnt) VALUES (?)";
        PreparedStatement stmt = c.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, t.getCnt());
        return stmt;
    }
}
