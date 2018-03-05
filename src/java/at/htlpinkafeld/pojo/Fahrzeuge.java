/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.pojo;

import java.util.Objects;

/**
 *
 * @author Bernhard
 */
public class Fahrzeuge implements Identifiable{
    private int fid;
    private String organisation;
    private String ort;
    private String type;
    private int anzPers;
    private boolean verfuegbar;
    private String name;
    private Benutzer benutzer;
    private int bid;

    public Fahrzeuge(){}
    
    public Fahrzeuge(String organisation, String ort, String type, int anzPers, boolean verfuegbar, String name, int bid) {
        this.organisation = organisation;
        this.ort = ort;
        this.type = type;
        this.anzPers = anzPers;
        this.verfuegbar = verfuegbar;
        this.name = name;
    }
    
    public Fahrzeuge(int fid, String organisation, String ort, String type, int anzPers, boolean verfuegbar, String name, int bid) {
        this.fid = fid;
        this.organisation = organisation;
        this.ort = ort;
        this.type = type;
        this.anzPers = anzPers;
        this.verfuegbar = verfuegbar;
        this.name = name;
    }

    @Override
    public int getId() {
        return fid;
    }

    @Override
    public void setId(int fid) {
        this.fid = fid;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAnzPers() {
        return anzPers;
    }

    public void setAnzPers(int anzPers) {
        this.anzPers = anzPers;
    }

    public boolean isVerfuegbar() {
        return verfuegbar;
    }

    public void setVerfuegbar(boolean verfuegbar) {
        this.verfuegbar = verfuegbar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.fid;
        hash = 97 * hash + Objects.hashCode(this.organisation);
        hash = 97 * hash + Objects.hashCode(this.ort);
        hash = 97 * hash + Objects.hashCode(this.type);
        hash = 97 * hash + this.anzPers;
        hash = 97 * hash + Objects.hashCode(this.verfuegbar);
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fahrzeuge other = (Fahrzeuge) obj;
        if (this.fid != other.fid) {
            return false;
        }
        if (this.anzPers != other.anzPers) {
            return false;
        }
        if (this.verfuegbar != other.verfuegbar) {
            return false;
        }
        if (!Objects.equals(this.organisation, other.organisation)) {
            return false;
        }
        if (!Objects.equals(this.ort, other.ort)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fahrzeug{" + "fid=" + fid + ", organisation=" + organisation + ", ort=" + ort + ", type=" + type + ", anzPers=" + anzPers + ", status=" + verfuegbar + ", name=" + name + '}';
    }
}
