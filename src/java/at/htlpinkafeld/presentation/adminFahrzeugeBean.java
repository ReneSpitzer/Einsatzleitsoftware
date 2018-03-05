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
     EinsatzleitsoftwareService afs;
    
    private List<Fahrzeuge> fList; //= new ArrayList<>();
    private Fahrzeuge kfz = new Fahrzeuge();
    
    @PostConstruct
    public void SetUp(){
        //this.fList= this.afs.getFlist();
    }
    
    public EinsatzleitsoftwareService getFahrzeugeService(){
        return afs;
    }

    public adminFahrzeugeBean(){
        //this.kfz = new Fahrzeuge();
        this.afs = new EinsatzleitsoftwareService();
        this.fList= this.afs.getFlist();
    }
     
    public void setEinsatzleitsoftwareService(EinsatzleitsoftwareService pms){
        this.afs = pms;
    }
           
    public Object add(){
        this.kfz.setId(this.fList.size()+1);
        this.kfz.setStatus(0);
        this.fList.add(kfz);
        
        this.kfz = new Fahrzeuge();
        return null;
    }
    
    public Object save(){
        Fahrzeuge help = null;
        int i = -1;
        for(Fahrzeuge p: this.getfList()){
            if(p.getId() == kfz.getId())
                    help = p;
            else
                  i++;
        }
        
        if(help != null){
            help.setOrganisation(kfz.getOrganisation());
            help.setOrt(kfz.getOrt());
            help.setType(kfz.getType());
            help.setAnzPers(kfz.getAnzPers());
            help.setName(kfz.getName());
            
            this.fList.set(i, help);
        }
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
        kfz.setOrganisation((p.getOrganisation() == null) ? "" : p.getOrganisation());
        kfz.setOrt((p.getOrt()== null) ? "" : p.getOrt());
        kfz.setType((p.getType() == null) ? "" : p.getType());
        kfz.setAnzPers(p.getAnzPers());
        kfz.setName((p.getName() == null) ? "" :p.getName());
        return null;
    }

    public List<Fahrzeuge> getfList() {
        return fList;
    }

    public void setfList(List<Fahrzeuge> fList) {
        this.fList = fList;
    }
    
    
}

