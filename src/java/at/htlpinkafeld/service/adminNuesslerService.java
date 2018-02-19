/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.service;

import at.htlpinkafeld.pojo.Nüssler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexa
 */
public class adminNuesslerService {
    private List<Nüssler> nList;
    
    public adminNuesslerService(){
         this.nList = new ArrayList<>();
    }
    
    public List<Nüssler> getNüsslerList() {
        return nList;
    }

    public void setNüsslerList(List<Nüssler> bList2){
        this.nList = bList2;
    }
    
    public void addNüssler(Nüssler f){
        this.nList.add(f);
    }
    
    public void removeNüssler(Nüssler f){
        this.nList.remove(f);
    }
    
    public Nüssler getNüssler(){
        return this.nList.get(this.nList.size()-1);
    }
}
