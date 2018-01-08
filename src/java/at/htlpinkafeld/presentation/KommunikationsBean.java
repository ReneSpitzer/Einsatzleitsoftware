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
public class KommunikationsBean {
 
 private List<Einsatz> ArchivierteEinsätze=new ArrayList();
 
    public KommunikationsBean(){
        
    }

    public List<Einsatz> getArchivierteEinsätze() {
        return ArchivierteEinsätze;
    }

    public void setArchivierteEinsätze(List<Einsatz> ArchivierteEinsätze) {
        this.ArchivierteEinsätze = ArchivierteEinsätze;
    }
    
    
    
}
