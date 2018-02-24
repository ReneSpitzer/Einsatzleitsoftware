/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.pojo;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Bernhard Fuchs
 */
public class Zeitaufzeichnung implements Identifiable{
    private int zid;
    private Date aenderungszeitpunkt;
    private String aenderung;
    private int eid;
    private Einsatz einsatz;
    private int bid;
    private Benutzer benutzer;

    public Zeitaufzeichnung(){
    }
    
    public Zeitaufzeichnung(Date aenderungszeitpunkt, String aenderung, int eid, int bid) {
        this.aenderungszeitpunkt = aenderungszeitpunkt;
        this.aenderung = aenderung;
        this.eid = eid;
        this.bid = bid;
    }
    
    public Zeitaufzeichnung(int zid, Date aenderungszeitpunkt, String aenderung, int eid, int bid) {
        this.zid = zid;
        this.aenderungszeitpunkt = aenderungszeitpunkt;
        this.aenderung = aenderung;
        this.eid = eid;
        this.bid = bid;
    }
    
    @Override
    public void setId(int id) {
        this.zid = id;
    }

    @Override
    public int getId() {
        return zid;
    }

    public Date getAenderungszeitpunkt() {
        return aenderungszeitpunkt;
    }

    public void setAenderungszeitpunkt(Date aenderungszeitpunkt) {
        this.aenderungszeitpunkt = aenderungszeitpunkt;
    }

    public String getAenderung() {
        return aenderung;
    }

    public void setAenderung(String aenderung) {
        this.aenderung = aenderung;
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

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.zid;
        hash = 89 * hash + Objects.hashCode(this.aenderungszeitpunkt);
        hash = 89 * hash + Objects.hashCode(this.aenderung);
        hash = 89 * hash + this.eid;
        hash = 89 * hash + Objects.hashCode(this.einsatz);
        hash = 89 * hash + this.bid;
        hash = 89 * hash + Objects.hashCode(this.benutzer);
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
        final Zeitaufzeichnung other = (Zeitaufzeichnung) obj;
        if (this.zid != other.zid) {
            return false;
        }
        if (this.eid != other.eid) {
            return false;
        }
        if (this.bid != other.bid) {
            return false;
        }
        if (!Objects.equals(this.aenderung, other.aenderung)) {
            return false;
        }
        if (!Objects.equals(this.aenderungszeitpunkt, other.aenderungszeitpunkt)) {
            return false;
        }
        if (!Objects.equals(this.einsatz, other.einsatz)) {
            return false;
        }
        if (!Objects.equals(this.benutzer, other.benutzer)) {
            return false;
        }
        return true;
    }
}
