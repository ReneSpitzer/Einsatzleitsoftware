/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.pojo;

import java.util.Objects;

/**
 *
 * @author Bernhard
 */
public class Benutzer implements Identifiable{
    private int bid;
    private String username;
    private boolean admin;
    private String password;
    private int pid;
    private Person person;

    public Benutzer() {}
    
    public Benutzer(int bid, String username, boolean admin, String password, int pid) {
        this.bid = bid;
        this.username = username;
        this.admin = admin;
        this.password = password;
        this.pid = pid;
    }
    
    public Benutzer(String username, boolean admin, String password, int pid) {
        this.username = username;
        this.admin = admin;
        this.password = password;
        this.pid = pid;
    }

    @Override
    public void setId(int id) {
        this.bid = id;
    }

    @Override
    public int getId() {
        return this.bid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Benutzer other = (Benutzer) obj;
        if (this.bid != other.bid) {
            return false;
        }
        if (this.admin != other.admin) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Benutzer{" + "bid=" + bid + ", username=" + username + ", admin=" + admin + ", password=" + password + '}';
    }
}
