/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Nuessler;
import at.htlpinkafeld.service.EinsatzleitsoftwareService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Alex
 */

@ManagedBean
@SessionScoped
public class NuesslerBerechnungsBean {

    @ManagedProperty(value="#{einsatzleitsoftwareService}")
    EinsatzleitsoftwareService einsatzleitsoftwares;
    //Listen
    private List<Nuessler> nList = new ArrayList<>();
    private List<Nuessler> filteredNuesslerList = new ArrayList<>();
    //Variablen
    private Nuessler nus = new Nuessler();
    private String name = "";
    private int nr = 0;
    private int menge = 0;
    private int meters =0;
    //Ueberprüfung
    private boolean brand = false;
    private boolean nebel = false;
    private boolean windStark = false;
    private boolean himmel = false;
    private boolean windLeicht = false;
    private boolean tageszeit = false;
    private boolean windSehrLeicht = false;
    private boolean jahreszeitSomFrueh = false;
    
    public NuesslerBerechnungsBean() {
        //this.eService = new EinsatzleitsoftwareService();
        //this.nList = this.eService.getNüsslerList();
    }
    
    @PostConstruct
    public void SetUp(){
        this.nList = this.einsatzleitsoftwares.getNüsslerList();
        this.filteredNuesslerList = this.nList;
    }

    //Getter und Setter
    
    public EinsatzleitsoftwareService getEinsatzleitsoftwares() {
        return einsatzleitsoftwares;
    }

    public void setEinsatzleitsoftwares(EinsatzleitsoftwareService einsatzleitsoftwares) {
        this.einsatzleitsoftwares = einsatzleitsoftwares;
    }

    public List<Nuessler> getnList() {
        return nList;
    }

    public void setnList(List<Nuessler> nList) {
        this.nList = nList;
    }

    public Nuessler getNus() {
        return nus;
    }

    public void setNus(Nuessler nus) {
        this.nus = nus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public List<Nuessler> getFilteredNuesslerList() {
        return filteredNuesslerList;
    }

    public void setFilteredNuesslerList(List<Nuessler> filteredNuesslerList) {
        this.filteredNuesslerList = filteredNuesslerList;
    }

    public int getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    public boolean isBrand() {
        return brand;
    }

    public void setBrand(boolean brand) {
        this.brand = brand;
    }

    public boolean isNebel() {
        return nebel;
    }

    public void setNebel(boolean nebel) {
        this.nebel = nebel;
    }

    public boolean isWindStark() {
        return windStark;
    }

    public void setWindStark(boolean windStark) {
        this.windStark = windStark;
    }

    public boolean isHimmel() {
        return himmel;
    }

    public void setHimmel(boolean himmel) {
        this.himmel = himmel;
    }

    public boolean isWindLeicht() {
        return windLeicht;
    }

    public void setWindLeicht(boolean windLeicht) {
        this.windLeicht = windLeicht;
    }

    public boolean isTageszeit() {
        return tageszeit;
    }

    public void setTageszeit(boolean tageszeit) {
        this.tageszeit = tageszeit;
    }

    public boolean isWindSehrLeicht() {
        return windSehrLeicht;
    }

    public void setWindSehrLeicht(boolean windSehrLeicht) {
        this.windSehrLeicht = windSehrLeicht;
    }

    public boolean isJahreszeitSomFrueh() {
        return jahreszeitSomFrueh;
    }

    public void setJahreszeitSomFrueh(boolean jahreszeitSomFrueh) {
        this.jahreszeitSomFrueh = jahreszeitSomFrueh;
    }
    
    
    
    //Funktionen
    
    public List<String> completeName(String query) {
        List<String> results = new ArrayList<String>();
        for(Nuessler k: this.filteredNuesslerList) {
            results.add(k.getStoffname());
        }
         
        return results;
    }
    
    public List<Integer> completeNumber(int query) {
        List<Integer> results = new ArrayList<Integer>();
        for(Nuessler k: this.nList) {
            results.add(k.getUnnr());
        }
         
        return results;
    }
    
    public Object show(){
        if(this.name != null || this.name != ""){
            //this.nus = new Nüssler(searchName(this.name));
        }else{
            if(this.nr != 0){
                //this.nus = new Nüssler(searchUNnr(this.nr));
            }else{
                return null;
            }
        } 
        return null;
    }
    
    public Nuessler searchUNnr(int nr){
        Nuessler help;
       
        for(Nuessler k: this.nList){
            if(k.getUnnr() == nr){
                //help = new Nüssler(k);
                //return help;
            }
        }
        
        return null;
    }
    
    public Nuessler searchName(String name){
        Nuessler help;
       
        for(Nuessler k: this.nList){
            if(k.getStoffname() == name){
                //help = new Nüssler(k);
                //return help;
            }
        }
        
        return null;
    }
    
    public void autoCompleteUNAction(AjaxBehaviorEvent event){
        this.filteredNuesslerList = this.nList.stream().filter(var -> var.getUnnr()==this.nr).collect(Collectors.toList());
    }
    
}
