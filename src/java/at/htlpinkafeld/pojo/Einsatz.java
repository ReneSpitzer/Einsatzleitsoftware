/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.pojo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Bernhard
 */
public class Einsatz {
    private int eid;
    private String eort;
    private String estraße;
    private String hausnr;
    private String aufgabe;
    private String eleiter;
    private int enr;
    private String emittel;
    private Date uhrzeit;
    private String e_status;
    
    public Einsatz(){}

    public Einsatz(int eid, String eort, String estraße, String hausnr, String aufgabe, String eleiter, int enr, String emittel, Date uhrzeit, String e_status) {
        this.eid = eid;
        this.eort = eort;
        this.estraße = estraße;
        this.hausnr = hausnr;
        this.aufgabe = aufgabe;
        this.eleiter = eleiter;
        this.enr = enr;
        this.emittel = emittel;
        this.uhrzeit = uhrzeit;
        this.e_status = e_status;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEort() {
        return eort;
    }

    public void setEort(String eort) {
        this.eort = eort;
    }

    public String getEstraße() {
        return estraße;
    }

    public void setEstraße(String estraße) {
        this.estraße = estraße;
    }

    public String getHausnr() {
        return hausnr;
    }

    public void setHausnr(String hausnr) {
        this.hausnr = hausnr;
    }

    public String getAufgabe() {
        return aufgabe;
    }

    public void setAufgabe(String aufgabe) {
        this.aufgabe = aufgabe;
    }

    public String getEleiter() {
        return eleiter;
    }

    public void setEleiter(String eleiter) {
        this.eleiter = eleiter;
    }

    public int getEnr() {
        return enr;
    }

    public void setEnr(int enr) {
        this.enr = enr;
    }

    public String getEmittel() {
        return emittel;
    }

    public void setEmittel(String emittel) {
        this.emittel = emittel;
    }

    public Date getUhrzeit() {
        return uhrzeit;
    }

    public void setUhrzeit(Date uhrzeit) {
        this.uhrzeit = uhrzeit;
    }

    public String getE_status() {
        return e_status;
    }

    public void setE_status(String e_status) {
        this.e_status = e_status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.eid;
        hash = 59 * hash + Objects.hashCode(this.eort);
        hash = 59 * hash + Objects.hashCode(this.estraße);
        hash = 59 * hash + Objects.hashCode(this.hausnr);
        hash = 59 * hash + Objects.hashCode(this.aufgabe);
        hash = 59 * hash + Objects.hashCode(this.eleiter);
        hash = 59 * hash + this.enr;
        hash = 59 * hash + Objects.hashCode(this.emittel);
        hash = 59 * hash + Objects.hashCode(this.uhrzeit);
        hash = 59 * hash + Objects.hashCode(this.e_status);
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
        final Einsatz other = (Einsatz) obj;
        if (this.eid != other.eid) {
            return false;
        }
        if (this.enr != other.enr) {
            return false;
        }
        if (!Objects.equals(this.eort, other.eort)) {
            return false;
        }
        if (!Objects.equals(this.estraße, other.estraße)) {
            return false;
        }
        if (!Objects.equals(this.hausnr, other.hausnr)) {
            return false;
        }
        if (!Objects.equals(this.aufgabe, other.aufgabe)) {
            return false;
        }
        if (!Objects.equals(this.eleiter, other.eleiter)) {
            return false;
        }
        if (!Objects.equals(this.emittel, other.emittel)) {
            return false;
        }
        if (!Objects.equals(this.e_status, other.e_status)) {
            return false;
        }
        if (!Objects.equals(this.uhrzeit, other.uhrzeit)) {
            return false;
        }
        return true;
    }
    
    
}
