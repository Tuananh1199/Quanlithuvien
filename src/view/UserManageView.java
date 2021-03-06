/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controller.PrintPDF;
import static controller.PrintPDF.getCell;
import static controller.PrintPDF.getPara;
import controller.UserDAO;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import model.User;

/**
 *
 * @author Admin
 */
public class UserManageView extends javax.swing.JFrame implements ActionListener {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form UserManageView
     */
    public UserManageView() {
        initComponents();
        this.setTitle("Manage Users");
        this.setLocationRelativeTo(null);

        btnCancel.addActionListener(this);
        btnDeleteUS.addActionListener(this);
//        btnInsertUS.addActionListener(this);
        btnRefreshUS.addActionListener(this);
        btnResetUS.addActionListener(this);
        btnSearch.addActionListener(this);
        btnUpdateUS.addActionListener(this);
        btnPrint.addActionListener(this);

        showTblUS();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSDTus = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnRefreshUS = new javax.swing.JButton();
        btnUpdateUS = new javax.swing.JButton();
        txtEmaiilUS = new javax.swing.JTextField();
        txtBirthUS = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtDiachiUS = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMaUs = new javax.swing.JTextField();
        btnDeleteUS = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnResetUS = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUS = new javax.swing.JTable();
        txtTenUS = new javax.swing.JTextField();
        txtPassUS = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        cbbSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel11.setText("Họ và Tên:");

        btnRefreshUS.setText("Refesh");

        btnUpdateUS.setText("Updates");

        jLabel14.setText("Email:");

        jLabel12.setText("Ngày Sinh:");

        btnDeleteUS.setText("Delete");

        jLabel8.setText("Địa chỉ:");

        jLabel13.setText("SDT:");

        jLabel9.setText("Mã Người Dùng:");

        btnResetUS.setText("Reset");

        jLabel10.setText("Password:");

        tblUS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblUS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUSMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblUS);

        btnSearch.setText("Search");

        cbbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Họ Tên", "UserID", "SDT", "Địa Chỉ" }));

        btnCancel.setText("Cancel");

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnPrint.setText("Print ");
        btnPrint.setFocusable(false);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnPrint);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaUs, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmaiilUS, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBirthUS)
                                    .addComponent(txtTenUS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(21, 21, 21))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSDTus)
                                    .addComponent(txtDiachiUS, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(txtPassUS, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdateUS, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefreshUS, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteUS, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnResetUS, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(cbbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBirthUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmaiilUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDTus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiachiUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdateUS)
                            .addComponent(btnDeleteUS)
                            .addComponent(btnRefreshUS))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnResetUS)
                            .addComponent(btnCancel))
                        .addGap(77, 77, 77))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblUSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUSMouseClicked
        // TODO add your handling code here:
        int r = tblUS.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblUS.getModel();
        txtMaUs.setEditable(false);
        txtPassUS.setEditable(false);
        txtMaUs.setText(model.getValueAt(r, 1).toString());
        txtTenUS.setText(model.getValueAt(r, 2).toString());
        txtBirthUS.setText(model.getValueAt(r, 3).toString());
        txtEmaiilUS.setText(model.getValueAt(r, 4).toString());
        txtSDTus.setText(model.getValueAt(r, 5).toString());
        txtDiachiUS.setText(model.getValueAt(r, 6).toString());
        txtPassUS.setText(model.getValueAt(r, 7).toString());
    }//GEN-LAST:event_tblUSMouseClicked

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 120) {
                width = 120;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    public void showTblUS() {
        int i = 1;
        ArrayList<User> list = new UserDAO().getListUser();
        DefaultTableModel modelDoc = new DefaultTableModel();

        modelDoc.setColumnIdentifiers(new Object[]{
            "STT", "Mã User", "Họ và Tên", "Ngày Sinh", "Email", "SĐT", "Địa Chỉ", "Password"
        });

        for (User us : list) {
            modelDoc.addRow(new Object[]{
                i++, us.getId(), us.getName(), us.getBirth(), us.getEmail(), us.getPhone(), us.getAddress(), us.getPassword()});
        }
        tblUS.setModel(modelDoc);//set model cho table
        resizeColumnWidth(tblUS);
    }

    public void clickResetUS() {
        txtBirthUS.setText("");
        txtDiachiUS.setText("");
        txtEmaiilUS.setText("");
        txtMaUs.setText("");
        txtPassUS.setText("");
        txtSDTus.setText("");
        txtTenUS.setText("");

//        txtPassUS.setEditable(true);
    }

    public void clickUpdateUS() {
        int row = tblUS.getSelectedRow();
        String value = (tblUS.getModel().getValueAt(row, 1).toString());
        System.out.println(value);
        new UserDAO().updateUsr(value, txtTenUS.getText(),
                txtBirthUS.getText(), txtSDTus.getText(), txtEmaiilUS.getText(),
                txtDiachiUS.getText(), txtPassUS.getText());
        showTblUS();
        JOptionPane.showMessageDialog(rootPane, "Update Successfully!");
    }

    public void clickDeleteUS() {
        int row = tblUS.getSelectedRow();
        String value = (tblUS.getModel().getValueAt(row, 1).toString());
        System.out.println(value);

        if (new UserDAO().dateleUsr(value)) {
            showTblUS();
            JOptionPane.showMessageDialog(rootPane, "Delete Successfully!");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Không thể xóa!\nTài Khoản đã thực hiện giao dịch!");
        }
    }

    public void clickSearchUS() {
        int i = 1;
        ArrayList<User> list = null;
        String cbbValue = cbbSearch.getSelectedItem().toString();
        if ("UserID".equalsIgnoreCase(cbbValue)) {
            list = new UserDAO().getListSearchByID(txtSearch.getText());
        } else if ("Họ Tên".equalsIgnoreCase(cbbValue)) {
            list = new UserDAO().getListSearchByTen(txtSearch.getText());
        } else if ("SDT".equalsIgnoreCase(cbbValue)) {
            list = new UserDAO().getListSearchBySDT(txtSearch.getText());
        } else if ("Địa Chỉ".equalsIgnoreCase(cbbValue)) {
            list = new UserDAO().getListSearchByDiaChi(txtSearch.getText());
        }
        DefaultTableModel modelDoc = new DefaultTableModel();

        modelDoc.setColumnIdentifiers(new Object[]{
            "STT", "Mã User", "Họ và Tên", "Ngày Sinh", "Email", "SĐT", "Địa Chỉ", "Password"
        });

        for (User us : list) {
            modelDoc.addRow(new Object[]{
                i++, us.getId(), us.getName(), us.getBirth(), us.getEmail(), us.getPhone(), us.getAddress(), us.getPassword()});
        }
        tblUS.setModel(modelDoc);//set model cho table
        resizeColumnWidth(tblUS);
    }

    public void getreport() {
        int i = 1;
        int cnt = 1;
        Font fontArial = PrintPDF.createFont("C:\\Windows\\Fonts\\Arial.ttf", 12);
        Date today = new Date();
        String strToday = sdf.format(today);

        String query = "select * from tbluser";

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\BaoCaoPRJ\\BaoCaoPRJ\\QuanLyThuVien\\PrintReports\\Management"
                    + "\\User\\UserRP_" + cnt++ + "_" + strToday + ".pdf"));
            document.open();

            document.add(getPara("DANH SÁCH ĐỘC GIẢ TRONG THƯ VIỆN"));
            document.add(getPara("Hà Nội, " + new Date().toString()));
            document.add(getPara("\n-----------------------------------------------------------------------------------------\n"));
            document.add(new Paragraph("\n \n"));

            PdfPTable t = new PdfPTable(new float[]{0.5f, 1f, 1.5f, 1.5f, 1.5f, 1.5f, 1f});
            PdfPCell cell = new PdfPCell(new Paragraph("Thông Tin User", fontArial));
            cell.setColspan(7);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            t.addCell(cell);

            t.addCell(getCell("STT", PdfPCell.ALIGN_CENTER));
            t.addCell(getCell("UserID", PdfPCell.ALIGN_CENTER));
            t.addCell(getCell("Họ Tên", PdfPCell.ALIGN_CENTER));
            t.addCell(getCell("Ngày Sinh", PdfPCell.ALIGN_CENTER));
            t.addCell(getCell("Email", PdfPCell.ALIGN_CENTER));
            t.addCell(getCell("SĐT", PdfPCell.ALIGN_CENTER));
            t.addCell(getCell("Địa Chỉ", PdfPCell.ALIGN_CENTER));

            Connection con = UserDAO.getConnection();
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    t.addCell(Integer.toString(i));
                    t.addCell(Integer.toString(rs.getInt(1)));
                    t.addCell(new Phrase(rs.getString(2), fontArial));
                    t.addCell(new Phrase(sdf.format(rs.getDate(3)), fontArial));
                    t.addCell(new Phrase(rs.getString(4), fontArial));
                    t.addCell(new Phrase(rs.getString(5), fontArial));
                    t.addCell(new Phrase(rs.getString(6), fontArial));

                    i++;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            document.add(t);
            document.add(new Paragraph("\n\n"));
            document.add(getPara("\n----------------------------------------o0o----------------------------------------\n"));

            JOptionPane.showMessageDialog(rootPane, "Report Saved");

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

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
            java.util.logging.Logger.getLogger(UserManageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserManageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserManageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserManageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new UserManageView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteUS;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefreshUS;
    private javax.swing.JButton btnResetUS;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateUS;
    private javax.swing.JComboBox<String> cbbSearch;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblUS;
    private javax.swing.JTextField txtBirthUS;
    private javax.swing.JTextField txtDiachiUS;
    private javax.swing.JTextField txtEmaiilUS;
    private javax.swing.JTextField txtMaUs;
    private javax.swing.JTextField txtPassUS;
    private javax.swing.JTextField txtSDTus;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenUS;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDeleteUS) {
            int cf = JOptionPane.showConfirmDialog(rootPane, "Bạn Chắc Chắn Muốn Xóa?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (cf == JOptionPane.YES_OPTION) {
                clickDeleteUS();
            } else if (cf == JOptionPane.NO_OPTION) {
                //do nothing
            }
        } else if (e.getSource() == btnCancel) {
            new AdminView().setVisible(true);
            this.dispose();
        } else if (e.getSource() == btnRefreshUS) {
            showTblUS();
        } else if (e.getSource() == btnSearch) {
            clickSearchUS();
        } else if (e.getSource() == btnResetUS) {
            clickResetUS();
        } else if (e.getSource() == btnUpdateUS) {
            clickUpdateUS();
        } else if (e.getSource() == btnPrint) {
            getreport();
        }
    }
}
