/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import controller.DataLoaderController;
import controller.Main;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;


/**
 *
 * @author M.Hakim Amransyah
 */
public class Home extends javax.swing.JFrame {

    private Main main;
    private DataLoaderController data_loader_controller;
    
    public Home(Main main) {
        initComponents();
        this.centeringDataTable();
        this.main = main;
    }

    private Home() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        tittle_panel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        content_panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        content_data = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_transaksi = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        log_data = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        progressbar_load_data = new javax.swing.JProgressBar();
        muatData = new javax.swing.JButton();
        content_control = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        confidence_label = new javax.swing.JTextField();
        support_label = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        progressbar_fpgrowth = new javax.swing.JProgressBar();
        doFPGROWTH = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tugas Akhir Ratih");

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.PAGE_AXIS));

        tittle_panel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEtchedBorder()));
        tittle_panel.setLayout(new javax.swing.BoxLayout(tittle_panel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(700, 50));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Mining Asosiasi");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, java.awt.BorderLayout.CENTER);

        tittle_panel.add(jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setPreferredSize(new java.awt.Dimension(700, 50));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Frequent Pattern - Growth Algorithm");
        jPanel4.add(jLabel2, java.awt.BorderLayout.CENTER);

        tittle_panel.add(jPanel4);

        jPanel6.add(tittle_panel);

        content_panel.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        content_data.setBackground(new java.awt.Color(0, 102, 102));
        content_data.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(906, 200));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tabel_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id Penjualan", "Barang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_transaksi.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabel_transaksi.setAutoscrolls(false);
        tabel_transaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabel_transaksi.setGridColor(new java.awt.Color(0, 0, 0));
        tabel_transaksi.setRowHeight(25);
        tabel_transaksi.setSelectionBackground(new java.awt.Color(255, 255, 0));
        tabel_transaksi.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tabel_transaksi);
        if (tabel_transaksi.getColumnModel().getColumnCount() > 0) {
            tabel_transaksi.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabel_transaksi.getColumnModel().getColumn(1).setPreferredWidth(2000);
        }

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5);

        jPanel8.setBackground(new java.awt.Color(0, 255, 102));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Log Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        log_data.setBackground(new java.awt.Color(255, 255, 255));
        log_data.setPreferredSize(new java.awt.Dimension(887, 120));
        log_data.setLayout(new javax.swing.BoxLayout(log_data, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane2.setViewportView(log_data);

        jPanel8.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel8);

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setPreferredSize(new java.awt.Dimension(906, 40));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel9.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel9.setLayout(new java.awt.BorderLayout());

        progressbar_load_data.setForeground(new java.awt.Color(204, 0, 0));
        progressbar_load_data.setStringPainted(true);
        jPanel9.add(progressbar_load_data, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel9, java.awt.BorderLayout.LINE_END);

        muatData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/browse.png"))); // NOI18N
        muatData.setText(" Data");
        muatData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        muatData.setFocusPainted(false);
        muatData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                muatDataActionPerformed(evt);
            }
        });
        jPanel7.add(muatData, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel7);

        content_data.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.add(content_data);

        content_control.setBackground(new java.awt.Color(255, 204, 0));
        content_control.setPreferredSize(new java.awt.Dimension(906, 140));
        content_control.setLayout(new javax.swing.BoxLayout(content_control, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel12.setBackground(new java.awt.Color(0, 255, 102));
        jPanel12.setPreferredSize(new java.awt.Dimension(908, 80));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Konfigurasi"));

        jLabel3.setText("Support");

        jLabel4.setText("Confidence");

        confidence_label.setText("0.3");

        support_label.setText("0.2");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(60, 60, 60)
                .addComponent(support_label, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(42, 42, 42)
                .addComponent(confidence_label, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(confidence_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(support_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.add(jPanel10, java.awt.BorderLayout.CENTER);

        content_control.add(jPanel12);

        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel16.setPreferredSize(new java.awt.Dimension(906, 25));
        jPanel16.setLayout(new java.awt.BorderLayout());

        jPanel17.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel17.setLayout(new java.awt.BorderLayout());

        progressbar_fpgrowth.setForeground(new java.awt.Color(204, 0, 0));
        progressbar_fpgrowth.setStringPainted(true);
        jPanel17.add(progressbar_fpgrowth, java.awt.BorderLayout.CENTER);

        jPanel16.add(jPanel17, java.awt.BorderLayout.LINE_END);

        doFPGROWTH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/start.png"))); // NOI18N
        doFPGROWTH.setText("fp-growth");
        doFPGROWTH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        doFPGROWTH.setFocusPainted(false);
        doFPGROWTH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doFPGROWTHActionPerformed(evt);
            }
        });
        jPanel16.add(doFPGROWTH, java.awt.BorderLayout.CENTER);

        content_control.add(jPanel16);

        jPanel1.add(content_control);

        content_panel.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel6.add(content_panel);

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void muatDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_muatDataActionPerformed
       this.data_loader_controller = new DataLoaderController(this.log_data,this.muatData,this.doFPGROWTH,this.progressbar_load_data,this.tabel_transaksi);
       data_loader_controller.execute();
    }//GEN-LAST:event_muatDataActionPerformed

    private void doFPGROWTHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doFPGROWTHActionPerformed
        // TODO add your handling code here:
        if(this.data_loader_controller != null){
                double support    = Double.parseDouble(this.support_label.getText());
                 double confidence = Double.parseDouble(this.confidence_label.getText());
                 this.main.doFpGrowth(this.data_loader_controller.getLoad_data(),support,confidence,this.progressbar_fpgrowth,this.doFPGROWTH); 
        }else{
            JOptionPane.showMessageDialog(null,"Data Belom Ada", "OoOps !!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_doFPGROWTHActionPerformed
     
    private void centeringDataTable(){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        this.tabel_transaksi.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField confidence_label;
    private javax.swing.JPanel content_control;
    private javax.swing.JPanel content_data;
    private javax.swing.JPanel content_panel;
    private javax.swing.JButton doFPGROWTH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel log_data;
    private javax.swing.JButton muatData;
    private javax.swing.JProgressBar progressbar_fpgrowth;
    private javax.swing.JProgressBar progressbar_load_data;
    private javax.swing.JTextField support_label;
    private javax.swing.JTable tabel_transaksi;
    private javax.swing.JPanel tittle_panel;
    // End of variables declaration//GEN-END:variables
}
