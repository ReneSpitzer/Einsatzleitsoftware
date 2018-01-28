/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

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
public class KontaktverwaltungsBean {
   // @ManagedProperty(value="#{EinsatzleitsoftwareService}")
     //EinsatzleitsoftwareService einsatzleitsoftwares;
    private List<Kontakt> Kontaktliste = new ArrayList();
     private Kontakt kontakt;
     private Kontakt selkon;
     private int id=1;
     private int eid=1;
     

    public KontaktverwaltungsBean() {
        kontakt= new Kontakt();
        selkon = new Kontakt();
        
    }
      @PostConstruct
    public void setUp(){
       Kontaktliste.add(new Kontakt("Kommandolöschfahrzeug 1","KLF1",010101210));
       Kontaktliste.add(new Kontakt("Kommandolöschfahrzeug 2","KLF1",010101210));
       Kontaktliste.add(new Kontakt("Kommandolöschfahrzeug 3","KLF1",010101210));
       Kontaktliste.add(new Kontakt("Kommandolöschfahrzeug 4","KLF1",010101210));
               
       
    }

     
    public Kontakt getKontakt() {
        return kontakt;
    }

    public void setKontakt(Kontakt kontakt) {
        this.kontakt = kontakt;
    }
    public void addKontakt(){
        kontakt.setKid(0);
        kontakt.setId(0);
        this.Kontaktliste.add(kontakt);
        //einsatzleitsoftwares.addKontakt(kontakt);
        //id++;
        //eid++;
    }

    public List<Kontakt> getKontaktliste() {
        return Kontaktliste;
    }

    public void setKontaktliste(List<Kontakt> Kontaktliste) {
        this.Kontaktliste = Kontaktliste;
    }

    
    
    public void deleteKontakt(Kontakt kon){
        this.Kontaktliste.remove(kon);
     //  this.einsatzleitsoftwares.deleteKontakt(selkon);
       
    }
/*
    public EinsatzleitsoftwareService getEinsatzleitsoftwares() {
        return einsatzleitsoftwares;
    }

    public void setEinsatzleitsoftwares(EinsatzleitsoftwareService einsatzleitsoftwares) {
        this.einsatzleitsoftwares = einsatzleitsoftwares;
    }
*/
    public Kontakt getSelkon() {
        return selkon;
    }

    public void setSelkon(Kontakt selkon) {
        this.selkon = selkon;
    }
    
}
