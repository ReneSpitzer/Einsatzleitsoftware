/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Kontakt;
import at.htlpinkafeld.service.EinsatzleitsoftwareService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rene-_000
 */
@ManagedBean
@SessionScoped
public class KontaktverwaltungsBean {
    @ManagedProperty(value="#{EinsatzleitsoftwareService}")
     EinsatzleitsoftwareService einsatzleitsoftwares;
     private Kontakt kontakt;
     private Kontakt selkon;
     private int id=1;

    public Kontakt getKontakt() {
        return kontakt;
    }

    public void setKontakt(Kontakt kontakt) {
        this.kontakt = kontakt;
    }
    public void addKontakt(){
        kontakt.setId(id);
        einsatzleitsoftwares.addKontakt(kontakt);
        id++;
    }
    public void deleteKontakt(){
       this.einsatzleitsoftwares.deleteKontakt(selkon);
        
    }

    public EinsatzleitsoftwareService getEinsatzleitsoftwares() {
        return einsatzleitsoftwares;
    }

    public void setEinsatzleitsoftwares(EinsatzleitsoftwareService einsatzleitsoftwares) {
        this.einsatzleitsoftwares = einsatzleitsoftwares;
    }

    public Kontakt getSelkon() {
        return selkon;
    }

    public void setSelkon(Kontakt selkon) {
        this.selkon = selkon;
    }
    
    
}
