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
public class Funkgeraet implements Identifiable{
    private int fid;
    private String bez;
    private int nr;
    
    public Funkgeraet(){
        
    }

    public Funkgeraet(String bez, int nr) {
        this.bez = bez;
        this.nr = nr;
    }
    
    public Funkgeraet(int fid, String bez, int nr) {
        this.fid = fid;
        this.bez = bez;
        this.nr = nr;
    }

    @Override
    public int getId() {
        return fid;
    }

    @Override
    public void setId(int id) {
        this.fid = fid;
    }

    public String getBez() {
        return bez;
    }

    public void setBez(String bez) {
        this.bez = bez;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.fid;
        hash = 59 * hash + Objects.hashCode(this.bez);
        hash = 59 * hash + this.nr;
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
        final Funkgeraet other = (Funkgeraet) obj;
        if (this.fid != other.fid) {
            return false;
        }
        if (this.nr != other.nr) {
            return false;
        }
        if (!Objects.equals(this.bez, other.bez)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funkgeraet{" + "fid=" + fid + ", bez=" + bez + ", nr=" + nr + '}';
    }
}
