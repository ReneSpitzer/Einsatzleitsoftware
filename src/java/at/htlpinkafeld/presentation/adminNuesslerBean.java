/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;


import at.htlpinkafeld.pojo.Nuessler;
import at.htlpinkafeld.service.EinsatzleitsoftwareService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author alex
 */

@ManagedBean
@SessionScoped
public class adminNuesslerBean {

    @ManagedProperty(value="#{einsatzleitsoftwareService}")
    EinsatzleitsoftwareService ans;
    
    private Nuessler nus = new Nuessler();
    private List<Nuessler> nList = new ArrayList<>();
    
    /**
     * Creates a new instance of adminBenutzerBean
     */
    
    @PostConstruct
    public void SetUp(){
        //this.nList = this.ans.getNüsslerList();
    }
    
    public adminNuesslerBean() {
           //this.nus = new Nüssler();
           this.ans = new EinsatzleitsoftwareService();
           this.nList = this.ans.getNüsslerList();
    }
    
    
    public EinsatzleitsoftwareService getNuesslerService(){
        return ans;
    }
    
    public void setNuesslerService(EinsatzleitsoftwareService pms){
        this.ans = pms;
    }
           
    public Object add(){
        nus.setId(this.nList.size()+1);
        this.ans.addNuessler(nus);
    
        this.nus= new Nuessler();
        return null;
    }
    
    public Object save(){
        Nuessler help = null;
        int i = -1;
        for(Nuessler p: this.ans.getNüsslerList()){
            if(p.getId() == nus.getId() && p.getUnnr() == nus.getUnnr())
                    help = p;
            else 
                  i++;
        }
        
        if(help != null){
            help.setId(nus.getId());
            help.setUnnr(nus.getUnnr());
            help.setMerkblattnr(nus.getMerkblattnr());
            help.setStoffname(nus.getStoffname());
            help.setInfo(nus.getInfo());
            
            this.nList.set(i, help);
        }
        return null;
    }
    
    public Object remove(Nuessler p){
        this.ans.removeNuessler(p);
        return null;
    }
    
    public Nuessler getNuessler() {
        return nus;
    }

    public void setNuessler(Nuessler fz) {
        this.nus = fz;
    }
    
    public Object edit(Nuessler p){
        nus.setId(p.getId());
        nus.setUnnr(p.getUnnr());
        nus.setStoffname(p.getStoffname());
        nus.setMerkblattnr(p.getMerkblattnr());
        nus.setInfo(p.getInfo());
        return null;
    }

    public List<Nuessler> getnList() {
        return nList;
    }

    public void setnList(List<Nuessler> nList) {
        this.nList = nList;
    }
    
    
    
}
