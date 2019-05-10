/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Item;
import Entity.Transaksi;
import View.Hasil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Azhary Arliansyah
 */
public class FpGrowth {
    
    private List<Transaksi> daftarTransaksi;
    private Map<String, Integer> itemSupportCount;
    private List<Map.Entry<String, Integer>> sortedItemSupportCount;
    private int minimumSupportCount = 0;
    private List<String> removedItems;
    private Map<String, Map<String, Integer>> conditionalFPTree;
    private Map<String, Map<String, Double>> ruleSupports;
    private Map<String, Map<String, Double>> ruleConfidences;
    private Map<String, Integer> jumlahTransaksiItem;
    
    private Hasil panel_hasil;
    
    public FpGrowth(List<Transaksi> daftarTransaksi) {
        this.daftarTransaksi = daftarTransaksi;
        this.itemSupportCount = new HashMap<>();
        this.sortedItemSupportCount = new ArrayList<>();
        this.removedItems = new ArrayList<>();
        this.conditionalFPTree = new HashMap<>();
        this.jumlahTransaksiItem = new HashMap<>();
        this.ruleSupports = new HashMap<>();
        this.ruleConfidences = new HashMap<>();
        this.panel_hasil = new Hasil("Aturan Asosiasi");
    }
    
    public FpGrowth(List<Transaksi> daftarTransaksi, int minimumSupportCount) {
        this.daftarTransaksi = daftarTransaksi;
        this.itemSupportCount = new HashMap<>();
        this.sortedItemSupportCount = new ArrayList<>();
        this.removedItems = new ArrayList<>();
        this.minimumSupportCount = minimumSupportCount;
        this.conditionalFPTree = new HashMap<>();
        this.jumlahTransaksiItem = new HashMap<>();
        this.ruleSupports = new HashMap<>();
        this.ruleConfidences = new HashMap<>();
        this.panel_hasil = new Hasil("Aturan Asosiasi");
    }
    
    public void fit(double minSupport, double minConfidence) {
        this.calculateSupportCount();
        this.filterSupportCount();
        this.daftarTransaksi = this.resetTransaction();
        this.conditionalFPTree = 
                this.generateConditionalFPTree();
        this.filterFPTree();
//        System.out.println("FPTREE SIZE: " + this.conditionalFPTree.size());
//        for (Map.Entry<String, Map<String, Integer>> e : 
//                this.conditionalFPTree.entrySet()) {
//            System.out.println(e.getKey() + ": " + e.getValue().size());
//            for (Map.Entry<String, Integer> ee : e.getValue().entrySet()) {
//                System.out.println("\t" + ee.getKey() + ": " + ee.getValue());
//            }
//        }
        
        this.calculateRuleSupportsAndConfidences(minSupport, minConfidence);
        DefaultTableModel tabel = (DefaultTableModel) this.panel_hasil
                .getTabel().getModel();
        int totalRows = 0;
        for (Map.Entry<String, Map<String, Integer>> e : 
                this.conditionalFPTree.entrySet()) {
            totalRows += e.getValue().size();
        }
        tabel.setRowCount(totalRows);
        int i = 0;
        for (Map.Entry<String, Map<String, Integer>> e : 
                this.conditionalFPTree.entrySet()) {
            for (Map.Entry<String, Integer> ee : e.getValue().entrySet()) {
//                System.out.println(e.getKey() + " => " + ee.getKey() + 
//                        "(" + this.ruleSupports
//                                .get(e.getKey())
//                                .get(ee.getKey()) + ", " + 
//                                this.ruleConfidences
//                                .get(e.getKey())
//                                .get(ee.getKey()) +")");
                
                    tabel.setValueAt(e.getKey() + " => " + ee.getKey(), i, 0);
                    if (this.ruleSupports.get(e.getKey()) == null || 
                            this.ruleConfidences.get(e.getKey()) == null) {
                        continue;
                    }
                    tabel.setValueAt(this.ruleSupports
                                .get(e.getKey())
                                .get(ee.getKey()), i, 1);
                    tabel.setValueAt(this.ruleConfidences
                                .get(e.getKey())
                                .get(ee.getKey()), i, 2);
                    Main.writeLogProcess(e.getKey() + " => " + ee.getKey() + 
                        "(" + this.ruleSupports
                                .get(e.getKey())
                                .get(ee.getKey()) + ", " + 
                                this.ruleConfidences
                                .get(e.getKey())
                                .get(ee.getKey()) +")", 
                        this.panel_hasil.getPanelLog());
                    i++;
            }
        }
        
        this.panel_hasil.setVisible(true);
        if (i <= 0) {
            JOptionPane.showMessageDialog(null,"Jumlah aturan asosiasi yang "
                    + "telah difilter sebanyak 0 baris. "
                    + "Silahkan gunakan nilai support dan "
                    + "confidence yang berbeda.", 
                    "OoOps !!",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void calculateSupportCount() {
        this.itemSupportCount = new HashMap<>();
        this.daftarTransaksi.forEach(transaksi -> {
            List<Item> daftarItem = transaksi.getItem();
            Set<String> countedItems = new HashSet<>();
            
            for (Item item : daftarItem) {
                String namaItem = item.getNama();
                if (this.itemSupportCount.containsKey(namaItem)) {
                    int supportCount = this.itemSupportCount.get(namaItem);
                    this.itemSupportCount.put(namaItem, supportCount + 1);
                } else {
                    this.itemSupportCount.put(namaItem, 1);
                }
                
                if (this.jumlahTransaksiItem.containsKey(namaItem) && 
                        !countedItems.contains(namaItem)) {
                    int jumlahItem = this.jumlahTransaksiItem.get(namaItem);
                    this.jumlahTransaksiItem.put(namaItem, jumlahItem + 1);
                } else {
                    this.jumlahTransaksiItem.put(namaItem, 1);
                }
                countedItems.add(namaItem);
            }
        });
    }
    
    private void filterSupportCount() {
        this.removedItems = new ArrayList<>();
        Set<String> supportCountKeys = new HashSet<>(this.itemSupportCount.keySet());
        for (String k : supportCountKeys) {
            if (this.itemSupportCount.get(k) < 
                    this.minimumSupportCount) {
                Item newItem = new Item(k);
                this.removedItems.add(newItem.getNama());
                this.itemSupportCount.remove(k);
            }
        }
        
        this.sortedItemSupportCount = 
                MathFx.sortMapInteger(this.itemSupportCount);
    }
    
    private List<Transaksi> resetTransaction() {
        System.out.println("START RESET TRANSACTION");
        final List<Transaksi> daftarTransaksi = new ArrayList<>();
        
        final List<String> sortedOrder = new ArrayList<>();
        this.sortedItemSupportCount.forEach(supportCount -> {
            Item newItem = new Item(supportCount.getKey());
            sortedOrder.add(newItem.getNama());
        });
        
        this.daftarTransaksi.forEach(transaksi -> {
            Transaksi transaksiBaru = new Transaksi(transaksi.getIdTransaksi());
            Item[] daftarItemBaru = new Item[sortedOrder.size()];
            List<Item> daftarItem = transaksi.getItem();
            
            daftarItem.forEach(item -> {
                if (!this.removedItems.contains(item.getNama())) {
                    int idx = sortedOrder.indexOf(item.getNama());
                    if (idx != -1) {
                        daftarItemBaru[idx] = item;
                    }
                }
            });
            
            List<Item> itemList = Arrays.asList(daftarItemBaru);
            List<Item> newItemList = new ArrayList<>();
            for (Item il : itemList) {
                if (il != null) {
                    newItemList.add(il);
                }
            }
            transaksiBaru.setItem(newItemList);
            
            daftarTransaksi.add(transaksiBaru);
        });
        System.out.println("END RESET TRANSACTION");
        return daftarTransaksi;
    }
    
    private Map<String, Map<String, Integer>> generateConditionalFPTree() {
        System.out.println("START GENERATING FPTREE");
        final Map<String, Map<String, Integer>> conditionalFPTree = 
                new HashMap<>();
        
        this.daftarTransaksi.forEach(transaksi -> {
            List<Item> daftarItem = transaksi.getItem();
            if (daftarItem.size() <= 0) {
                return; // continue
            }
//            daftarItem.stream().filter(value -> value != null);
            List<Item> temporary = new ArrayList<>(daftarItem);
            Item lastItem = temporary.remove(temporary.size() - 1);
            
            Map<String, Integer> FPTree;
            if (conditionalFPTree.containsKey(lastItem.getNama())) {
                FPTree = conditionalFPTree.get(lastItem.getNama());
            } else {
                FPTree = new HashMap<>();
            } 

            for (int i = 0; i < temporary.size(); i++) {
                int n = 0;
                if (FPTree.containsKey(temporary.get(i).getNama())) {
                    n = FPTree.get(temporary.get(i).getNama());
                }
                FPTree.put(temporary.get(i).getNama(), n + 1);                
                
                
                for (int k = 1; k < temporary.size(); k++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(temporary.get(i).getNama());
                    for (int j = i + k; j < temporary.size(); j++) {
                        if (!temporary
                                .get(j)
                                .getNama()
                                .equals(temporary
                                        .get(i)
                                        .getNama())) {
                            sb.append("#" + temporary.get(j).getNama());
                            int nn = 0;
                            if (FPTree.containsKey(sb.toString())) {
                                nn = FPTree.get(sb.toString());
                            }
                            FPTree.put(sb.toString(), nn + 1);
                        }
                    }
                }
            }
            
            conditionalFPTree.put(lastItem.getNama(), FPTree);
        });
        System.out.println("END GENERATING FPTREE");
        return conditionalFPTree;
    }
    
    private void filterFPTree() {
        Map<String, Map<String, Integer>> temporary = 
                new HashMap<>(this.conditionalFPTree);
        temporary.forEach((key, value) -> {
            Set<String> FPTreeKeys = new HashSet<>(value.keySet());
            Map<String, Integer> FPTree = new HashMap<>(value);
            for (String k : FPTreeKeys) {
                if (FPTree.get(k) < 
                        this.minimumSupportCount) {
                    FPTree.remove(k);
                }
            }
            if (FPTree.size() <= 0) {
                this.conditionalFPTree.remove(key);
                return;
            }
            this.conditionalFPTree.put(key, FPTree);
        });
        
    }
    
    private void calculateRuleSupportsAndConfidences() {
        for (Map.Entry<String, Map<String, Integer>> e : 
                this.conditionalFPTree.entrySet()) {
            
            
            Map<String, Double> supports = this.ruleSupports.get(e.getKey());
            if (supports == null) {
                supports = new HashMap<>();
            }
            
            Map<String, Double> confidences = this.ruleConfidences.get(e.getKey());
            if (confidences == null) {
                confidences = new HashMap<>();
            }
            
            for (Map.Entry<String, Integer> ee : e.getValue().entrySet()) {
                double supportRatio = (double)ee.getValue() / 
                        (double)this.daftarTransaksi.size();
                double confidenceRatio = (double)ee.getValue() / 
                        (double)this.jumlahTransaksiItem.get(e.getKey());
                
                supports.put(ee.getKey(), supportRatio);
                confidences.put(ee.getKey(), confidenceRatio);
            }
            
            this.ruleSupports.put(e.getKey(), supports);
            this.ruleConfidences.put(e.getKey(), confidences);
        }
    }
    
    private void calculateRuleSupportsAndConfidences(double minSupport, 
            double minConfidence) {
        for (Map.Entry<String, Map<String, Integer>> e : 
                this.conditionalFPTree.entrySet()) {
            Map<String, Double> supports = this.ruleSupports.get(e.getKey());
            if (supports == null) {
                supports = new HashMap<>();
            }
            
            Map<String, Double> confidences = this.ruleConfidences.get(e.getKey());
            if (confidences == null) {
                confidences = new HashMap<>();
            }
            
            for (Map.Entry<String, Integer> ee : e.getValue().entrySet()) {
                double supportRatio = (double)ee.getValue() / 
                        (double)this.daftarTransaksi.size();
                double confidenceRatio = (double)ee.getValue() / 
                        (double)this.jumlahTransaksiItem.get(e.getKey());
                
                if (supportRatio < minSupport || 
                        confidenceRatio < minConfidence) {
                    continue;
                }
                
                supports.put(ee.getKey(), supportRatio);
                confidences.put(ee.getKey(), confidenceRatio);
            }
            
            if (supports.size() <= 0 || confidences.size() <= 0) {
                continue;
            }
            
            this.ruleSupports.put(e.getKey(), supports);
            this.ruleConfidences.put(e.getKey(), confidences);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
