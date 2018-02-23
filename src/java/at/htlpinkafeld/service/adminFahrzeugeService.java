/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.service;

import at.htlpinkafeld.pojo.Fahrzeuge;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexa
 */
public class adminFahrzeugeService {
    private List<Fahrzeuge> fList;
    
    public adminFahrzeugeService(){
         this.fList = new ArrayList<>();
    }
    
    public List<Fahrzeuge> getFahrzeugList() {
        return fList;
    }

    public void setFahrzeugList(List<Fahrzeuge> fList2){
        this.fList = fList2;
    }
    
    public void addFahrzeug(Fahrzeuge f){
        this.fList.add(f);
    }
    
    public void removeFahrzeug(Fahrzeuge f){
        this.fList.remove(f);
    }
    
    public Fahrzeuge getFahrzeug(){
        return this.fList.get(this.fList.size()-1);
    } 
}
