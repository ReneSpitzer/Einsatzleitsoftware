/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Eigeneinsatz;
import at.htlpinkafeld.pojo.Einsatz;
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
public class PostausgangsBean {
    @ManagedProperty(value="#{einsatzleitsoftwareService}")
     EinsatzleitsoftwareService einsatzleitsoftwares;
    private List<Kontakt> Kontaktliste = new ArrayList();
    private Eigeneinsatz einsatz;
    
    public PostausgangsBean() {
    }
    
    
    
       @PostConstruct
    public void setUp(){
            this.Kontaktliste=this.einsatzleitsoftwares.getKontaktListe();
       einsatz = new Eigeneinsatz();
       
    }

    public List<Kontakt> getKontaktliste() {
        return Kontaktliste;
    }

    public void setKontaktliste(List<Kontakt> Kontaktliste) {
        this.Kontaktliste = Kontaktliste;
    }

    public Eigeneinsatz getEinsatz() {
        return einsatz;
    }

    public void setEinsatz(Eigeneinsatz einsatz) {
        this.einsatz = einsatz;
    }
    
    private String EinsatzSenden(){
        
        
        
        return "/kommPostausgang.xhtml";
    }

    public EinsatzleitsoftwareService getEinsatzleitsoftwares() {
        return einsatzleitsoftwares;
    }

    public void setEinsatzleitsoftwares(EinsatzleitsoftwareService einsatzleitsoftwares) {
        this.einsatzleitsoftwares = einsatzleitsoftwares;
    }
    
}
