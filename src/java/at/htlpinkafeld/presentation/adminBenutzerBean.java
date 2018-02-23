/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Benutzer;
import at.htlpinkafeld.service.adminBenutzerService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author alexa
 */
@ManagedBean
@SessionScoped
public class adminBenutzerBean {

    private adminBenutzerService abs;
    
    private Benutzer ben;
    /**
     * Creates a new instance of adminBenutzerBean
     */
    public adminBenutzerBean() {
        this.ben = new Benutzer();
        this.abs = new adminBenutzerService();
    }
    
    
    public adminBenutzerService getBenutzerService(){
        return abs;
    }
    
    public void setPupilManagerService(adminBenutzerService pms){
        this.abs = pms;
    }
           
    public Object add(){
        ben.setId(this.abs.getBenutzerList().indexOf(ben));
          
        this.abs.addBenutzer(ben);
      
       
        
        return null;
    }
    
    public Object save(){
        Benutzer help = null;
        for(Benutzer p: this.abs.getBenutzerList()){
            if(p.getId() == ben.getId())
                    help = p;
        }
        
        if(help != null){
            help.setId(ben.getId());
            help.setUsername(ben.getUsername());
            help.setAdmin(ben.isAdmin());
            help.setPassword(ben.getPassword());
            help.setPid(ben.getPid());
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
}
