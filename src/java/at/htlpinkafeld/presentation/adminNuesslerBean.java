/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.presentation;


import at.htlpinkafeld.pojo.Nüssler;
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
    
    private Nüssler nus = new Nüssler();
    private List<Nüssler> nList = new ArrayList<>();
    
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
    
        this.nus= new Nüssler();
        return null;
    }
    
    public Object save(){
        Nüssler help = null;
        int i = -1;
        for(Nüssler p: this.ans.getNüsslerList()){
            if(p.getId() == nus.getId() && p.getUNnr() == nus.getUNnr())
                    help = p;
            else 
                  i++;
        }
        
        if(help != null){
            help.setId(nus.getId());
            help.setUNnr(nus.getUNnr());
            help.setMerkblattnr(nus.getMerkblattnr());
            help.setStoffname(nus.getStoffname());
            help.setRadius_innen(nus.getRadius_innen());
            help.setRadius_außen(nus.getRadius_außen());
            help.setInfo(nus.getInfo());
            
            this.nList.set(i, help);
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

    public List<Nüssler> getnList() {
        return nList;
    }

    public void setnList(List<Nüssler> nList) {
        this.nList = nList;
    }
    
    
    
}
