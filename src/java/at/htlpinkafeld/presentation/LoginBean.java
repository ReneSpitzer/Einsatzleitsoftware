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

   // @ManagedProperty(value = "#{einsatzleitsoftwareService}")
   // private EinsatzleitsoftwareService service;
    public String username;
    public String password;

    List<Benutzer> BList = new ArrayList<>();

    public LoginBean() {
        BList.add(new Benutzer(1,"Herbert",false,"1234ABC"));
    }
/*
    @PostConstruct
    public void set() {
        BList = service.getBenutzerListe();
    }
*/
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
        for (Benutzer b : BList) {
            if (b.getUsername().equals(username) && b.getPassword().equals(this.password)) {
                return "/uebersichtauswahl.xhtml";
            }
        }

        return "/login.xhtml";
    }
}