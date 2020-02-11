/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class AdminMainFrame extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form AdminMainFrame
     */
    public AdminMainFrame() {
        initComponents();
        this.setTitle("Home Page");
        this.setLocationRelativeTo(null);
        
        btnDKMuonTra.addActionListener(this);
        btnHome.addActionListener(this);
        btnManDoc.addActionListener(this);
        btnManDoc.addActionListener(this);
        btnTraTL.addActionListener(this);
        btnThongKe.addActionListener(this);
        
    }
    
    public void switchPanel(JPanel panel){
        pnHome.removeAll();
        pnHome.add(panel);
        pnHome.repaint();
        pnHome.revalidate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnHome = new javax.swing.JButton();
        btnDKMuonTra = new javax.swing.JButton();
        btnTraTL = new javax.swing.JButton();
        btnManDoc = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        pnHome = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnHome.setText(" Trang Chủ ");
        btnHome.setFocusable(false);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnHome);

        btnDKMuonTra.setText(" Đăng Ký Mượn ");
        btnDKMuonTra.setFocusable(false);
        btnDKMuonTra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDKMuonTra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnDKMuonTra);

        btnTraTL.setText(" Trả Tài Liệu ");
        btnTraTL.setFocusable(false);
        btnTraTL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTraTL.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnTraTL);

        btnManDoc.setText(" Quản Lý Tài Liệu ");
        btnManDoc.setFocusable(false);
        btnManDoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnManDoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnManDoc);

        jButton5.setText(" Quản Lý User ");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        btnThongKe.setText(" Thống Kê");
        btnThongKe.setFocusable(false);
        btnThongKe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThongKe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnThongKe);

        pnHome.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
            .addComponent(pnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnHome, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AdminMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Set the jTattoo look and feel */
        try {
            javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");

        } catch (Exception e) {
            System.err.println("Look and feel not set.");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMainFrame().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnThongKe){
//            switchPanel(new ThongKeTaiLieu().pnThongke);
        }else if(e.getSource() == btnManDoc){
            switchPanel(new DocManageView().pnDocMan);
        }else if(e.getSource() == btnHome){
            pnHome.removeAll();
            pnHome.repaint();
            pnHome.revalidate();
        }else if(e.getSource() == btnDKMuonTra){
            switchPanel(new DKMuonTraView().pnDKMT);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDKMuonTra;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnManDoc;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTraTL;
    private javax.swing.JButton jButton5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel pnHome;
    // End of variables declaration//GEN-END:variables
}