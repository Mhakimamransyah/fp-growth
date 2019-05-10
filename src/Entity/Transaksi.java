/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;

/**
 *
 * @author Azhary Arliansyah
 */
public class Transaksi {
    
    private String idTransaksi;
    private List<Item> item;
    
    public Transaksi(String idTransaksi, List<Item> item) {
        this.idTransaksi = idTransaksi;
        this.item = item;
    }
    
    public Transaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
        this.item = null;
    }
    
    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }
    
    public void setItem(List<Item> item) {
        this.item = item;
    }
    
    public void addItem(Item item) {
        this.item.add(item);
    }
    
    public String getIdTransaksi() {
        return this.idTransaksi;
    }
    
    public List<Item> getItem() {
        return this.item;
    }
}
