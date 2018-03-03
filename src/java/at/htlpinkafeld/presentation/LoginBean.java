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
 * @author Bernhard
 */
@ManagedBean
@SessionScoped
public class LoginBean {
@ManagedProperty(value="#{einsatzleitsoftwareService}")
     EinsatzleitsoftwareService einsatzleitsoftwares;

    public String username;
    public String password;
    public boolean visibleB=true;
    public boolean visibleLlogin =false;
    private boolean admin = false;

    List<Benutzer> benutzerliste = new ArrayList<>();

    public LoginBean() {
    }
     @PostConstruct
    public void setUp(){
            this.benutzerliste=this.einsatzleitsoftwares.getBenutzerListe();
  
     
    }
    
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    public boolean isVisibleB() {
        return visibleB;
    }

    public void setVisibleB(boolean visibleB) {
        this.visibleB = visibleB;
    }

    public EinsatzleitsoftwareService getEinsatzleitsoftwares() {
        return einsatzleitsoftwares;
    }

    public void setEinsatzleitsoftwares(EinsatzleitsoftwareService einsatzleitsoftwares) {
        this.einsatzleitsoftwares = einsatzleitsoftwares;
    }

    public boolean isVisibleLlogin() {
        return visibleLlogin;
    }

    public void setVisibleLlogin(boolean visibleLlogin) {
        this.visibleLlogin = visibleLlogin;
    }

    public List<Benutzer> getBenutzerliste() {
        return benutzerliste;
    }

    public void setBenutzerliste(List<Benutzer> benutzerliste) {
        this.benutzerliste = benutzerliste;
    }

 
    public Object doGastLogin(){
        this.visibleB=false;
        this.visibleLlogin=true;
        return "/gastAbgeschlosseneE.xhtml";
    }
    public LoginBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object doLogin() {
        this.visibleB=true;
        this.visibleLlogin=false;
        for (Benutzer b : benutzerliste) {
            if (b.getUsername().equals(username) && b.getPassword().equals(this.password)) {
                return "/uebersichtauswahl.xhtml";
            }
        }

        return "/login.xhtml";
    }

    public void setVisibleL(boolean visibleL) {
        this.visibleLlogin = visibleL;
    }

    public boolean isVisibleL() {
        return visibleLlogin;
    }
    
    
}
