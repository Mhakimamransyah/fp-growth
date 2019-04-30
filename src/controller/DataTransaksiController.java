/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author M.Hakim Amransyah
 */
public class DataTransaksiController {
    
    private ArrayList<String>    daftar_id_seluruh_transaksi;
    private ArrayList<ArrayList<String>> daftar_seluruh_item;
  
    public DataTransaksiController(){
        this.daftar_id_seluruh_transaksi     = new ArrayList<String>();
        this.daftar_seluruh_item  = new ArrayList<ArrayList<String>>();
    }
    
    public void tambahTransaksi(String id_transaksi, String nama_item){
        if(this.daftar_id_seluruh_transaksi.size() > 0){
            if(this.daftar_id_seluruh_transaksi.contains(id_transaksi)){
                int index = this.daftar_id_seluruh_transaksi.indexOf(id_transaksi);
                ArrayList<String> item = this.daftar_seluruh_item.get(index);
                if(!item.contains(nama_item)){
                   item.add(nama_item);
                   this.daftar_seluruh_item.set(index, item);
                }
            }else{
                this.setTransaksiBaru(id_transaksi, nama_item);
            }
        }else{
           this.setTransaksiBaru(id_transaksi, nama_item);
        }
    }
    
    public int getJumlahSeluruhTransaksi(){
       return this.daftar_id_seluruh_transaksi.size();
    }
    
    public int getJumlahSeluruhItem(){
       ArrayList<String> temp = new ArrayList<String>();
       for(int i=0;i<this.getJumlahSeluruhTransaksi();i++){
          for(String nama_item : this.daftar_seluruh_item.get(i)){
              if(!temp.contains(nama_item)){
                  temp.add(nama_item);
              }
          }
       }
       return temp.size();
    }
    
    public void cetakSeluruhTransaksi(){
        int index = 0;
        for(String id : this.daftar_id_seluruh_transaksi){
            System.out.print(id+" ");
            ArrayList<String> item = this.daftar_seluruh_item.get(index);
            for(String nama_item : item){
                System.out.print(nama_item+", ");
            }
            System.out.println("");
            index++;
        }
    }
    
    private void setTransaksiBaru(String id, String nama){
        this.daftar_id_seluruh_transaksi.add(id);
        ArrayList<String> item = new ArrayList<String>();
        item.add(nama);
        this.daftar_seluruh_item.add(item);
    }
    
    public ArrayList<String> getDaftar_id_transaksi() {
        return daftar_id_seluruh_transaksi;
    }

    public ArrayList<ArrayList<String>> getDaftar_seluruh_item() {
        return daftar_seluruh_item;
    }
}
