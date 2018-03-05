/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;


import at.htlpinkafeld.pojo.Nuessler;
import at.htlpinkafeld.service.EinsatzleitsoftwareService;
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
    private EinsatzleitsoftwareService ans;
    
    private Nuessler nus;
    
    /**
     * Creates a new instance of adminBenutzerBean
     */
    
    @PostConstruct
    public void SetUp(){
        
    }
    
    public adminNuesslerBean() {
           this.nus = new Nuessler();
           this.ans = new EinsatzleitsoftwareService();
    }
    
    
    public EinsatzleitsoftwareService getNuesslerService(){
        return ans;
    }
    
    public void setNuesslerService(EinsatzleitsoftwareService pms){
        this.ans = pms;
    }
           
    public Object add(){
        nus.setId(this.ans.getNüsslerList().indexOf(nus));
        this.ans.addNuessler(nus);
    
        
        return null;
    }
    
    public Object save(){
        Nuessler help = null;
        for(Nuessler p: this.ans.getNüsslerList()){
            if(p.getId() == nus.getId() && p.getUnnr() == nus.getUnnr())
                    help = p;
        }
        
        if(help != null){
            help.setId(nus.getId());
            help.setUnnr(nus.getUnnr());
            help.setMerkblattnr(nus.getMerkblattnr());
            help.setStoffname(nus.getStoffname());
            help.setInfo(nus.getInfo());
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
    
}
