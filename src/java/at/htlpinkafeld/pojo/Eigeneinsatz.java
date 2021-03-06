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
public class Eigeneinsatz implements Identifiable{
    private int eeid;
    private String absender;
    private String empfaenger;
    private String zusatztext;
    private int eid;
    private Einsatz einsatz;

    public Eigeneinsatz() {
    }

    public Eigeneinsatz(int eeid, String absender, String empfaenger, String zusatztext,String gradn, String grads, String eort, String estraße, String hausnr, String aufgabe, String eleiter, int enr, String emittel, String uhrzeit, String datum, String e_status, int bid ,int eid) {
        this.eeid = eeid;
        this.absender = absender;
        this.empfaenger = empfaenger;
        this.zusatztext = zusatztext;
        this.eid = eid;
        einsatz = new Einsatz( eid,  eort,  estraße,  hausnr,  aufgabe,  eleiter, enr,  emittel,  uhrzeit,  datum,  e_status, bid);
    }
    
    public Eigeneinsatz(String absender, String empfaenger, String zusatztext, int eid) {
        this.absender = absender;
        this.empfaenger = empfaenger;
        this.zusatztext = zusatztext;
        this.eid = eid;
    }

    @Override
    public int getId() {
        return eeid;
    }

    @Override
    public void setId(int id) {
        this.eeid = id;
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

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public Einsatz getEinsatz() {
        return einsatz;
    }

    public void setEinsatz(Einsatz einsatz) {
        this.einsatz = einsatz;
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
