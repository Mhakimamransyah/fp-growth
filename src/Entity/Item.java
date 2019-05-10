/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Azhary Arliansyah
 */
public class Item {
    
    private String nama;
    
    public Item(String nama) {
        this.nama = nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNama() {
        return this.nama;
    } 
    
}
