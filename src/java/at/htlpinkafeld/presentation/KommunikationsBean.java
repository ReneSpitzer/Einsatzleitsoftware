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
      @ManagedProperty(value="#{EinsatzleitsoftwareService}")
     EinsatzleitsoftwareService einsatzleitsoftwares;
      
    Fremdeinsatz fe; 
            List<Fremdeinsatz> PosteingangEinsaetze = new ArrayList();
            List<Fremdeinsatz> ArchiviertePosteingangEinsaetze = new ArrayList();

 
      
    

 
    public KommunikationsBean(){
        
        
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
        /*
        this.PosteingangEinsaetze=this.einsatzleitsoftwares.getPosteingangEinsaetze();
        this.ArchiviertePosteingangEinsaetze=this.einsatzleitsoftwares.getArchiviertePosteingangEinsaetze();
        */
       //this.PosteingangEinsaetze.add(new Fremdeinsatz("Huber","Spitzer"))
    this.PosteingangEinsaetze.add(new Fremdeinsatz(1,"Hubert","FF-Pinkafeld",1,new Einsatz(1, "Pinkafeld", "Meierhofplatz", "1", "Brand löschen",
                "Fuchs", 1, "LFZ01", "13:05", "25.11.2017", "offen", 1),"Brand in der HTL"));
    this.PosteingangEinsaetze.add(new Fremdeinsatz(2,"Bernd","FF-Pinkafeld",1,new Einsatz(1, "Pinkafeld", "Ulreich", "1", "Überschwemmung",
                "Fuchs", 1, "LFZ01", "13:05", "25.11.2018", "offen", 1),"Brand in der HTL"));
    this.PosteingangEinsaetze.add(new Fremdeinsatz(3,"Fuchs","FF-Pinkafeld",1,new Einsatz(1, "Pinkafeld", "Steinermanager", "1", "Keine Ahnung",
                "Fuchs", 1, "LFZ01", "13:05", "25.11.2019", "offen", 1),"Brand in der HTL"));
      /* 
    private int frid;
    private String absender;
    private String empfaenger;
    private int eid;
    private Einsatz einsatz;
    private String text;
*/
    }
    public String showDetail(Fremdeinsatz e){
        fe=e;
         fe.setStatus(true);
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
