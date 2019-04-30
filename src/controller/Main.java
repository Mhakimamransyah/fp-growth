/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.Home;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author M.Hakim Amransyah
 */
public class Main {
    
    public static void main(String[] args) {
        Main main = new Main();
        main.tampilkanFrame();
    }
    
    private void tampilkanFrame(){
        Home home = new Home(this);
        home.setVisible(true);
    }
    
    public void doFpGrowth(DataTransaksiController data, double support, double confidence){
        if(data != null && data.getJumlahSeluruhTransaksi() > 0){
           FpGrowth fp_growth = new FpGrowth(data,support,confidence);
           fp_growth.doFpGrowth();
        }else{
            JOptionPane.showMessageDialog(null,"Data Kok Kosong ? ", "OoOps !!",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void writeLogProcess(String text,JPanel Panel){
        JLabel label =new JLabel(" "+text);
        label.setFont(new Font("Segoe UI Symbol",Font.PLAIN,14));
        Panel.add(label);
        Panel.revalidate();
        Panel.repaint();
    }
    
}
