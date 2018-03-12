/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Fahrzeuge;
import at.htlpinkafeld.service.EinsatzleitsoftwareService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author alex
 */

@ManagedBean
@SessionScoped
public class adminFahrzeugeBean {
     
    @ManagedProperty(value="#{einsatzleitsoftwareService}")
    private EinsatzleitsoftwareService afs;
    
    private List<Fahrzeuge> fList; //= new ArrayList<>();
    private Fahrzeuge kfz = new Fahrzeuge();
    //private Fahrzeuge kfzBearbeitung = new Fahrzeuge();
    
    @PostConstruct
    public void SetUp(){
        //this.fList= this.afs.getFlist();
        this.fList= this.afs.getFlist();
    }

    /*
    public Fahrzeuge getKfzBearbeitung() {
        return kfzBearbeitung;
    }

    public void setKfzBearbeitung(Fahrzeuge kfzBearbeitung) {
        this.kfzBearbeitung = kfzBearbeitung;
    }
    */
    

    public EinsatzleitsoftwareService getAfs() {
        return afs;
    }

    public void setAfs(EinsatzleitsoftwareService afs) {
        this.afs = afs;
    }
           
    public Object add(){
        if(this.kfz.getId() != 0){
            this.fList.set((kfz.getId()-1), kfz);
        }else{
            this.kfz.setId(this.fList.size()+1);   
            this.fList.add(new Fahrzeuge(kfz));
        }
        
        this.kfz = new Fahrzeuge();
        return null;
    }
    
    public Object bearbeiten(Fahrzeuge f){
        
        return null;
    }
    
    
    public Object remove(Fahrzeuge p){
        this.fList.remove(p);
        return null;
    }
    
    public Fahrzeuge getFahrzeug() {
        return kfz;
    }

    public void setFahrzeug(Fahrzeuge fz) {
        this.kfz = fz;
    }
    
    public Object edit(Fahrzeuge p){
        this.kfz.setId(p.getId());
        this.kfz.setAnzPers(p.getAnzPers());
        this.kfz.setBenutzer(p.getBenutzer());
        this.kfz.setBid(p.getBid());
        this.kfz.setName(p.getName());
        this.kfz.setOrganisation(p.getOrganisation());
        this.kfz.setOrt(p.getOrt());
        this.kfz.setType(p.getType());
        this.kfz.setVerfuegbar(p.isVerfuegbar());
  
        return null;
    }

    public List<Fahrzeuge> getfList() {
        return fList;
    }

    public void setfList(List<Fahrzeuge> fList) {
        this.fList = fList;
    }
    
  
}

