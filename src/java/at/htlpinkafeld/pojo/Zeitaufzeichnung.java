/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.pojo;

import java.sql.Date;

/**
 *
 * @author Bernhard
 */
public class Zeitaufzeichnung implements Identifiable{
    private int zid;
    private Date aenderungszeitpunkt;
    private String aenderung;
    private int eid;
    private Einsatz einsatz;
    private int bid;
    private Benutzer benutzer;

    public Zeitaufzeichnung(int zid, Date aenderungszeitpunkt, String aenderung, int eid, int bid) {
        this.zid = zid;
        this.aenderungszeitpunkt = aenderungszeitpunkt;
        this.aenderung = aenderung;
        this.eid = eid;
        this.bid = bid;
    }

    public Zeitaufzeichnung(Date aenderungszeitpunkt, String aenderung, int eid, int bid) {
        this.aenderungszeitpunkt = aenderungszeitpunkt;
        this.aenderung = aenderung;
        this.eid = eid;
        this.bid = bid;
    }
    
    @Override
    public void setId(int id) {
        this.zid= id;
    }

    @Override
    public int getId() {
        return this.zid;
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
}
