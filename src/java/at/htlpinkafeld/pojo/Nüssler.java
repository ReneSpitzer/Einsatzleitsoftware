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
public class Nüssler implements Identifiable{

    private int nid;
    private int UNnr;
    private String stoffname;
    private int merkblattnr;
    private int radius_innen;
    private int radius_außen;
    private String info;

    public Nüssler(int UNnr, String stoffname, int merkblattnr, int radius_innen, int radius_außen, String info) {
        this.UNnr = UNnr;
        this.stoffname = stoffname;
        this.merkblattnr = merkblattnr;
        this.radius_innen = radius_innen;
        this.radius_außen = radius_außen;
        this.info = info;
    }
    
    public Nüssler(int nid, int UNnr, String stoffname, int merkblattnr, int radius_innen, int radius_außen, String info) {
        this.nid = nid;
        this.UNnr = UNnr;
        this.stoffname = stoffname;
        this.merkblattnr = merkblattnr;
        this.radius_innen = radius_innen;
        this.radius_außen = radius_außen;
        this.info = info;
    }
    
    @Override
    public int getId() {
        return nid;
    }

    @Override
    public void setId(int id) {
        this.nid = id;
    }

    public int getUNnr() {
        return UNnr;
    }

    public void setUNnr(int UNnr) {
        this.UNnr = UNnr;
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

    public int getRadius_innen() {
        return radius_innen;
    }

    public void setRadius_innen(int radius_innen) {
        this.radius_innen = radius_innen;
    }

    public int getRadius_außen() {
        return radius_außen;
    }

    public void setRadius_außen(int radius_außen) {
        this.radius_außen = radius_außen;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
