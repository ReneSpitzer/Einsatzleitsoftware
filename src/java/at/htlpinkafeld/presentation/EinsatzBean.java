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
    private String header = "Einsatz";
    private Einsatz einsatz;
    private boolean editID=true;
    
    public EinsatzBean() {
    }

    public Einsatz getEinsatz() {
        return einsatz;
    }

    public void setEinsatz(Einsatz einsatz) {
        this.einsatz = einsatz;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public boolean isEditID() {
        return editID;
    }
    
    public void setEditID(boolean editID) {
        this.editID = editID;
    }
    
    public String edit(Einsatz e){
        this.header = "Einsatz bearbeiten";
        this.einsatz = e;
        editID=false;
   
        return "/einsatzerstellen.xhtml";
    }
     public String gastDetail(Einsatz e){
        this.header = "Einsatz anzeigen";
        this.einsatz = e;
        editID=false;
   
        return "/gastDetailA.xhtml";
    }
    
    public String newEinsatz(){
        this.header = "Neuer Einsatz";
        this.einsatz = new Einsatz();
        editID=true;
        
        return "einsatzerstellen.xhtml";
    }
    
}
