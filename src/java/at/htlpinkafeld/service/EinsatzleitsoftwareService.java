/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.service;

import at.htlpinkafeld.infrastructure.BenutzerDao;
import at.htlpinkafeld.infrastructure.BenutzerJdbcDao;
import at.htlpinkafeld.infrastructure.EigeneinsatzDao;
import at.htlpinkafeld.infrastructure.EigeneinsatzJdbcDao;
import at.htlpinkafeld.infrastructure.EinsatzDao;
import at.htlpinkafeld.infrastructure.EinsatzJdbcDao;
import at.htlpinkafeld.infrastructure.FahrzeugeDao;
import at.htlpinkafeld.infrastructure.FahrzeugeJdbcDao;
import at.htlpinkafeld.infrastructure.FremdeinsatzDao;
import at.htlpinkafeld.infrastructure.FremdeinsatzJdbcDao;
import at.htlpinkafeld.infrastructure.FunkgeraetDao;
import at.htlpinkafeld.infrastructure.FunkgeraetJdbcDao;
import at.htlpinkafeld.infrastructure.KontaktDao;
import at.htlpinkafeld.infrastructure.KontaktJdbcDao;
import at.htlpinkafeld.infrastructure.NüsslerDao;
import at.htlpinkafeld.infrastructure.NüsslerJdbcDao;
import at.htlpinkafeld.infrastructure.PersonDao;
import at.htlpinkafeld.infrastructure.PersonJdbcDao;
import at.htlpinkafeld.pojo.Benutzer;
import at.htlpinkafeld.pojo.Eigeneinsatz;
import at.htlpinkafeld.pojo.Einsatz;
import at.htlpinkafeld.pojo.Fahrzeuge;
import at.htlpinkafeld.pojo.Fremdeinsatz;
import at.htlpinkafeld.pojo.Funkgeraet;
import at.htlpinkafeld.pojo.Kontakt;
import at.htlpinkafeld.pojo.Nüssler;
import at.htlpinkafeld.pojo.Person;
import java.util.ArrayList;
import java.util.LinkedList;
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
// Membervarialben kleinschreiben
    private List<Kontakt> kontaktliste = new ArrayList<>();
    private List<Benutzer> benutzerListe = new ArrayList<>();
    private List<Einsatz> archivierteEinsätze = new ArrayList();
    private List<Fremdeinsatz> posteingangEinsaetze = new ArrayList();
    private List<Fremdeinsatz> archiviertePosteingangEinsaetze = new ArrayList();
    //Berni-Listen
    //private List<Einsatz> einsatzlist = new ArrayList<>(); //Liste von allen Einsätzen
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
    
    private BenutzerDao benutzerDao = new BenutzerJdbcDao("benutzer", "bid");
    private List<Benutzer> benutzerList = benutzerDao.list();
    
    private EigeneinsatzDao eigeneinsatzDao = new EigeneinsatzJdbcDao("eigeneinsatz", "eeid");
    private List<Eigeneinsatz> eigeneinsatzList = eigeneinsatzDao.list();
    
    private EinsatzDao einsatzDao = new EinsatzJdbcDao("einsatz", "eid");
    private List<Einsatz> einsatzlist = einsatzDao.list();
    
    private FahrzeugeDao fahrzeugeDao = new FahrzeugeJdbcDao("fahrzeuge", "fid");
    private List<Fahrzeuge> fahrzeugeList = fahrzeugeDao.list();
    
    private FremdeinsatzDao fremdeinsatzDao = new FremdeinsatzJdbcDao("fremdeinsatz", "frid");
    private List<Fremdeinsatz> fremdeinsatzList = fremdeinsatzDao.list();
    
    private FunkgeraetDao funkgeraetDao = new FunkgeraetJdbcDao("funkgeraet", "fuid");
    private List<Funkgeraet> funkgeraetList = funkgeraetDao.list();
    
    private KontaktDao kontaktDao = new KontaktJdbcDao("kontakt", "kid");
    private List<Kontakt> kontaktList = kontaktDao.list();
    
    private NüsslerDao nüsslerDao = new NüsslerJdbcDao("nüssler", "nid");
    private List<Nüssler> nüsslerList = nüsslerDao.list();
    
    private PersonDao personDao = new PersonJdbcDao("person", "pid");
    private List<Person> personList = personDao.list();

    public EinsatzleitsoftwareService() {
        //Test-Daten-Benutzer
        benutzerListe.add(new Benutzer(1, "Herbert", false, "1234ABC", 1));
        benutzerListe.add(new Benutzer(2, "Rene", false, "renespitzer", 2));
        //Test-Daten-ArchivierteEinsätze
        archivierteEinsätze.add(new Einsatz(1, "Pinkafeld", "Meierhofplatz", "1", "Brand löschen",
                "Fuchs", 1, "LFZ01", "13:05", "25.11.2017", "offen", 1));

        archivierteEinsätze.add(new Einsatz(2, "Oberwart", "Eo", "7", "Hochwasser",
                "Prunner", 2, "LFZ02", "14:06", "20.11.2017", "offen", 1));

        archivierteEinsätze.add(new Einsatz(3, "Hartberg", "Roseggergasse", "2", "Katze von Baum retten",
                "Altmann", 3, "LFZ03", "12:06", "20.1.2018", "in Arbeit", 1));

        archivierteEinsätze.add(new Einsatz(4, "Test", "Testgasse", "7", "Hochwasser",
                "Maierhofer", 4, "LFZ04", "4:27", "2.11.2017", "in Arbeit", 1));

        archivierteEinsätze.add(new Einsatz(5, "Güssing", "gu", "1a", "Lkw Unfall ",
                "Fleck", 5, "LFZ05", "13:05", "27.8.2017", "abgeschlossen", 1));

        archivierteEinsätze.add(new Einsatz(6, "Oberloisdorf", "McStrasse", "15", "Brand löschen",
                "Spitzer", 6, "LFZ06", "15:03", "25.10.2017", "abgeschlossen", 1));
        //Posteingang-Test-Datensätze
        posteingangEinsaetze.add(new Fremdeinsatz(1, "Hubert", "FF-Pinkafeld", 1, new Einsatz(1, "Pinkafeld", "Meierhofplatz", "1", "Brand löschen",
                "Fuchs", 1, "LFZ01", "13:05", "25.11.2017", "offen", 1), "Brand in der HTL"));
        posteingangEinsaetze.add(new Fremdeinsatz(2, "Bernd", "FF-Pinkafeld", 1, new Einsatz(1, "Pinkafeld", "Ulreich", "1", "Überschwemmung",
                "Fuchs", 1, "LFZ01", "13:05", "25.11.2018", "offen", 1), "Brand in der HTL"));
        posteingangEinsaetze.add(new Fremdeinsatz(3, "Fuchs", "FF-Pinkafeld", 1, new Einsatz(1, "Pinkafeld", "Steinermanager", "1", "Keine Ahnung",
                "Fuchs", 1, "LFZ01", "13:05", "25.11.2019", "offen", 1), "Brand in der HTL"));
        //Test-Daten-Kontakte
       kontaktliste.add(new Kontakt("Hauptlöschfahrzeug","HLF1",010101210));
       kontaktliste.add(new Kontakt("Transportfahrzeug","TLF1",01017));
       kontaktliste.add(new Kontakt("Löschfahrzeug","LLF1",0101332110));
       kontaktliste.add(new Kontakt("Truppentransport","TTL",01513110));
       
       //Berni-Code
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
        
    }

    public List<Kontakt> getKontaktliste() {
        return kontaktliste;
    }

    public void setKontaktliste(List<Kontakt> kontaktliste) {
        this.kontaktliste = kontaktliste;
    }

    public List<Einsatz> getEinsatzlist() {
        return einsatzlist;
    }

    public void setEinsatzlist(List<Einsatz> einsatzlist) {
        this.einsatzlist = einsatzlist;
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

    public List<Einsatz> getArelist() {
        return arelist;
    }

    public void setArelist(List<Einsatz> arelist) {
        this.arelist = arelist;
    }

    public List<Fahrzeuge> getFlist() {
        return flist;
    }

    public void setFlist(List<Fahrzeuge> flist) {
        this.flist = flist;
    }

    public List<Fahrzeuge> getFplist() {
        return fplist;
    }

    public void setFplist(List<Fahrzeuge> fplist) {
        this.fplist = fplist;
    }

    public List<Fahrzeuge> getFelist() {
        return felist;
    }

    public void setFelist(List<Fahrzeuge> felist) {
        this.felist = felist;
    }

    public Fahrzeuge getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeuge fahrzeug) {
        this.fahrzeug = fahrzeug;
    }

    public List<String> getStatuslist() {
        return statuslist;
    }

    public void setStatuslist(List<String> statuslist) {
        this.statuslist = statuslist;
    }

    public List<String> getStautslistarchiviert() {
        return stautslistarchiviert;
    }

    public void setStautslistarchiviert(List<String> stautslistarchiviert) {
        this.stautslistarchiviert = stautslistarchiviert;
    }

    public List<String> getSelectedortlist() {
        return selectedortlist;
    }

    public void setSelectedortlist(List<String> selectedortlist) {
        this.selectedortlist = selectedortlist;
    }

    
    public List<Fremdeinsatz> getPosteingangEinsaetze() {
        return posteingangEinsaetze;
    }

    public void setPosteingangEinsaetze(List<Fremdeinsatz> PosteingangEinsaetze) {
        this.posteingangEinsaetze = PosteingangEinsaetze;
    }

    public List<Fremdeinsatz> getArchiviertePosteingangEinsaetze() {
        return archiviertePosteingangEinsaetze;
    }
    public void setArchiviertePosteingangEinsaetze(List<Fremdeinsatz> ArchiviertePosteingangEinsaetze) {    
        this.archiviertePosteingangEinsaetze = ArchiviertePosteingangEinsaetze;
    }

    public void addKontakt(Kontakt k) {
        kontaktliste.add(k);
        System.out.println("Kontakt angelegt");
    }

    public void deleteKontakt(Kontakt k) {
        this.kontaktliste.remove(k);
        System.out.println("Kontakt gelöscht");
    }

    public List<Kontakt> getKontaktListe() {
        return kontaktliste;
    }

    public void setKontaktListe(List<Kontakt> KontaktListe) {
        this.kontaktliste = KontaktListe;
    }

    public List<Benutzer> getBenutzerListe() {
        return benutzerListe;
    }

    public void setBenutzerListe(List<Benutzer> BenutzerListe) {
        this.benutzerListe = BenutzerListe;
    }

    public List<Einsatz> getArchivierteEinsätze() {
        return archivierteEinsätze;
    }

    public void setArchivierteEinsätze(List<Einsatz> ArchivierteEinsätze) {
        this.archivierteEinsätze = ArchivierteEinsätze;
    }

    public BenutzerDao getBenutzerDao() {
        return benutzerDao;
    }

    public void setBenutzerDao(BenutzerDao benutzerDao) {
        this.benutzerDao = benutzerDao;
    }

    public EigeneinsatzDao getEigeneinsatzDao() {
        return eigeneinsatzDao;
    }

    public void setEigeneinsatzDao(EigeneinsatzDao eigeneinsatzDao) {
        this.eigeneinsatzDao = eigeneinsatzDao;
    }

    public EinsatzDao getEinsatzDao() {
        return einsatzDao;
    }

    public void setEinsatzDao(EinsatzDao einsatzDao) {
        this.einsatzDao = einsatzDao;
    }

    public FahrzeugeDao getFahrzeugeDao() {
        return fahrzeugeDao;
    }

    public void setFahrzeugeDao(FahrzeugeDao fahrzeugeDao) {
        this.fahrzeugeDao = fahrzeugeDao;
    }

    public FremdeinsatzDao getFremdeinsatzDao() {
        return fremdeinsatzDao;
    }

    public void setFremdeinsatzDao(FremdeinsatzDao fremdeinsatzDao) {
        this.fremdeinsatzDao = fremdeinsatzDao;
    }

    public FunkgeraetDao getFunkgeraetDao() {
        return funkgeraetDao;
    }

    public void setFunkgeraetDao(FunkgeraetDao funkgeraetDao) {
        this.funkgeraetDao = funkgeraetDao;
    }

    public KontaktDao getKontaktDao() {
        return kontaktDao;
    }

    public void setKontaktDao(KontaktDao kontaktDao) {
        this.kontaktDao = kontaktDao;
    }

    public NüsslerDao getNüsslerDao() {
        return nüsslerDao;
    }

    public void setNüsslerDao(NüsslerDao nüsslerDao) {
        this.nüsslerDao = nüsslerDao;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
    
    public List<Benutzer> getBenutzerList() {
        return benutzerList;
    }

    public void setBenutzerList(List<Benutzer> benutzerList) {
        this.benutzerList = benutzerList;
    }
    
    public void createBenutzer(Benutzer b){
        this.benutzerDao.create(b);
    }
    
    public Benutzer findBenutzerById(int id){
        return benutzerDao.read(id);
    }
    
    public void updateBenutzer(Benutzer b)
    {
        this.benutzerDao.update(b);
    }
    
    public void deleteBenutzer(Benutzer b)
    {
        this.benutzerDao.delete(b);
    }

    public List<Eigeneinsatz> getEigeneinsatzList() {
        return eigeneinsatzList;
    }

    public void setEigeneinsatzList(List<Eigeneinsatz> eigeneinsatzList) {
        this.eigeneinsatzList = eigeneinsatzList;
    }
    
    public void createEigeneinsatz(Eigeneinsatz ee){
        this.eigeneinsatzDao.create(ee);
    }
    
    public Eigeneinsatz findEigeneinsatzById(int id){
        return eigeneinsatzDao.read(id);
    }
    
    public void updateEigeneinsatz(Eigeneinsatz ee)
    {
        this.eigeneinsatzDao.update(ee);
    }
    
    public void deleteEigeneinsatz(Eigeneinsatz ee)
    {
        this.eigeneinsatzDao.delete(ee);
    }

    public List<Fahrzeuge> getFahrzeugeList() {
        return fahrzeugeList;
    }

    public void setFahrzeugeList(List<Fahrzeuge> fahrzeugeList) {
        this.fahrzeugeList = fahrzeugeList;
    }
    
    public void createFahrzeuge(Fahrzeuge f){
        this.fahrzeugeDao.create(f);
    }
    
    public Fahrzeuge findFahrzeugeById(int id){
        return fahrzeugeDao.read(id);
    }
    
    public void updateFahrzeuge(Fahrzeuge f)
    {
        this.fahrzeugeDao.update(f);
    }
    
    public void deleteFahrzeuge(Fahrzeuge f)
    {
        this.fahrzeugeDao.delete(f);
    }

    public List<Fremdeinsatz> getFremdeinsatzList() {
        return fremdeinsatzList;
    }

    public void setFremdeinsatzList(List<Fremdeinsatz> fremdeinsatzList) {
        this.fremdeinsatzList = fremdeinsatzList;
    }
    
    public void createFremdeinsatz(Fremdeinsatz fe){
        this.fremdeinsatzDao.create(fe);
    }
    
    public Fremdeinsatz findFremdeinsatzById(int id){
        return fremdeinsatzDao.read(id);
    }
    
    public void updateFremdeinsatz(Fremdeinsatz fe)
    {
        this.fremdeinsatzDao.update(fe);
    }
    
    public void deleteFremdeinsatz(Fremdeinsatz fe)
    {
        this.fremdeinsatzDao.delete(fe);
    }

    public List<Funkgeraet> getFunkgeraetList() {
        return funkgeraetList;
    }

    public void setFunkgeraetList(List<Funkgeraet> funkgeraetList) {
        this.funkgeraetList = funkgeraetList;
    }
    
    public void createFunkgeraet(Funkgeraet f){
        this.funkgeraetDao.create(f);
    }
    
    public Funkgeraet findFunkgeraetById(int id){
        return funkgeraetDao.read(id);
    }
    
    public void updateFunkgeraet(Funkgeraet f)
    {
        this.funkgeraetDao.update(f);
    }
    
    public void deleteFunkgeraet(Funkgeraet f)
    {
        this.funkgeraetDao.delete(f);
    }

    public List<Kontakt> getKontaktList() {
        return kontaktList;
    }

    public void setKontaktList(List<Kontakt> kontaktList) {
        this.kontaktList = kontaktList;
    }
    
    public void createFunkgeraet(Kontakt k){
        this.kontaktDao.create(k);
    }
    
    public Kontakt findKontaktById(int id){
        return kontaktDao.read(id);
    }
    
    public void updateFunkgeraet(Kontakt k)
    {
        this.kontaktDao.update(k);
    }
    
    public void deleteFunkgeraet(Kontakt k)
    {
        this.kontaktDao.delete(k);
    }

    public List<Nüssler> getNüsslerList() {
        return nüsslerList;
    }

    public void setNüsslerList(List<Nüssler> nüsslerList) {
        this.nüsslerList = nüsslerList;
    }

    public void createNüssler(Nüssler n){
        this.nüsslerDao.create(n);
    }
    
    public Nüssler findNüsslerById(int id){
        return nüsslerDao.read(id);
    }
    
    public void updateNüssler(Nüssler n)
    {
        this.nüsslerDao.update(n);
    }
    
    public void deleteNüssler(Nüssler n)
    {
        this.nüsslerDao.delete(n);
    }
    
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
    
    public void createPerson(Person p){
        this.personDao.create(p);
    }
    
    public Person findPersonById(int id){
        return personDao.read(id);
    }
    
    public void updatePerson(Person p)
    {
        this.personDao.update(p);
    }
    
    public void deletePerson(Person p)
    {
        this.personDao.delete(p);
    }
    
    public void createEinsatz(Einsatz e){
        this.einsatzDao.create(e);
    }
    
    public Einsatz findEinsatzById(int id){
        return einsatzDao.read(id);
    }
    
    public void updateEinsatz(Einsatz e)
    {
        this.einsatzDao.update(e);
    }
    
    public void deleteEinsatz(Einsatz e)
    {
        this.einsatzDao.delete(e);
    }
}