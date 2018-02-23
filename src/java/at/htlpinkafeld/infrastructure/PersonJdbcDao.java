/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.infrastructure;

import at.htlpinkafeld.pojo.Person;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bernhard
 */
public class PersonJdbcDao extends BaseJdbcDao<Person> implements Dao<Person> {

    public PersonJdbcDao(String tablename, String pKey) {
        super(tablename, pKey);
    }

    @Override
    protected Person getPojoFromResultSet(ResultSet result) throws SQLException {
        Person p = new Person(result.getString("vorname"), result.getString("nachname"), result.getDate("gebDat"),
        result.getString("str"), result.getString("hausnr"), result.getString("grad"), result.getString("email"), 
        result.getInt("telnr"), result.getInt("kid"));
        p.setId(result.getInt(this.getPkName()));
        return p;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Person t) throws SQLException {
        String s = "UPDATE " + getTablename() + "vorname=?, nachname=?, gebDat=?, str=?, hausnr=?, grad=?, email=?, telnr=?, kid=? WHERE " + getPkName() + "=?";
        PreparedStatement stmt = c.prepareStatement(s);
        stmt.setString(1, t.getVorname());
        stmt.setString(2, t.getNachname());
        stmt.setDate(3, (Date) t.getGebDat());
        stmt.setString(4, t.getStr());
        stmt.setString(5, t.getHausnr());
        stmt.setString(6, t.getGrad());
        stmt.setString(7, t.getEmail());
        stmt.setInt(8, t.getTelnr());
        stmt.setInt(9, t.getKid());
        stmt.setInt(10, t.getId());
        return stmt;

    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Person t) throws SQLException {
        String s = "INSERT INTO " + getTablename() + " (vorname, nachname, gebDat, str, hausnr, grad, email, telnr, eid) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
         stmt.setString(1, t.getVorname());
        stmt.setString(2, t.getNachname());
        stmt.setDate(3, (Date) t.getGebDat());
        stmt.setString(4, t.getStr());
        stmt.setString(5, t.getHausnr());
        stmt.setString(6, t.getGrad());
        stmt.setString(7, t.getEmail());
        stmt.setInt(8, t.getTelnr());
        stmt.setInt(9, t.getKid());
        return stmt;
    }
}
