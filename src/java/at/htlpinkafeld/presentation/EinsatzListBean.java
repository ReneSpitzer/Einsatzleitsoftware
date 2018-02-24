/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Einsatz;
import at.htlpinkafeld.pojo.Fahrzeuge;
import at.htlpinkafeld.service.EinsatzleitsoftwareService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
      @ManagedProperty(value="#{einsatzleitsoftwareService}")
     EinsatzleitsoftwareService einsatzleitsoftwares;
      
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
     
  
         
    }
    
    @PostConstruct
    public void SetUp(){
      this.einsatzlist=this.einsatzleitsoftwares.getEinsatzlist();
      this.oelist=this.einsatzleitsoftwares.getOelist();
      this.eialist=this.einsatzleitsoftwares.getEialist();
      this.aelist=this.einsatzleitsoftwares.getAelist();
      this.arelist=this.einsatzleitsoftwares.getArelist();
      this.flist=this.einsatzleitsoftwares.getFlist();
      this.fplist=this.einsatzleitsoftwares.getFplist();
      this.felist=this.einsatzleitsoftwares.getFelist();
      this.statuslist=this.einsatzleitsoftwares.getStatuslist();
      this.stautslistarchiviert=this.einsatzleitsoftwares.getStautslistarchiviert();
      this.selectedortlist=this.einsatzleitsoftwares.getSelectedortlist();
      
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
        }
        
        fillEialist();
        fillOelist();
        fillAelist();
        fillARelist();       
        
        return "grundmodul.xhtml";
    }
    
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

    public EinsatzleitsoftwareService getEinsatzleitsoftwares() {
        return einsatzleitsoftwares;
    }

    public void setEinsatzleitsoftwares(EinsatzleitsoftwareService einsatzleitsoftwares) {
        this.einsatzleitsoftwares = einsatzleitsoftwares;
    }
    
}
