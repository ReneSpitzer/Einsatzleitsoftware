/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.infrastructure;

import at.htlpinkafeld.pojo.Eigeneinsatz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bernhard
 */
public class EigeneinsatzJdbcDao extends BaseJdbcDao<Eigeneinsatz> implements Dao<Eigeneinsatz> {

    public EigeneinsatzJdbcDao(String tablename, String pKey) {
        super(tablename, pKey);
    }

    @Override
    protected Eigeneinsatz getPojoFromResultSet(ResultSet result) throws SQLException {
        Eigeneinsatz ee = new Eigeneinsatz(result.getString("absender"), result.getString("empfaenger"), result.getString("zusatztext"));
        ee.setId(result.getInt(this.getPkName()));
        return ee;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Eigeneinsatz t) throws SQLException {
        String s = "UPDATE " + getTablename() + " SET absender=?, empfaenger=?, zusatztext=? WHERE " + getPkName() + "=?";
        PreparedStatement stmt = c.prepareStatement(s);
        stmt.setString(1, t.getAbsender());
        stmt.setString(2, t.getEmpfaenger());
        stmt.setString(3, t.getZusatztext());
        stmt.setInt(4, t.getId());
        return stmt;

    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Eigeneinsatz t) throws SQLException {
        String s = "INSERT INTO " + getTablename() + " (absender, empfaenger, zusatztext) VALUES (?,?,?)";
        PreparedStatement stmt = c.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, t.getAbsender());
        stmt.setString(2, t.getEmpfaenger());
        stmt.setString(3, t.getZusatztext());
        return stmt;
    }
}
