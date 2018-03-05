/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.infrastructure;

import at.htlpinkafeld.pojo.Fremdeinsatz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bernhard
 */
public class FremdeinsatzJdbcDao extends BaseJdbcDao<Fremdeinsatz> implements FremdeinsatzDao {

    public FremdeinsatzJdbcDao(String tablename, String pKey) {
        super(tablename, pKey);
    }

    @Override
    protected Fremdeinsatz getPojoFromResultSet(ResultSet result) throws SQLException {
        Fremdeinsatz fe = new Fremdeinsatz(result.getString("absender"), result.getString("empfaenger"), result.getInt("eid"));
        fe.setId(result.getInt(this.getPkName()));
        return fe;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Fremdeinsatz t) throws SQLException {
        String s = "UPDATE " + getTablename() + " SET absender=?, empfaenger=?, eid=? WHERE " + getPkName() + "=?";
        PreparedStatement stmt = c.prepareStatement(s);
        stmt.setString(1, t.getAbsender());
        stmt.setString(2, t.getEmpfaenger());
        stmt.setInt(3, t.getEid());
        stmt.setInt(4, t.getId());
        return stmt;

    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Fremdeinsatz t) throws SQLException {
        String s = "INSERT INTO " + getTablename() + " (frid, absender, empfaenger, eid) VALUES (?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, t.getId());
        stmt.setString(2, t.getAbsender());
        stmt.setString(3, t.getEmpfaenger());
        stmt.setInt(4, t.getEid());
        return stmt;
    }
}