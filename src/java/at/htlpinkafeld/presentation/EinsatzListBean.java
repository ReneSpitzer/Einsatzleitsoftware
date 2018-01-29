/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Einsatz;
import at.htlpinkafeld.pojo.Fahrzeuge;
import at.htlpinkafeld.pojo.Ort;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author Bernhard
 */
@ManagedBean
@SessionScoped
public class EinsatzListBean {
    private List<Einsatz> einsatzlist = new ArrayList<>(); //Liste von allen Einsätzen
    private List<Einsatz> oelist = new ArrayList<>(); //Liste der offenen Einsätzen
    private List<Einsatz> eialist = new ArrayList<>(); //Liste der Einsätzen in Arbeit
    private List<Einsatz> aelist = new ArrayList<>(); //Liste der abgeschlossenen Einsätzen
    private List<Einsatz> arelist = new ArrayList<>(); //Liste der archivierten Einsätzen
    private List<Fahrzeuge> flist = new LinkedList<>(); //Liste aller Fahrzeugen
    private List<Fahrzeuge> fplist = new LinkedList<>(); //Liste aller Fahrzeugen von Pinkafeld
    private List<Fahrzeuge> felist = new LinkedList<>(); //Liste aller Fahrzeuge die tatsächlich angezeigt werden
    private Fahrzeuge fahrzeug = new Fahrzeuge();
    private List<String> statuslist = new ArrayList<>();
    private List<String> stautslistarchiviert = new ArrayList<>();
    private List<String> selectedortlist = new ArrayList<>();
    
    public EinsatzListBean() {
        einsatzlist.add(new Einsatz(1,"Pinkafeld", "Meierhofplatz", "1", "Brand löschen", 
                "Fuchs", 1, "LFZ01", "13:05", "25.11.2017", "offen",1));
        
        einsatzlist.add(new Einsatz(2,"Oberwart", "Eo", "7", "Hochwasser", 
                "Prunner", 2, "LFZ02", "14:06", "20.11.2017", "offen", 1));
        
        einsatzlist.add(new Einsatz(3,"Hartberg", "Roseggergasse", "2", "Katze von Baum retten", 
                "Altmann", 3, "LFZ03", "12:06", "20.1.2018", "in Arbeit", 1));
        
        einsatzlist.add(new Einsatz(4,"Test", "Testgasse", "7", "Hochwasser", 
                "Maierhofer", 4, "LFZ04", "4:27", "2.11.2017", "in Arbeit", 1));
        
        einsatzlist.add(new Einsatz(5,"Güssing", "gu", "1a", "Lkw Unfall ", 
                "Fleck", 5, "LFZ05", "13:05", "27.8.2017", "abgeschlossen", 1));
        
        einsatzlist.add(new Einsatz(6,"Oberloisdorf", "McStrasse", "15", "Brand löschen", 
                "Spitzer", 6, "LFZ06", "15:03", "25.10.2017", "abgeschlossen", 1));
        
        flist.add(new Fahrzeuge(1, "", "Pinkafeld", "FZ1", 10, 0, "LFZPkfd", 1));
        flist.add(new Fahrzeuge(2, "", "Test", "FZ2", 2, 0, "LFZHb", 1));
        
        statuslist.add("offen");
        statuslist.add("in Arbeit");
        statuslist.add("abgeschlossen");
        
        stautslistarchiviert.add("abgeschlossen");
        stautslistarchiviert.add("archiviert");
        
        selectedortlist.add(new String("Pinkafeld"));
        selectedortlist.add(new String("Alle"));
        
        fillOelist();
        fillAelist();
        fillEialist();
        fillARelist();
        fillFPlist();
        
        this.setFelist(this.fplist);
    }

    public List<String> getStautslistarchiviert() {
        return stautslistarchiviert;
    }

    public void setStautslistarchiviert(List<String> stautslistarchiviert) {
        this.stautslistarchiviert = stautslistarchiviert;
    }

    public List<Fahrzeuge> getFelist() {
        return felist;
    }

    public void setFelist(List<Fahrzeuge> felist) {
        this.felist = felist;
    }
    
    public List<Einsatz> getArelist() {
        return arelist;
    }

    public void setArelist(List<Einsatz> arelist) {
        this.arelist = arelist;
    }

    public List<Fahrzeuge> getFplist() {
        return fplist;
    }

    public void setFplist(List<Fahrzeuge> fplist) {
        this.fplist = fplist;
    }

    public List<String> getSelectedortlist() {
        return selectedortlist;
    }

    public void setSelectedortlist(List<String> selectedortlist) {
        this.selectedortlist = selectedortlist;
    }
    
    public List<Einsatz> getEinsatzlist() {
        return einsatzlist;
    }

    public void setEinsatzlist(List<Einsatz> einsatzlist) {
        this.einsatzlist = einsatzlist;
    }

    public List<Einsatz> getARelist() {
        return arelist;
    }

    public void setARelist(List<Einsatz> arelist) {
        this.arelist = arelist;
    }

    public List<String> getStatuslist() {
        return statuslist;
    }

    public void setStatuslist(List<String> statuslist) {
        this.statuslist = statuslist;
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

    public void setFPlist(List<Fahrzeuge> fplist) {
        this.fplist = fplist;
    }
    
    public List<Fahrzeuge> getFPlist() {
        return this.fplist;
    }
    
    public Fahrzeuge getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeuge fahrzeug) {
        this.fahrzeug = fahrzeug;
    }
    
    
    public void fillFPlist()
    {
        this.getFPlist().removeAll(fplist);
        for(Fahrzeuge f: this.getFlist())
        {
            if(f.getOrt().equals("Pinkafeld")){
                fplist.add(f);
            }
        }
    }

    private void fillOelist(){
        this.getOelist().removeAll(oelist);
        for(Einsatz e: this.getEinsatzlist())
        {
            if(e.getE_status().equals("offen")){
                if(!this.getOelist().contains(e))
                    oelist.add(e);
            }
        }
    }

    private void fillEialist() {
        this.getEialist().removeAll(eialist);
        for(Einsatz e: this.getEinsatzlist())
        {
            if(e.getE_status().equals("in Arbeit")){
                if(!this.getEialist().contains(e))
                eialist.add(e);
            }
        }    
    }

    private void fillAelist() {
        this.getAelist().removeAll(aelist);
        for(Einsatz e: this.getEinsatzlist())
        {
            if(e.getE_status().equals("abgeschlossen")){
                if(!this.getAelist().contains(e))
                aelist.add(e);
            }
        }
    }
    
    private void fillARelist() {
        this.getARelist().removeAll(arelist);
        for(Einsatz e: this.getEinsatzlist())
        {
            if(e.getE_status().equals("archiviert")){
                if(!this.getARelist().contains(e))
                arelist.add(e);
            }
        }
    }
    
    public Object changeToIA(Einsatz e)
    {
        Einsatz help = e;
        this.getEinsatzlist().remove(e);
        help.setE_status("in Arbeit");
        this.getEinsatzlist().add(help);
        
        fillEialist();
        fillOelist();
        fillAelist();
        fillARelist();
        
        return null;
    }
    
    public Object changeToAbgeschlossen(Einsatz e)
    {
        Einsatz help = e;
        this.getEinsatzlist().remove(e);
        help.setE_status("abgeschlossen");
        this.getEinsatzlist().add(help);
        
        fillOelist();
        fillEialist();
        fillAelist();
        fillARelist();
        
        return null;
    } 
    
    public Object changeToArchiviert(Einsatz e)
    {
        Einsatz help = e;
        this.getEinsatzlist().remove(e);
        help.setE_status("archiviert");
        this.getEinsatzlist().add(help);
        
        fillOelist();
        fillEialist();
        fillAelist();
        fillARelist();
        
        return null;
    }
    
    public String save(Einsatz e){
        if( !einsatzlist.contains(e) ){
            einsatzlist.add(e);
        
        fillEialist();
        fillOelist();
        fillAelist();
        fillARelist();
        }
        
        return "grundmodul.xhtml";
    }
    /*
     public String bearbeiten(Einsatz e){
        if( !einsatzlist.contains(e) )
            einsatzlist.add(e);
        
        fillEialist();
        fillOelist();
        fillAelist();
        fillARelist();
        
        return "/ueberischtauswahl.xhtml";
    }
     */
    public void changedSmth(ValueChangeEvent e)
    {
        String s = (String) e.getNewValue();
        
        if(s.equals("Pinkafeld"))
        {
            this.setFelist(this.fplist);
        }
        
        if(s.equals("Alle"))
        {
            this.setFelist(this.flist);
        }
    }
}
