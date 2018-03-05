/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.pojo;

/**
 *
 * @author Bernhard Fuchs
 */
public class Counter implements Identifiable{
    private int cid;
    private int cntBenutzer;
    private int cntEinsatz;
    private int cntEigeneinsatz;
    private int cntFremdeinsatz;
    private int cntFahrzeuge;
    private int cntFunkgeraet;
    private int cntKontakt;
    private int cntNuessler;
    private int cntPerson;
    private int cntZeitaufzeichnung;  

    public Counter(){}

    public Counter(int cid, int cntBenutzer, int cntEinsatz, int cntEigeneinsatz, int cntFremdeinsatz, int cntFahrzeuge, int cntFunkgeraet, int cntKontakt, int cntNuessler, int cntPerson, int cntZeitaufzeichnung) {
        this.cid = cid;
        this.cntBenutzer = cntBenutzer;
        this.cntEinsatz = cntEinsatz;
        this.cntEigeneinsatz = cntEigeneinsatz;
        this.cntFremdeinsatz = cntFremdeinsatz;
        this.cntFahrzeuge = cntFahrzeuge;
        this.cntFunkgeraet = cntFunkgeraet;
        this.cntKontakt = cntKontakt;
        this.cntNuessler = cntNuessler;
        this.cntPerson = cntPerson;
        this.cntZeitaufzeichnung = cntZeitaufzeichnung;
    }
    
    public Counter(int cntBenutzer, int cntEinsatz, int cntEigeneinsatz, int cntFremdeinsatz, int cntFahrzeuge, int cntFunkgeraet, int cntKontakt, int cntNuessler, int cntPerson, int cntZeitaufzeichnung) {
        this.cntBenutzer = cntBenutzer;
        this.cntEinsatz = cntEinsatz;
        this.cntEigeneinsatz = cntEigeneinsatz;
        this.cntFremdeinsatz = cntFremdeinsatz;
        this.cntFahrzeuge = cntFahrzeuge;
        this.cntFunkgeraet = cntFunkgeraet;
        this.cntKontakt = cntKontakt;
        this.cntNuessler = cntNuessler;
        this.cntPerson = cntPerson;
        this.cntZeitaufzeichnung = cntZeitaufzeichnung;
    }
    
    @Override
    public void setId(int id) {
        this.cid = id;
    }

    @Override
    public int getId() {
        return this.cid;
    }

    public int getCntBenutzer() {
        return cntBenutzer;
    }

    public void setCntBenutzer(int cntBenutzer) {
        this.cntBenutzer = cntBenutzer;
    }

    public int getCntEinsatz() {
        return cntEinsatz;
    }

    public void setCntEinsatz(int cntEinsatz) {
        this.cntEinsatz = cntEinsatz;
    }

    public int getCntEigeneinsatz() {
        return cntEigeneinsatz;
    }

    public void setCntEigeneinsatz(int cntEigeneinsatz) {
        this.cntEigeneinsatz = cntEigeneinsatz;
    }

    public int getCntFremdeinsatz() {
        return cntFremdeinsatz;
    }

    public void setCntFremdeinsatz(int cntFremdeinsatz) {
        this.cntFremdeinsatz = cntFremdeinsatz;
    }

    public int getCntFahrzeuge() {
        return cntFahrzeuge;
    }

    public void setCntFahrzeuge(int cntFahrzeuge) {
        this.cntFahrzeuge = cntFahrzeuge;
    }

    public int getCntFunkgeraet() {
        return cntFunkgeraet;
    }

    public void setCntFunkgeraet(int cntFunkgeraet) {
        this.cntFunkgeraet = cntFunkgeraet;
    }

    public int getCntKontakt() {
        return cntKontakt;
    }

    public void setCntKontakt(int cntKontakt) {
        this.cntKontakt = cntKontakt;
    }

    public int getCntNuessler() {
        return cntNuessler;
    }

    public void setCntNuessler(int cntNuessler) {
        this.cntNuessler = cntNuessler;
    }

    public int getCntPerson() {
        return cntPerson;
    }

    public void setCntPerson(int cntPerson) {
        this.cntPerson = cntPerson;
    }

    public int getCntZeitaufzeichnung() {
        return cntZeitaufzeichnung;
    }

    public void setCntZeitaufzeichnung(int cntZeitaufzeichnung) {
        this.cntZeitaufzeichnung = cntZeitaufzeichnung;
    }
    
    
}
