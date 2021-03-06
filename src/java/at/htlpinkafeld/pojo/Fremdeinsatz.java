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
    private int eid;
    private Einsatz einsatz;
    private String text;
    private boolean status;
    private String gradSüdKomm;
    private String gradNordKomm;

    public Fremdeinsatz(int frid, String absender, String empfaenger, int eid, Einsatz einsatz, String text) {
        this.frid = frid;
        this.absender = absender;
        this.empfaenger = empfaenger;
        this.eid = eid;
        this.einsatz = einsatz;
        this.text = text;
        this.status=false;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean Status) {
        this.status = Status;
    }

    public String getGradSüdKomm() {
        return gradSüdKomm;
    }

    public void setGradSüdKomm(String gradSüdKomm) {
        this.gradSüdKomm = gradSüdKomm;
    }

    public String getGradNordKomm() {
        return gradNordKomm;
    }

    public void setGradNordKomm(String gradNordKomm) {
        this.gradNordKomm = gradNordKomm;
    }

    
    
    public int getFrid() {
        return frid;
    }

    public void setFrid(int frid) {
        this.frid = frid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public Fremdeinsatz(){}

    public Fremdeinsatz(String absender, String empfaenger, int eid) {
        this.absender = absender;
        this.empfaenger = empfaenger;
        this.eid = eid;
    }
    
    public Fremdeinsatz(int frid, String absender, String empfaenger, int eid) {
        this.frid = frid;
        this.absender = absender;
        this.empfaenger = empfaenger;
        this.eid = eid;
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
