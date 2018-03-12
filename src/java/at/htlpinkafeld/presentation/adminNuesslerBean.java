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
    private EinsatzleitsoftwareService einsatzleitsoftwareService;
    
    private Nuessler nus = new Nuessler();
    private List<Nuessler> nList= new ArrayList<>();
    
    /**
     * Creates a new instance of adminBenutzerBean
     */
    
    @PostConstruct
    public void SetUp(){
        //this.nList = this.einsatzleitsoftwareService.getNüsslerList();
        this.nList = this.einsatzleitsoftwareService.getNüsslerList();
    }
    
    public adminNuesslerBean() {
           //this.nus = new Nüssler();
           //this.einsatzleitsoftwareService = new EinsatzleitsoftwareService();    
    }

    public EinsatzleitsoftwareService getEinsatzleitsoftwareService() {
        return einsatzleitsoftwareService;
    }

    public void setEinsatzleitsoftwareService(EinsatzleitsoftwareService einsatzleitsoftwareService) {
        this.einsatzleitsoftwareService = einsatzleitsoftwareService;
    }

 
    public Nuessler getNus() {
        return nus;
    }

    public void setNus(Nuessler nus) {
        this.nus = nus;
    }
    
    
           
    public Object add(){
        if(this.nus.getId()!=0){
            this.nList.set((this.nus.getId()-1), nus);
        }else{
            nus.setId(this.nList.size()+1);
            this.einsatzleitsoftwareService.addNuessler(nus);
        }
        
        this.nus= new Nuessler();
        return null;
    }
    
    
    public Object remove(Nuessler p){
        this.einsatzleitsoftwareService.removeNuessler(p);
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
        nus.setAegl21(p.getAegl21());
        nus.setAegl22(p.getAegl22());
        nus.setAgw(p.getAgw());
        return null;
    }

    public List<Nuessler> getnList() {
        return nList;
    }

    public void setnList(List<Nuessler> nList) {
        this.nList = nList;
    }
    
    
    
}
