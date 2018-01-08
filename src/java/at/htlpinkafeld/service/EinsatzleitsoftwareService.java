/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.service;

import at.htlpinkafeld.pojo.Benutzer;
import at.htlpinkafeld.pojo.Einsatz;
import at.htlpinkafeld.pojo.Kontakt;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rene-_000
 */
@ManagedBean
@SessionScoped
public class EinsatzleitsoftwareService {
private List<Kontakt> KontaktListe= new ArrayList<>();
private List<Benutzer> BenutzerListe = new ArrayList<>();
private List<Einsatz> ArchivierteEinsätze = new ArrayList();

public EinsatzleitsoftwareService(){
}  
    
@PostConstruct
  public void set(){  
    BenutzerListe.add(new Benutzer(1,"Herbert",false,"1234ABC",1));
}
  
public void addKontakt(Kontakt k){
    KontaktListe.add(k);
    System.out.println("Kontakt angelegt");
}
public void deleteKontakt(Kontakt k){
    this.KontaktListe.remove(k);
    System.out.println("Kontakt gelöscht");
}

    public List<Kontakt> getKontaktListe() {
        return KontaktListe;
    }

    public void setKontaktListe(List<Kontakt> KontaktListe) {
        this.KontaktListe = KontaktListe;
    }

    public List<Benutzer> getBenutzerListe() {
        return BenutzerListe;
    }

    public void setBenutzerListe(List<Benutzer> BenutzerListe) {
        this.BenutzerListe = BenutzerListe;
    }

    public List<Einsatz> getArchivierteEinsätze() {
        return ArchivierteEinsätze;
    }

    public void setArchivierteEinsätze(List<Einsatz> ArchivierteEinsätze) {
        this.ArchivierteEinsätze = ArchivierteEinsätze;
    }


}
