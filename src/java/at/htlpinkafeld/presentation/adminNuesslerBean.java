/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;


import at.htlpinkafeld.pojo.Nüssler;
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
    
    private Nüssler nus;
    
    /**
     * Creates a new instance of adminBenutzerBean
     */
    
    @PostConstruct
    public void SetUp(){
        
    }
    
    public adminNuesslerBean() {
           this.nus = new Nüssler();
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
        Nüssler help = null;
        for(Nüssler p: this.ans.getNüsslerList()){
            if(p.getId() == nus.getId() && p.getUNnr() == nus.getUNnr())
                    help = p;
        }
        
        if(help != null){
            help.setId(nus.getId());
            help.setUNnr(nus.getUNnr());
            help.setMerkblattnr(nus.getMerkblattnr());
            help.setStoffname(nus.getStoffname());
            help.setRadius_innen(nus.getRadius_innen());
            help.setRadius_außen(nus.getRadius_außen());
            help.setInfo(nus.getInfo());
        }
        return null;
    }
    
    public Object remove(Nüssler p){
        this.ans.removeNuessler(p);
        return null;
    }
    
    public Nüssler getNuessler() {
        return nus;
    }

    public void setNuessler(Nüssler fz) {
        this.nus = fz;
    }
    
    public Object edit(Nüssler p){
        nus.setId(p.getId());
        nus.setUNnr(p.getUNnr());
        nus.setStoffname(p.getStoffname());
        nus.setRadius_innen(p.getRadius_innen());
        nus.setRadius_außen(p.getRadius_außen());
        nus.setMerkblattnr(p.getMerkblattnr());
        nus.setInfo(p.getInfo());
        return null;
    }
    
}
