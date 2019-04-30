/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.Hasil;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Azhary Arliansyah
 */
public class FpGrowth {
    
    private Hasil panel_hasil;
    private DataTransaksiController data;
    private double support;
    private double confidence;
    private double minimum_support;
    
    public FpGrowth(DataTransaksiController data,double support,double confidence){
        this.panel_hasil = new Hasil("Aturan Asosiasi");
        this.data = data;
        this.support = support;
        this.confidence = confidence;
        this.minimum_support = this.support * 10;
    }
    
    public void doFpGrowth(){
//     ----- CUMA CONTOH BAE -----
        Main.writeLogProcess(" ", this.panel_hasil.getPanelLog());
        Main.writeLogProcess(" DEAR AZHARY ARLIANSYAH", this.panel_hasil.getPanelLog());
        Main.writeLogProcess(" Az Tolong Lanjutke Yang ini", this.panel_hasil.getPanelLog());
        Main.writeLogProcess(" Caro Set Log Proses samo Set Tabel Biso dilihat di kelas FP GROWTH", this.panel_hasil.getPanelLog());
        Main.writeLogProcess(" Caro Akses Data Jugo Pacak di jingok jugo", this.panel_hasil.getPanelLog());
        
        this.caraAksesData();
        
        String rule[] = {"A -> B","A -> C,B","A -> D,E","B -> C","C -> A,D"};
        double support[] = {0.1,0.3,0.5,0.6,0.25};
        double confidence[] = {0.4,0.9,0.5,0.5,0.7};
        this.setTabelAturanAsosiasi(rule, support, confidence);
        this.panel_hasil.setVisible(true);
        
        
        
//    ----------------------------
    }
    
//   ----- MODIFIKASI BAE METHOD INI DAK PAPO MEN GALAK, INI CONTOH BAE -----
    private void setTabelAturanAsosiasi(String[] rule, double[] support,double confidence[]){
         DefaultTableModel tabel = (DefaultTableModel) this.panel_hasil.getTabel().getModel();
         tabel.setRowCount(rule.length);
         for(int i=0;i<rule.length;i++){
             tabel.setValueAt(rule[i], i, 0);
             tabel.setValueAt(support[i], i, 1);
             tabel.setValueAt(confidence[i], i, 2);
         }
    }
//  ---------------------------------------------------------------------------
    

//   ----- METHOD INI UNTUK NYONGOK CARO NGAKSES DATA -----
    private void caraAksesData(){
        for(int i=0;i<this.data.getJumlahSeluruhTransaksi();i++){
            System.out.print(this.data.getDaftar_id_transaksi().get(i)+" ");
            for(String nama_item : this.data.getDaftar_seluruh_item().get(i)){
                System.out.print(nama_item+", ");
            }
            System.out.println("");
        }
    }
//  ---------------------------------------------------------------------------
    
    
  
}
