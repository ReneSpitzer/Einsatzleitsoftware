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
public class Kontakt {
    private int kid;
    private String kname;
    private String bez;
    private long funknr;

    public Kontakt(int kid, String kname, String bez, long funknr) {
        this.kid = kid;
        this.kname = kname;
        this.bez = bez;
        this.funknr = funknr;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }

    public String getBez() {
        return bez;
    }

    public void setBez(String bez) {
        this.bez = bez;
    }

    public long getFunknr() {
        return funknr;
    }

    public void setFunknr(long funknr) {
        this.funknr = funknr;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.kid;
        hash = 31 * hash + Objects.hashCode(this.kname);
        hash = 31 * hash + Objects.hashCode(this.bez);
        hash = 31 * hash + (int) (this.funknr ^ (this.funknr >>> 32));
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
        final Kontakt other = (Kontakt) obj;
        if (this.kid != other.kid) {
            return false;
        }
        if (this.funknr != other.funknr) {
            return false;
        }
        if (!Objects.equals(this.kname, other.kname)) {
            return false;
        }
        if (!Objects.equals(this.bez, other.bez)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kontakt{" + "kid=" + kid + ", kname=" + kname + ", bez=" + bez + ", funknr=" + funknr + '}';
    }
}
