/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.infrastructure;

import at.htlpinkafeld.pojo.Einsatz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bernhard
 */
public class EinsatzJdbcDao extends BaseJdbcDao<Einsatz> implements Dao<Einsatz> {

    public EinsatzJdbcDao(String tablename, String pKey) {
        super(tablename, pKey);
    }

    @Override
    protected Einsatz getPojoFromResultSet(ResultSet result) throws SQLException {
        Einsatz e = new Einsatz(result.getString("eort"), result.getString("estraße"), result.getString("hausnr"),
        result.getString("aufgabe"), result.getString("eleiter"), result.getInt("enr"), result.getString("emittel"), 
        result.getString("uhrzeit"), result.getString("datum"), result.getString("e_status"));
        e.setId(result.getInt(this.getPkName()));
        return e;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Einsatz t) throws SQLException {
        String s = "UPDATE " + getTablename() + " SET eort=?, estraße=?, hausnr=?, aufgabe=?, eleiter=?, enr=?, emittel=?, uhrzeit=?, datum=?, e_status=? WHERE " + getPkName() + "=?";
        PreparedStatement stmt = c.prepareStatement(s);
        stmt.setString(1, t.getEort());
        stmt.setString(2, t.getEstraße());
        stmt.setString(3, t.getHausnr());
        stmt.setString(4, t.getAufgabe());
        stmt.setString(5, t.getEleiter());
        stmt.setInt(6, t.getEnr());
        stmt.setString(7, t.getEmittel());
        stmt.setString(8, t.getUhrzeit());
        stmt.setString(9, t.getDatum());
        stmt.setString(10, t.getE_status());
        stmt.setInt(11, t.getId());
        return stmt;

    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Einsatz t) throws SQLException {
        String s = "INSERT INTO " + getTablename() + " (eort, estraße, hausnr, aufgabe, eleiter, enr, emittel, uhrzeit, datum, e_status) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, t.getEort());
        stmt.setString(2, t.getEstraße());
        stmt.setString(3, t.getHausnr());
        stmt.setString(4, t.getAufgabe());
        stmt.setString(5, t.getEleiter());
        stmt.setInt(6, t.getEnr());
        stmt.setString(7, t.getEmittel());
        stmt.setString(8, t.getUhrzeit());
        stmt.setString(9, t.getDatum());
        stmt.setString(10, t.getE_status());
        return stmt;
    }
}