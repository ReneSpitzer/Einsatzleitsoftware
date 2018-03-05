/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Fahrzeuge;
import at.htlpinkafeld.service.EinsatzleitsoftwareService;
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
    
    public Fahrzeuge kfz;
    
    @PostConstruct
    public void SetUp(){
        
    }
    
    public EinsatzleitsoftwareService getFahrzeugeService(){
        return afs;
    }

    public adminFahrzeugeBean() {
        this.kfz = new Fahrzeuge();
        this.afs = new EinsatzleitsoftwareService();
    }
    
    
    
    public void setEinsatzleitsoftwareService(EinsatzleitsoftwareService pms){
        this.afs = pms;
    }
           
    public Object add(){
        kfz.setId(this.afs.getFlist().indexOf(kfz));
        
        this.afs.addFahrzeug(kfz);
        
        
        return null;
    }
    
    public Object save(){
        Fahrzeuge help = null;
        for(Fahrzeuge p: this.afs.getFlist()){
            if(p.getId() == kfz.getId())
                    help = p;
        }
        
        if(help != null){
            help.setOrganisation(kfz.getOrganisation());
            help.setOrt(kfz.getOrt());
            help.setType(kfz.getType());
            help.setAnzPers(kfz.getAnzPers());
            help.setVerfuegbar(kfz.isVerfuegbar());
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
        kfz.setVerfuegbar(p.isVerfuegbar());
        kfz.setName(p.getName());
        return null;
    }
}

