/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;

import at.htlpinkafeld.pojo.Einsatz;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rene-_000
 */
@ManagedBean
@SessionScoped
public class EinsatzBean {
   List<Einsatz> EList= new ArrayList<>();
   Einsatz einsatz;
    public EinsatzBean(){
        EList.add(new Einsatz("Brand"));
        EList.add(new Einsatz("Brand1"));
        EList.add(new Einsatz("Brand3"));
        EList.add(new Einsatz("Brand4"));
        
    }

    public Einsatz getEinsatz() {
        return einsatz;
    }

    public void setEinsatz(Einsatz einsatz) {
        this.einsatz = einsatz;
    }
    

    public List<Einsatz> getEList() {
        return EList;
    }
    public Object createEinsatz(){
        EList.add(einsatz);
        return true;
        
    }
    public Object showDetail(){
        return true;
    }

    public void setEList(List<Einsatz> EList) {
        this.EList = EList;
    }
    
}
