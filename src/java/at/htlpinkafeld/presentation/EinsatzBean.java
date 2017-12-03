/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Einsatz;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bernhard
 */
public class EinsatzBean {
    private List<Einsatz> oelist = new ArrayList<Einsatz>(); //Liste der offenen Einsätzen
    private List<Einsatz> eialist = new ArrayList<Einsatz>(); //Liste der Einsätzen in Arbeit
    private List<Einsatz> aelist = new ArrayList<Einsatz>(); //Liste der abgeschlossenen Einsätzen
    
    public EinsatzBean() {
        oelist.add(new Einsatz(1,"Pinkafeld", "Meierhofplatz", "1", "Brand löschen", 
                "Fuchs", 1, "LFZ01", "13:05", "25.11.2017", "offen"));
        oelist.add(new Einsatz(1,"Oberwart", "Eo", "7", "Hochwasser", 
                "Prunner", 2, "LFZ02", "14:06", "20.11.2017", "offen"));
        eialist.add(new Einsatz(1,"Pinkafeld", "Meierhofplatz", "1", "Brand löschen", 
                "Fuchs", 3, "LFZ01", "13:05", "25.11.2017", "in Arbeit"));
        eialist.add(new Einsatz(1,"Oberwart", "Eo", "7", "Hochwasser", 
                "Prunner", 4, "LFZ02", "14:06", "20.11.2017", "offen"));
        aelist.add(new Einsatz(1,"Güssing", "gu", "1a", "Lkw Unfall ", 
                "Spitzer", 1, "LFZ04", "13:05", "27.8.2017", "abgeschlossen"));
        aelist.add(new Einsatz(1,"Pinkafeld", "Meierhofplatz", "1", "Brand löschen", 
                "Spitzer", 1, "LFZ06", "13:05", "25.11.2017", "abgeschlossen"));               
    }

    public List<Einsatz> getOelist() {
        return oelist;
    }

    public void setOelist(List<Einsatz> oelist) {
        this.oelist = oelist;
    }

    public List<Einsatz> getEialist() {
        return eialist;
    }

    public void setEialist(List<Einsatz> eialist) {
        this.eialist = eialist;
    }

    public List<Einsatz> getAelist() {
        return aelist;
    }

    public void setAelist(List<Einsatz> aelist) {
        this.aelist = aelist;
    }
}
