/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.pojo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Bernhard
 */
public class Person {
    private int pid;
    private String vorname;
    private String nachname;
    private Date gebDat;
    private String str;
    private String hausnr;
    private String grad;
    private String email;
    private int telnr;
    
    public Person(){
        
    }

    public Person(int pid, String vorname, String nachname, Date gebDat, String str, String hausnr, String grad, String email, int telnr) {
        this.pid = pid;
        this.vorname = vorname;
        this.nachname = nachname;
        this.gebDat = gebDat;
        this.str = str;
        this.hausnr = hausnr;
        this.grad = grad;
        this.email = email;
        this.telnr = telnr;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Date getGebDat() {
        return gebDat;
    }

    public void setGebDat(Date gebDat) {
        this.gebDat = gebDat;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getHausnr() {
        return hausnr;
    }

    public void setHausnr(String hausnr) {
        this.hausnr = hausnr;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelnr() {
        return telnr;
    }

    public void setTelnr(int telnr) {
        this.telnr = telnr;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Person other = (Person) obj;
        if (this.pid != other.pid) {
            return false;
        }
        if (this.telnr != other.telnr) {
            return false;
        }
        if (!Objects.equals(this.vorname, other.vorname)) {
            return false;
        }
        if (!Objects.equals(this.nachname, other.nachname)) {
            return false;
        }
        if (!Objects.equals(this.str, other.str)) {
            return false;
        }
        if (!Objects.equals(this.hausnr, other.hausnr)) {
            return false;
        }
        if (!Objects.equals(this.grad, other.grad)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.gebDat, other.gebDat)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "pid=" + pid + ", vorname=" + vorname + ", nachname=" + nachname + ", gebDat=" + gebDat + ", str=" + str + ", hausnr=" + hausnr + ", grad=" + grad + ", email=" + email + ", telnr=" + telnr + '}';
    }
}
