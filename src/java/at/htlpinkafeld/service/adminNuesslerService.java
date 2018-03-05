/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.service;

import at.htlpinkafeld.pojo.Nuessler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexa
 */
public class adminNuesslerService {
    private List<Nuessler> nList;
    
    public adminNuesslerService(){
         this.nList = new ArrayList<>();
    }
    
    public List<Nuessler> getNüsslerList() {
        return nList;
    }

    public void setNüsslerList(List<Nuessler> bList2){
        this.nList = bList2;
    }
    
    public void addNüssler(Nuessler f){
        this.nList.add(f);
    }
    
    public void removeNüssler(Nuessler f){
        this.nList.remove(f);
    }
    
    public Nuessler getNüssler(){
        return this.nList.get(this.nList.size()-1);
    }
}
