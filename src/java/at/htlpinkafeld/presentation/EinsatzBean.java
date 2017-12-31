/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Einsatz;
import at.htlpinkafeld.pojo.Fahrzeuge;
import at.htlpinkafeld.pojo.Ort;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Bernhard
 */
public class EinsatzBean {
    private List<Einsatz> oelist = new ArrayList<>(); //Liste der offenen Einsätzen
    private List<Einsatz> eialist = new ArrayList<>(); //Liste der Einsätzen in Arbeit
    private List<Einsatz> aelist = new ArrayList<>(); //Liste der abgeschlossenen Einsätzen
    private List<Fahrzeuge> flist = new LinkedList<>(); //Liste aller Fahrzeugen
    private List<Ort> ortlist = new ArrayList();
    private List<Fahrzeuge> felist = new LinkedList<>(); //Liste mit den tatsächlich angezeigten Fahrzeugen
    private Fahrzeuge fahrzeug = new Fahrzeuge();
    
    public EinsatzBean() {
        oelist.add(new Einsatz(1,"Pinkafeld", "Meierhofplatz", "1", "Brand löschen", 
                "Fuchs", 1, "LFZ01", "13:05", "25.11.2017", "offen",1));
        oelist.add(new Einsatz(1,"Oberwart", "Eo", "7", "Hochwasser", 
                "Prunner", 2, "LFZ02", "14:06", "20.11.2017", "offen", 1));
        eialist.add(new Einsatz(1,"Pinkafeld", "Meierhofplatz", "1", "Brand löschen", 
                "Fuchs", 3, "LFZ01", "13:05", "25.11.2017", "in Arbeit", 1));
        eialist.add(new Einsatz(1,"Oberwart", "Eo", "7", "Hochwasser", 
                "Prunner", 4, "LFZ02", "14:06", "20.11.2017", "offen", 1));
        aelist.add(new Einsatz(1,"Güssing", "gu", "1a", "Lkw Unfall ", 
                "Spitzer", 1, "LFZ04", "13:05", "27.8.2017", "abgeschlossen", 1));
        aelist.add(new Einsatz(1,"Pinkafeld", "Meierhofplatz", "1", "Brand löschen", 
                "Spitzer", 1, "LFZ06", "13:05", "25.11.2017", "abgeschlossen", 1));
        flist.add(new Fahrzeuge(1, "", "Pinkafeld", "FZ1", 10, 0, "FZ1", 1));
        flist.add(new Fahrzeuge(2, "", "Oberwart", "FZ2", 2, 0, "FZ2", 1));
        ortlist.add(new Ort(1,"Pinkafeld"));
        ortlist.add(new Ort(2,"Alle"));
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

    public List<Fahrzeuge> getFlist() {
        return flist;
    }

    public void setFlist(List<Fahrzeuge> flist) {
        this.flist = flist;
    }
    
    public List<Fahrzeuge> getFPlist() {
        List<Fahrzeuge> fplist = new LinkedList<>();
        
        for(Fahrzeuge f: flist)
        {
            if(f.getOrt().equals("Pinkafeld")){
                fplist.add(f);
            }
        }
        
        return fplist;
    }

    public void setFPlist(List<Fahrzeuge> flist) {
        this.flist = flist;
    }

    public List<Ort> getOrtlist() {
        return ortlist;
    }

    public void setOrtlist(List<Ort> ortlist) {
        this.ortlist = ortlist;
    }

    public List<Fahrzeuge> getFelist() {
        return felist;
    }

    public void setFelist(List<Fahrzeuge> felist) {
        this.felist = felist;
    }

    public Fahrzeuge getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeuge fahrzeug) {
        this.fahrzeug = fahrzeug;
    }
    
    public Object changedSmth(ValueChangeEvent e){
       String s = (String) e.getNewValue();
        
        if(s.equals("Pinkafeld")){
            this.setFelist(this.getFPlist());
        }else{
            this.setFelist(this.getFlist());
        } 
        
        return null;
    }
}
