/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Einsatz;
import at.htlpinkafeld.service.EinsatzleitsoftwareService;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Bernhard
 */
@ManagedBean
@SessionScoped
public class EinsatzBean {
    @ManagedProperty(value="#{einsatzleitsoftwareService}")
     EinsatzleitsoftwareService einsatzleitsoftwares;
    
    private Einsatz einsatz;
    
    public EinsatzBean() {
    }

    @PostConstruct
    public void setUp(){
        
        this.einsatz=this.einsatzleitsoftwares.getEinsatz(); 
    }
    
    public EinsatzleitsoftwareService getEinsatzleitsoftwares() {
        return einsatzleitsoftwares;
    }

    public void setEinsatzleitsoftwares(EinsatzleitsoftwareService einsatzleitsoftwares) {
        this.einsatzleitsoftwares = einsatzleitsoftwares;
    }
    
    public Einsatz getEinsatz() {
        return einsatz;
    }

    public void setEinsatz(Einsatz einsatz) {
        this.einsatz = einsatz;
    } 
   
    public String gastDetail(Einsatz e){
        this.einsatz = e;
   
        return "/gastDetailA.xhtml";
    }
     
    public String edit(Einsatz e){
        this.einsatz = e;
    
        return "/einsatzerstellen.xhtml";
    }
    
    public Object newEinsatz(){
        this.einsatz = new Einsatz();
        this.einsatz.setId(this.einsatzleitsoftwares.getEinsatzlist().size() + 1);
        
        return "einsatzanlegen.xhtml";
    }
    
}
