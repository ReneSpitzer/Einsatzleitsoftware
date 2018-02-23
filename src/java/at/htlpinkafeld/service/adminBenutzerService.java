/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.service;

import at.htlpinkafeld.pojo.Benutzer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexa
 */
public class adminBenutzerService {
    private List<Benutzer> bList;
    
    public adminBenutzerService(){
         this.bList = new ArrayList<>();
    }
    
    public List<Benutzer> getBenutzerList() {
        return bList;
    }

    public void setBenutzerList(List<Benutzer> bList2){
        this.bList = bList2;
    }
    
    public void addBenutzer(Benutzer f){
        this.bList.add(f);
    }
    
    public void removeBenutzer(Benutzer f){
        this.bList.remove(f);
    }
    
    public Benutzer getFahrzeug(){
        return this.bList.get(this.bList.size()-1);
    } 
}