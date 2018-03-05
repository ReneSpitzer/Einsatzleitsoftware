/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.pojo;

/**
 *
 * @author Bernhard
 */
public class Nuessler implements Identifiable{

    private int nid;
    private int unnr;
    private String stoffname;
    private int merkblattnr;
    private String info;
    private int aegl21;
    private int aegl22;
    private double agw;

    public Nuessler() {
        this(0,"",0,"",0,0,0.0);
    }
    
    public Nuessler(int nid, int unnr, String stoffname, int merkblattnr, String info, int aegl21, int aegl22, double agw) {
        this.nid = nid;
        this.unnr = unnr;
        this.stoffname = stoffname;
        this.merkblattnr = merkblattnr;
        this.info = info;
        this.aegl21 = aegl21;
        this.aegl22 = aegl22;
        this.agw = agw;
    }

    public Nuessler(int unnr, String stoffname, int merkblattnr, String info, int aegl21, int aegl22, double agw) {
        this.unnr = unnr;
        this.stoffname = stoffname;
        this.merkblattnr = merkblattnr;
        this.info = info;
        this.aegl21 = aegl21;
        this.aegl22 = aegl22;
        this.agw = agw;
    }
    
    public Nuessler(int unnr, String stoffname, int aegl21, int aegl22, double agw) {
        this.unnr = unnr;
        this.stoffname = stoffname;
        this.aegl21 = aegl21;
        this.aegl22 = aegl22;
        this.agw = agw;
    }
    
    public Nuessler(Nuessler n) {
        this.nid = n.nid;
        this.unnr = n.unnr;
        this.stoffname = n.stoffname;
        this.merkblattnr = n.merkblattnr;
        this.info = n.info;
        this.aegl21 = n.aegl21;
        this.aegl22 = n.aegl22;
        this.agw = n.agw;
    }
    
    @Override
    public int getId() {
        return nid;
    }

    @Override
    public void setId(int id) {
        this.nid = id;
    }

    public int getUnnr() {
        return unnr;
    }

    public void setUnnr(int unnr) {
        this.unnr = unnr;
    }

    public String getStoffname() {
        return stoffname;
    }

    public void setStoffname(String stoffname) {
        this.stoffname = stoffname;
    }

    public int getMerkblattnr() {
        return merkblattnr;
    }

    public void setMerkblattnr(int merkblattnr) {
        this.merkblattnr = merkblattnr;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public int getAegl21() {
        return aegl21;
    }

    public void setAegl21(int aegl21) {
        this.aegl21 = aegl21;
    }

    public int getAegl22() {
        return aegl22;
    }

    public void setAegl22(int aegl22) {
        this.aegl22 = aegl22;
    }

    public double getAgw() {
        return agw;
    }

    public void setAgw(double agw) {
        this.agw = agw;
    }
}
