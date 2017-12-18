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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Bernhard
 */
@ManagedBean
@SessionScoped
public class EinsatzBean {
    private Einsatz einsatz;
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
    public Object createEinsatz(){
        einsatz.setEid(2);
        if(einsatz.getE_status().equals("offen")){
            this.oelist.add(einsatz);
        }
         if(einsatz.getE_status().equals("in Arbeit")){
             this.eialist.add(einsatz);
            
         }
          if(einsatz.getE_status().equals("abgeschlossen")){
              this.aelist.add(einsatz);
          }
          return "/grundmodul.xhtml";
    }
    public Einsatz getEinsatz() {
        return einsatz;
    }

    public void setEinsatz(Einsatz einsatz) {
        this.einsatz = einsatz;
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
