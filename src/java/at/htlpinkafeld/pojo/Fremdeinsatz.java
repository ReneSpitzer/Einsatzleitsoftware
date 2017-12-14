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
public class Fremdeinsatz implements Identifiable{
    private int frid;
    private String absender;
    private String empfaenger;
    
    public Fremdeinsatz(){}

    public Fremdeinsatz(String absender, String empfaenger) {
        this.absender = absender;
        this.empfaenger = empfaenger;
    }
    
    public Fremdeinsatz(int frid, String absender, String empfaenger) {
        this.frid = frid;
        this.absender = absender;
        this.empfaenger = empfaenger;
    }

    @Override
    public int getId() {
        return frid;
    }

    @Override
    public void setId(int id) {
        this.frid = frid;
    }

    public String getAbsender() {
        return absender;
    }

    public void setAbsender(String absender) {
        this.absender = absender;
    }

    public String getEmpfaenger() {
        return empfaenger;
    }

    public void setEmpfaenger(String empfaenger) {
        this.empfaenger = empfaenger;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.frid;
        hash = 67 * hash + Objects.hashCode(this.absender);
        hash = 67 * hash + Objects.hashCode(this.empfaenger);
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
        final Fremdeinsatz other = (Fremdeinsatz) obj;
        if (this.frid != other.frid) {
            return false;
        }
        if (!Objects.equals(this.absender, other.absender)) {
            return false;
        }
        if (!Objects.equals(this.empfaenger, other.empfaenger)) {
            return false;
        }
        return true;
    }
}
