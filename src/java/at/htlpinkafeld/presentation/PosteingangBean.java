/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Kontakt;
import at.htlpinkafeld.service.EinsatzleitsoftwareService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rene-_000
 */
 @ManagedBean
 @SessionScoped
public class PosteingangBean {
     @ManagedProperty(value="#{einsatzleitsoftwareService}")
     EinsatzleitsoftwareService einsatzleitsoftwares;

    public PosteingangBean() {
    }
     
     
     
  
}
