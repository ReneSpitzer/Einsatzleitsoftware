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
            List<Fremdeinsatz> posteingangEinsaetze = new ArrayList();
            List<Fremdeinsatz> archiviertePosteingangEinsaetze = new ArrayList();

 
      
    

 
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
        
        this.posteingangEinsaetze=this.einsatzleitsoftwares.getPosteingangEinsaetze();
        this.archiviertePosteingangEinsaetze=this.einsatzleitsoftwares.getArchiviertePosteingangEinsaetze();
     
    }

    public String showDetail(Fremdeinsatz e){
        fe=e;

        return "/details.xhtml";
    }
    public void EinsatzArchivieren(Fremdeinsatz e){
        this.archiviertePosteingangEinsaetze.add(e);
        this.posteingangEinsaetze.remove(e);
        
    }

    public List<Fremdeinsatz> getArchiviertePosteingangEinsaetze() {
        return archiviertePosteingangEinsaetze;
    }

    public void setArchiviertePosteingangEinsaetze(List<Fremdeinsatz> archiviertePosteingangEinsaetze) {
        this.archiviertePosteingangEinsaetze = archiviertePosteingangEinsaetze;
    }


    public EinsatzleitsoftwareService getEinsatzleitsoftwares() {
        return einsatzleitsoftwares;
    }

    public void setEinsatzleitsoftwares(EinsatzleitsoftwareService einsatzleitsoftwares) {
        this.einsatzleitsoftwares = einsatzleitsoftwares;
    }
       public List<Fremdeinsatz> getPosteingangEinsaetze() {
        return posteingangEinsaetze;
    }

    public void setPosteingangEinsaetze(List<Fremdeinsatz> posteingangEinsaetze) {
        this.posteingangEinsaetze = posteingangEinsaetze;
    }

    public Fremdeinsatz getFe() {
        return fe;
    }

    public void setFe(Fremdeinsatz fe) {
        this.fe = fe;
    }
    
    
}
