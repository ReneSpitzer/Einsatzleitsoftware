/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Einsatz;
import at.htlpinkafeld.pojo.Fahrzeug;
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
    private List<Fahrzeug> flist = new LinkedList<>(); //Liste aller Fahrzeugen
    private List<Ort> ortlist = new ArrayList();
    private List<Fahrzeug> felist = new LinkedList<>(); //Liste mit den tatsächlich angezeigten Fahrzeugen
    private Fahrzeug fahrzeug = new Fahrzeug();
    
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
        flist.add(new Fahrzeug(1, "", "Pinkafeld", "FZ1", 10, 0, "FZ1"));
        flist.add(new Fahrzeug(2, "", "Oberwart", "FZ2", 2, 0, "FZ2"));
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

    public List<Fahrzeug> getFlist() {
        return flist;
    }

    public void setFlist(List<Fahrzeug> flist) {
        this.flist = flist;
    }
    
    public List<Fahrzeug> getFPlist() {
        List<Fahrzeug> fplist = new LinkedList<>();
        
        for(Fahrzeug f: flist)
        {
            if(f.getOrt().equals("Pinkafeld")){
                fplist.add(f);
            }
        }
        
        return fplist;
    }

    public void setFPlist(List<Fahrzeug> flist) {
        this.flist = flist;
    }

    public List<Ort> getOrtlist() {
        return ortlist;
    }

    public void setOrtlist(List<Ort> ortlist) {
        this.ortlist = ortlist;
    }

    public List<Fahrzeug> getFelist() {
        return felist;
    }

    public void setFelist(List<Fahrzeug> felist) {
        this.felist = felist;
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug) {
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
