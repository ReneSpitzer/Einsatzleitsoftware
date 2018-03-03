/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.pojo;

/**
 *
 * @author Bernhard Fuchs
 */
public class Counter implements Identifiable{
    private int cid;
    private int cnt;

    public Counter(){}
    
    public Counter(int cnt)
    {
        this.cnt = cnt;
    }

    public Counter(int cid, int cnt) {
        this.cid = cid;
        this.cnt = cnt;
    }
    
    @Override
    public void setId(int id) {
        this.cid = id;
    }

    @Override
    public int getId() {
        return this.cid;
    }
    
    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
    
}
