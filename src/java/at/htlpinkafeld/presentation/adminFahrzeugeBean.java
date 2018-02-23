/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Fahrzeuge;
import at.htlpinkafeld.service.adminFahrzeugeService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author alexa
 */
@ManagedBean
@SessionScoped
public class adminFahrzeugeBean {
     
    private adminFahrzeugeService afs;
    
    public Fahrzeuge kfz;
    
    public adminFahrzeugeService getFahrzeugeService(){
        return afs;
    }

    public adminFahrzeugeBean() {
        this.kfz = new Fahrzeuge();
        this.afs = new adminFahrzeugeService();
    }
    
    
    
    public void setPupilManagerService(adminFahrzeugeService pms){
        this.afs = pms;
    }
           
    public Object add(){
        kfz.setId(this.afs.getFahrzeugList().indexOf(kfz));
        
        this.afs.addFahrzeug(kfz);
        
        
        return null;
    }
    
    public Object save(){
        Fahrzeuge help = null;
        for(Fahrzeuge p: this.afs.getFahrzeugList()){
            if(p.getId() == kfz.getId())
                    help = p;
        }
        
        if(help != null){
            help.setOrganisation(kfz.getOrganisation());
            help.setOrt(kfz.getOrt());
            help.setType(kfz.getType());
            help.setAnzPers(kfz.getAnzPers());
            help.setStatus(kfz.getStatus());
            help.setName(kfz.getName());
        }
        return null;
    }
    
    public Object remove(Fahrzeuge p){
        this.afs.removeFahrzeug(p);
        return null;
    }
    
    public Fahrzeuge getFahrzeug() {
        return kfz;
    }

    public void setFahrzeug(Fahrzeuge fz) {
        this.kfz = fz;
    }
    
    public Object edit(Fahrzeuge p){
        kfz.setOrganisation(p.getOrganisation());
        kfz.setOrt(p.getOrt());
        kfz.setType(p.getType());
        kfz.setAnzPers(p.getAnzPers());
        kfz.setStatus(p.getStatus());
        kfz.setName(p.getName());
        return null;
    }
}

