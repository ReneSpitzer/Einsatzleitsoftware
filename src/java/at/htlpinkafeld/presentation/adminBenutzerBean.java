/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Benutzer;
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
public class adminBenutzerBean {

    @ManagedProperty(value="#{einsatzleitsoftwareService}")
    private EinsatzleitsoftwareService abs = new EinsatzleitsoftwareService();
    
    private Benutzer ben = new Benutzer();
    private List<Benutzer> bList = new ArrayList<>();
    /**
     * Creates a new instance of adminBenutzerBean
     */
    
    @PostConstruct
    public void SetUp(){
        //this.bList = this.abs.getBenutzerListe();
    }
    
    public adminBenutzerBean() {
        //this.ben = new Benutzer();
        this.abs = new EinsatzleitsoftwareService();
        this.bList = this.abs.getBenutzerListe();
    }
        
    public EinsatzleitsoftwareService getBenutzerService(){
        return abs;
    }
    
    public void setPupilManagerService(EinsatzleitsoftwareService pms){
        this.abs = pms;
    }
           
    public Object add(){
        this.ben.setId(this.bList.size()+1);
          
        this.abs.addBenutzer(ben);        
        
        this.ben = new Benutzer();
        return null;
    }
    
    public Object save(){
        Benutzer help = null;
        int i = -1;
        for(Benutzer p: this.abs.getBenutzerListe()){
            if(p.getId() == ben.getId())
                    help = p;
            else
                i++;
        }
        
        if(help != null){
            help.setId(ben.getId());
            help.setUsername(ben.getUsername());
            help.setAdmin(ben.isAdmin());
            help.setPassword(ben.getPassword());
            help.setPid(ben.getPid());
            
            this.bList.set(i, help);
        }
        return null;
    } 
    
    public Object remove(Benutzer p){
        this.abs.removeBenutzer(p);
        return null;
    }
    
    public Benutzer getBenutzer() {
        return ben;
    }

    public void setBenutzer(Benutzer fz) {
        this.ben = fz;
    }
    
    public Object edit(Benutzer p){
        ben.setId(p.getId());
        ben.setUsername(p.getUsername());
        ben.setAdmin(p.isAdmin());
        ben.setPassword(p.getPassword());
        ben.setPid(p.getPid());
        return null;
    }

    public List<Benutzer> getbList() {
        return bList;
    }

    public void setbList(List<Benutzer> bList) {
        this.bList = bList;
    }
    
    
}
