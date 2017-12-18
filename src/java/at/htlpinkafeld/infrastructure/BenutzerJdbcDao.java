/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.infrastructure;

import at.htlpinkafeld.pojo.Benutzer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bernhard
 */
public class BenutzerJdbcDao extends BaseJdbcDao<Benutzer> implements Dao<Benutzer> {

    public BenutzerJdbcDao(String tablename, String pKey) {
        super(tablename, pKey);
    }

    @Override
    protected Benutzer getPojoFromResultSet(ResultSet result) throws SQLException {
        Benutzer b = new Benutzer(result.getString("username"), result.getBoolean("admin"), result.getString("password"));
        b.setId(result.getInt(this.getPkName()));
        return b;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Benutzer t) throws SQLException {
        String s = "UPDATE " + getTablename() + " SET username=?, admin=?, password=? WHERE " + getPkName() + "=?";
        PreparedStatement stmt = c.prepareStatement(s);
        stmt.setString(1, t.getUsername());
        stmt.setBoolean(2, t.isAdmin());
        stmt.setString(3, t.getPassword());
        stmt.setInt(4, t.getId());
        return stmt;

    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Benutzer t) throws SQLException {
        String s = "INSERT INTO " + getTablename() + " (username, admin, password) VALUES (?,?,?)";
        PreparedStatement stmt = c.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, t.getUsername());
        stmt.setBoolean(2, t.isAdmin());
        stmt.setString(3, t.getPassword());
        return stmt;
    }
}