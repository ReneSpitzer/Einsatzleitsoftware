/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.infrastructure;

import at.htlpinkafeld.pojo.Identifiable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bernhard
 */
public abstract class BaseJdbcDao<T extends Identifiable> {

    private final String TABLENAME;
    private final String PKNAME;

    protected abstract T getPojoFromResultSet(ResultSet result) throws SQLException;

    protected abstract PreparedStatement getUpdateStatement(Connection c, T t) throws SQLException;

    protected abstract PreparedStatement getInsertStatement(Connection c, T t) throws SQLException;

    public BaseJdbcDao(String TABLENAME, String PKNAME) {
        this.TABLENAME = TABLENAME;
        this.PKNAME = PKNAME;
    }

    public String getTABLENAME() {
        return TABLENAME;
    }

    public String getPKNAME() {
        return PKNAME;
    }

    private PreparedStatement getPreparedStatement(Connection c, String sql, int id) throws SQLException {
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public void delete(T t) {
        String sql = "DELETE FROM " + TABLENAME + " WHERE " + PKNAME + " = ?";
        try (Connection wCon = ConnectionManager.getInstance().getConnection();
                PreparedStatement ps = this.getPreparedStatement(wCon, sql, t.getId());) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BaseJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public T read(int id) {
        T t = null;
        String sql = "SELECT * FROM " + TABLENAME + " WHERE " + PKNAME + " = ? LIMIT 1";

        try (Connection wCon = ConnectionManager.getInstance().getConnection();
                PreparedStatement ps = this.getPreparedStatement(wCon, sql, id);
                ResultSet rs = ps.executeQuery();) {
            if (rs.next()) {
                t = this.getPojoFromResultSet(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return t;
    }

    public List<T> list() {
        List<T> results = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLENAME;
        try (Connection wCon = ConnectionManager.getInstance().getConnection();
            Statement st = wCon.createStatement();
            ResultSet result = st.executeQuery(sql)) 
        {

            while (result.next()) {
                results.add(getPojoFromResultSet(result));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }

    public void update(T t) {
        if (t.getId() < 0) {
            return;
        }

        try (Connection wCon = ConnectionManager.getInstance().getConnection();
                PreparedStatement st = getUpdateStatement(wCon, t)) {
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BaseJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create(T t) {
        if (t.getId() >= 0) {
            return;
        }

        try (Connection wCon = ConnectionManager.getInstance().getConnection();
                PreparedStatement st = getInsertStatement(wCon, t);
                ResultSet genKeys = (st.executeUpdate() == 1) ? st.getGeneratedKeys() : null) {

            if (genKeys != null && genKeys.next()) {
                t.setId(genKeys.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
