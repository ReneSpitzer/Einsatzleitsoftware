/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Einsatz;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Bernhard
 */
@ManagedBean
@SessionScoped
public class EinsatzBean {
    private Einsatz einsatz;
    
    public EinsatzBean() {
    }

    public Einsatz getEinsatz() {
        return einsatz;
    }

    public void setEinsatz(Einsatz einsatz) {
        this.einsatz = einsatz;
    }
    
    public String edit(Einsatz e){
        this.einsatz = e;
   
        return "/einsatzerstellen.xhtml";
    }
     public String gastDetail(Einsatz e){
        this.einsatz = e;
   
        return "/gastDetailA.xhtml";
    }
    
    public Object newEinsatz(){
        this.einsatz = new Einsatz();
        
        return "einsatzanlegen.xhtml";
    }
    
}
