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

    private List<Kontakt> KontaktListe = new ArrayList<>();
    private List<Benutzer> BenutzerListe = new ArrayList<>();
    private List<Einsatz> ArchivierteEinsätze = new ArrayList();

    public EinsatzleitsoftwareService() {
    }

    @PostConstruct
    public void set() {
        BenutzerListe.add(new Benutzer(1, "Herbert", false, "1234ABC", 1));
        KontaktListe.add(new Kontakt("H", "Huber", 112, 1));
        KontaktListe.add(new Kontakt("H", "Huber", 112, 2));
        KontaktListe.add(new Kontakt("H", "Huber", 112, 3));
        ArchivierteEinsätze.add(new Einsatz(1, "Pinkafeld", "Meierhofplatz", "1", "Brand löschen",
                "Fuchs", 1, "LFZ01", "13:05", "25.11.2017", "offen", 1));

        ArchivierteEinsätze.add(new Einsatz(2, "Oberwart", "Eo", "7", "Hochwasser",
                "Prunner", 2, "LFZ02", "14:06", "20.11.2017", "offen", 1));

        ArchivierteEinsätze.add(new Einsatz(3, "Hartberg", "Roseggergasse", "2", "Katze von Baum retten",
                "Altmann", 3, "LFZ03", "12:06", "20.1.2018", "in Arbeit", 1));

        ArchivierteEinsätze.add(new Einsatz(4, "Test", "Testgasse", "7", "Hochwasser",
                "Maierhofer", 4, "LFZ04", "4:27", "2.11.2017", "in Arbeit", 1));

        ArchivierteEinsätze.add(new Einsatz(5, "Güssing", "gu", "1a", "Lkw Unfall ",
                "Fleck", 5, "LFZ05", "13:05", "27.8.2017", "abgeschlossen", 1));

        ArchivierteEinsätze.add(new Einsatz(6, "Oberloisdorf", "McStrasse", "15", "Brand löschen",
                "Spitzer", 6, "LFZ06", "15:03", "25.10.2017", "abgeschlossen", 1));

    }

    public void addKontakt(Kontakt k) {
        KontaktListe.add(k);
        System.out.println("Kontakt angelegt");
    }

    public void deleteKontakt(Kontakt k) {
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
