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
    private EinsatzleitsoftwareService abs;
    
    private Benutzer ben = new Benutzer();
    private List<Benutzer> bList = new ArrayList<>();
    /**
     * Creates a new instance of adminBenutzerBean
     */
    
    @PostConstruct
    public void SetUp(){
        //this.bList = this.abs.getBenutzerListe();
         //this.abs = new EinsatzleitsoftwareService();
        this.bList = this.abs.getBenutzerListe();
    }
    
    public adminBenutzerBean() {
        //this.ben = new Benutzer();
       
    }

    public EinsatzleitsoftwareService getAbs() {
        return abs;
    }

    public void setAbs(EinsatzleitsoftwareService abs) {
        this.abs = abs;
    }

    public Benutzer getBen() {
        return ben;
    }

    public void setBen(Benutzer ben) {
        this.ben = ben;
    }

    
           
    public Object add(){
        if(this.ben.getId()!=0){
            this.bList.set((this.ben.getId()-1), ben);
        }else{
            this.ben.setId(this.bList.size()+1);        
            this.abs.addBenutzer(ben);        
        }
        this.ben = new Benutzer();
        return null;
    }
    
    

    public Object remove(Benutzer p){
        this.abs.removeBenutzer(p);
        return null;
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
