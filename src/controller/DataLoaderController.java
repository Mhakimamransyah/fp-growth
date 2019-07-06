/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Item;
import Entity.Transaksi;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author M.Hakim Amransyah
 */
public class DataLoaderController extends SwingWorker{
     
    private DataTransaksiController load_data;
    private double maksimum_row_value;
    private JPanel panel_log_data;
    private JButton tombol_muat_data;
    private JButton tombol_do_fp_growth;
    private JProgressBar progress_muat_data;
    private JTable tabel_transaksi;
    
    public DataLoaderController(JPanel panel,JButton tombol,JButton tombol_fp_growth, JProgressBar progress, JTable tabel){
        this.panel_log_data              = panel;
        this.tombol_muat_data   = tombol;
        this.tombol_do_fp_growth = tombol_fp_growth;
        this.progress_muat_data = progress;
        this.tabel_transaksi    = tabel;
    }
    
    @Override
    protected Object doInBackground() throws Exception {
       JFileChooser file_chooser = new JFileChooser();
       String header[],data_value, temp[];
       file_chooser.setCurrentDirectory(new File("E:\\"));
       file_chooser.setFileFilter(new FileNameExtensionFilter("csv file", "csv"));
       if(file_chooser.showOpenDialog(this.panel_log_data) == JFileChooser.APPROVE_OPTION){
            this.setTungguLoadDataGUI();
            this.load_data = new DataTransaksiController();
            File f            = file_chooser.getSelectedFile();      
            BufferedReader bf = new BufferedReader(new FileReader(f.getPath())); 
            BufferedReader bf_2 = new BufferedReader(new FileReader(f.getPath())); 
            this.maksimum_row_value = this.countFileRow(bf_2);
            this.progress_muat_data.setMaximum(100);
            header            = bf.readLine().split(",");                 
            int iter_data = 1;
            while((data_value = bf.readLine())!=null){
              double progress = (iter_data/this.maksimum_row_value)*100;
              this.progress_muat_data.setValue((int) progress);
              this.progress_muat_data.setString(new DecimalFormat("#.##").format(((iter_data/this.maksimum_row_value)*100)).replaceAll(",",".")+" %");
              temp = data_value.split(",");
              this.load_data.tambahTransaksi(temp[0], temp[1]);
              iter_data++;
            }
            this.setTabel();
            Main.writeLogProcess("", this.panel_log_data);
            Main.writeLogProcess("  Jumlah Seluruh Transaksi : "+this.load_data.getJumlahSeluruhTransaksi(),this.panel_log_data);
            Main.writeLogProcess("  Jumlah Seluruh Item        : "+this.load_data.getJumlahSeluruhItem(),this.panel_log_data);
       }
        return null;
    }
    
    
    private void setTabel(){
        DefaultTableModel tabel = (DefaultTableModel) this.tabel_transaksi.getModel();
        tabel.setRowCount(this.load_data.getJumlahSeluruhTransaksi());
        String daftar_item;
        
        for(int i=0;i<this.load_data.getJumlahSeluruhTransaksi();i++){
            
            tabel.setValueAt(this.load_data.getDaftar_id_transaksi().get(i), i, 0);
            ArrayList<String> item = this.load_data.getDaftar_seluruh_item().get(i);
            daftar_item = "";
            for(String nama_item : item){
                
                daftar_item = daftar_item+ nama_item+", ";
            }
            tabel.setValueAt(daftar_item, i, 1);
            
        }
    }
    
    
    public DataTransaksiController getLoad_data() {
        
        return load_data;
    }
    
    private double countFileRow(BufferedReader bf){
        double count=0;
        try {
            bf.readLine().split(",");
            String data_value;
            while((data_value = bf.readLine())!=null){
               count++;
            }
        } catch (IOException ex) {
            Logger.getLogger(DataLoaderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
    private void setTungguLoadDataGUI(){
        this.tombol_muat_data.setEnabled(false);
        this.tombol_do_fp_growth.setEnabled(false);
        this.progress_muat_data.setValue(0);
        this.progress_muat_data.setString("Loading Data");
        this.panel_log_data.removeAll();
    }
    
    @Override
    protected void done(){
       this.tombol_muat_data.setEnabled(true);
       this.tombol_do_fp_growth.setEnabled(true);
       this.progress_muat_data.setString("Data Loaded");
    }
}
