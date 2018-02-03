/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Einsatz;
import at.htlpinkafeld.pojo.Fremdeinsatz;
import at.htlpinkafeld.pojo.Kontakt;
import at.htlpinkafeld.service.EinsatzleitsoftwareService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rene-_000
 */
@ManagedBean
@SessionScoped
public class KommunikationsBean {
      @ManagedProperty(value="#{einsatzleitsoftwareService}")
     EinsatzleitsoftwareService einsatzleitsoftwares;
      
    Fremdeinsatz fe; 
            List<Fremdeinsatz> PosteingangEinsaetze = new ArrayList();
            List<Fremdeinsatz> ArchiviertePosteingangEinsaetze = new ArrayList();

 
      
    

 
    public KommunikationsBean(){
        
        
    }
    public String EinsatzErstellen(Fremdeinsatz f){
         fe.setStatus(true);
        return"";
    }
    public String EinsatzSenden(){
        
        return "/kommPostausgang.xhtml";
    }
  
    public String getEinsätze(){
        
        //code für erhalten der Einsätze 
        return "/kommPosteingang.xhtml";
    }
    public void addKontatk(){
        
    }
    
   @PostConstruct
    public void setUp(){
        
        this.PosteingangEinsaetze=this.einsatzleitsoftwares.getPosteingangEinsaetze();
        this.ArchiviertePosteingangEinsaetze=this.einsatzleitsoftwares.getArchiviertePosteingangEinsaetze();
     
    }

    public String showDetail(Fremdeinsatz e){
        fe=e;

        return "/details.xhtml";
    }
    public void EinsatzArchivieren(Fremdeinsatz e){
        this.ArchiviertePosteingangEinsaetze.add(e);
        this.PosteingangEinsaetze.remove(e);
        
    }

    public List<Fremdeinsatz> getArchiviertePosteingangEinsaetze() {
        return ArchiviertePosteingangEinsaetze;
    }

    public void setArchiviertePosteingangEinsaetze(List<Fremdeinsatz> ArchiviertePosteingangEinsaetze) {
        this.ArchiviertePosteingangEinsaetze = ArchiviertePosteingangEinsaetze;
    }


    public EinsatzleitsoftwareService getEinsatzleitsoftwares() {
        return einsatzleitsoftwares;
    }

    public void setEinsatzleitsoftwares(EinsatzleitsoftwareService einsatzleitsoftwares) {
        this.einsatzleitsoftwares = einsatzleitsoftwares;
    }
       public List<Fremdeinsatz> getPosteingangEinsaetze() {
        return PosteingangEinsaetze;
    }

    public void setPosteingangEinsaetze(List<Fremdeinsatz> PosteingangEinsaetze) {
        this.PosteingangEinsaetze = PosteingangEinsaetze;
    }

    public Fremdeinsatz getFe() {
        return fe;
    }

    public void setFe(Fremdeinsatz fe) {
        this.fe = fe;
    }
    
    
}
