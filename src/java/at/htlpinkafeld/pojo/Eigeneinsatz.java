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
public class Eigeneinsatz {
    private int eeid;
    private String absender;
    private String empfaenger;
    private String zusatztext;

    public Eigeneinsatz() {
    }

    public Eigeneinsatz(int eeid, String absender, String empfaenger, String zusatztext) {
        this.eeid = eeid;
        this.absender = absender;
        this.empfaenger = empfaenger;
        this.zusatztext = zusatztext;
    }

    public int getEeid() {
        return eeid;
    }

    public void setEeid(int eeid) {
        this.eeid = eeid;
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

    public String getZusatztext() {
        return zusatztext;
    }

    public void setZusatztext(String zusatztext) {
        this.zusatztext = zusatztext;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.eeid;
        hash = 67 * hash + Objects.hashCode(this.absender);
        hash = 67 * hash + Objects.hashCode(this.empfaenger);
        hash = 67 * hash + Objects.hashCode(this.zusatztext);
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
        final Eigeneinsatz other = (Eigeneinsatz) obj;
        if (this.eeid != other.eeid) {
            return false;
        }
        if (!Objects.equals(this.absender, other.absender)) {
            return false;
        }
        if (!Objects.equals(this.empfaenger, other.empfaenger)) {
            return false;
        }
        if (!Objects.equals(this.zusatztext, other.zusatztext)) {
            return false;
        }
        return true;
    }
}
