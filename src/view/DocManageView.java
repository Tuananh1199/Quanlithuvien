/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controller.DocumentDAO;
import controller.PrintPDF;
import static controller.PrintPDF.getCell;
import static controller.PrintPDF.getPara;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import model.Document;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class DocManageView extends javax.swing.JFrame implements ActionListener {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private String maTL;

    /**
     * Creates new form DocManageView
     */
    public DocManageView() {
        initComponents();
        this.setTitle("Documents Management");
        this.setLocationRelativeTo(null);
        btnCancel.addActionListener(this);
        btnDelete.addActionListener(this);
        btnInsert.addActionListener(this);
        btnSearch.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnRefresh.addActionListener(this);
        btnReset.addActionListener(this);
        btnPrint.addActionListener(this);
        
        btnRefreshClick();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnDocMan = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtNXB = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDoc = new javax.swing.JTable();
        ComboBox1 = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        radCon = new javax.swing.JRadioButton();
        btnReset = new javax.swing.JButton();
        txtMaTL = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTacGia = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        radHet = new javax.swing.JRadioButton();
        txtType = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("NXB");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel7.setText("Manage Documents");

        tblDoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDocMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDoc);

        ComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TenSach", "MaTL", "TheLoai", "TacGia", "NXB", "TrangThai" }));

        jLabel6.setText("TrangThai");

        buttonGroup1.add(radCon);
        radCon.setText("Còn");

        btnReset.setText("Reset");

        jLabel8.setText("MaTL");

        jLabel2.setText("TheLoai");

        btnInsert.setText("Thêm");

        jLabel5.setText("SoLuong");

        jLabel1.setText("TenSach");

        btnDelete.setText("Xóa");

        btnCancel.setText("Cancel");

        buttonGroup1.add(radHet);
        radHet.setText("Hết");

        btnSearch.setText("Search");

        btnUpdate.setText("Sửa");

        jLabel3.setText("TacGia");

        btnRefresh.setText("Refresh");

        javax.swing.GroupLayout pnDocManLayout = new javax.swing.GroupLayout(pnDocMan);
        pnDocMan.setLayout(pnDocManLayout);
        pnDocManLayout.setHorizontalGroup(
            pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDocManLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDocManLayout.createSequentialGroup()
                        .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDocManLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDocManLayout.createSequentialGroup()
                                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(pnDocManLayout.createSequentialGroup()
                                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19)))
                                .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDocManLayout.createSequentialGroup()
                                .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnDocManLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnDocManLayout.createSequentialGroup()
                                                .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(pnDocManLayout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                                            .addGroup(pnDocManLayout.createSequentialGroup()
                                                                .addGap(37, 37, 37)
                                                                .addComponent(radCon)
                                                                .addGap(42, 42, 42)
                                                                .addComponent(radHet))))
                                                    .addGroup(pnDocManLayout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtNXB))))))
                                    .addComponent(txtTacGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnDocManLayout.createSequentialGroup()
                                        .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnDocManLayout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(16, 16, 16))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDocManLayout.createSequentialGroup()
                                                .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)))
                                        .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtMaTL)
                                                .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                                .addComponent(txtType, javax.swing.GroupLayout.Alignment.TRAILING)))))
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane2))
                    .addGroup(pnDocManLayout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnDocManLayout.setVerticalGroup(
            pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDocManLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDocManLayout.createSequentialGroup()
                        .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(27, 27, 27)
                        .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(radCon)
                            .addComponent(radHet))
                        .addGap(18, 18, 18)
                        .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsert)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete))
                        .addGap(26, 26, 26)
                        .addGroup(pnDocManLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel)
                            .addComponent(btnRefresh)
                            .addComponent(btnReset))
                        .addGap(39, 39, 39))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnPrint.setText("Print");
        btnPrint.setFocusable(false);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnPrint);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDocMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDocMan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDocMouseClicked
        int r = tblDoc.getSelectedRow();
        DefaultTableModel modelDoc = (DefaultTableModel) tblDoc.getModel();
        //modelDoc dang co 8 cot tu 0-7
        txtMaTL.setEditable(false);
        txtMaTL.setText(modelDoc.getValueAt(r, 1).toString());
        txtName.setText(modelDoc.getValueAt(r, 2).toString());
        txtType.setText(modelDoc.getValueAt(r, 3).toString());
        txtTacGia.setText(modelDoc.getValueAt(r, 4).toString());
        txtNXB.setText(modelDoc.getValueAt(r, 5).toString());
        txtSoLuong.setText(modelDoc.getValueAt(r, 6).toString());
        String state = modelDoc.getValueAt(r, 7).toString();
        if ("Còn".equalsIgnoreCase(state) || "Con".equalsIgnoreCase(state)) {
            radCon.setSelected(true);
        } else if ("Hết".equalsIgnoreCase(state) || "Het".equalsIgnoreCase(state)) {
            radHet.setSelected(true);
        }
        maTL = modelDoc.getValueAt(r, 1).toString();
    }//GEN-LAST:event_tblDocMouseClicked

//    -------------------------------------------------------------------------
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

//    -------------------------------------------------------------------------
    public void btnRefreshClick() {//chuc nang chinh la cap nhat data va in lai bang
        int i = 1;
        ArrayList<Document> listDoc = new DocumentDAO().getListDocument();
        DefaultTableModel modelDoc = new DefaultTableModel();

        modelDoc.setColumnIdentifiers(new Object[]{
            "STT", "MaTL", "TenSach", "TheLoai", "TacGia", "NXB", "SoLuong", "TrangThai"
        });

        for (Document doc : listDoc) {
            modelDoc.addRow(new Object[]{
                i++, doc.getId(), doc.getName(), doc.getType(), doc.getTacGia(), doc.getNxb(), doc.getSoLuong(), doc.getTrangThai()
            });
        }
        tblDoc.setModel(modelDoc);//set model cho table
        resizeColumnWidth(tblDoc);
    }
//    ----------------------------------------------------------------------------

    public void btnResetClick() {
        txtMaTL.setEditable(true);
        txtMaTL.setText("");
        txtNXB.setText("");
        txtName.setText("");
        txtSearch.setText("");
        txtSoLuong.setText("");
        txtTacGia.setText("");
        txtType.setText("");
        radCon.setSelected(false);
        radHet.setSelected(false);
//        txtTrangThai.setText("");
    }

  

//    ----------------------------------------------------------------------------
    public void btnInsertClick() {

        ArrayList<Document> listDoc = new DocumentDAO().getListDocument();

        Document doc = new Document();
        doc.setId(txtMaTL.getText());
        doc.setName(txtName.getText());
        doc.setNxb(txtNXB.getText());
        doc.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        doc.setTacGia(txtTacGia.getText());
        if (radCon.isSelected()) {
            doc.setTrangThai("Còn");
        } else if (radHet.isSelected()) {
            doc.setTrangThai("Hết");
        }
        doc.setType(txtType.getText());

        if (new DocumentDAO().addNewDoc(doc)) { //Kiem Tra data co them dc vao CSDL hay ko
            JOptionPane.showMessageDialog(rootPane, "Insert Successfully!");
            listDoc.add(doc);
        } else {
            JOptionPane.showMessageDialog(rootPane, "ERROR!");
        }
        btnRefreshClick();
//        new InsertDocs().setVisible(true);
//        new InsertDocs().show();
//        this.dispose();
    }

//    ----------------------------------------------------------------------------
    public void btnUpdateClick() {
        try {
            Connection conn = DocumentDAO.getConnection();

            int row = tblDoc.getSelectedRow();
            String value = (tblDoc.getModel().getValueAt(row, 1).toString());
            System.out.println(value);
            String query = "UPDATE tblTaiLieu SET TenSach = ?, TheLoai = ?, TacGia = ?, NXB = ?, SoLuong = ?, TrangThai = ? WHERE MaTL = '" + value + "'";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, txtName.getText());
            pst.setString(2, txtType.getText());
            pst.setString(3, txtTacGia.getText());
            pst.setString(4, txtNXB.getText());
            pst.setString(5, txtSoLuong.getText());
            if (radCon.isSelected()) {
                pst.setString(6, "Còn");
            } else if (radHet.isSelected()) {
                pst.setString(6, "Hết");
            }

            pst.executeUpdate();

            //showtable
            btnRefreshClick();
            JOptionPane.showMessageDialog(rootPane, "Updated Successfully!");

        } catch (SQLException e) {
//            System.out.println("Error COnnection!");
            e.printStackTrace();
        }
    }
//    ----------------------------------------------------------------------------

    public boolean CanDelete() {
        boolean status = false;
        try {
            Connection conn = DocumentDAO.getConnection();

            int row = tblDoc.getSelectedRow();
            String value = (tblDoc.getModel().getValueAt(row, 1).toString());
            System.out.println(value);
            String query = "DELETE FROM tblTaiLieu WHERE MaTL = '" + value + "'";

            PreparedStatement pst = conn.prepareStatement(query);
            status = pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    public void btnDeleteClick() {
        if (CanDelete()) {
            //showtable
            btnRefreshClick();
            JOptionPane.showMessageDialog(rootPane, "Deleted Successfully!");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Không xóa được tài liệu!\nTài liệu đã dùng!");
        }

    }

//    -----------------------------------------------------------------------------
    public void btnSearchClick() {
        int i = 1;
        ArrayList<Document> docList = null;
        String boxValue = (String) ComboBox1.getSelectedItem();
        if (boxValue.equals("TenSach")) {
            docList = new DocumentDAO().getListDocSearchByNAME(txtSearch.getText());
        } else if (boxValue.equals("MaTL")) {
            docList = new DocumentDAO().getListDocSearchByMATL(txtSearch.getText());
        } else if (boxValue.equals("TheLoai")) {
            docList = new DocumentDAO().getListDocSearchByTYPE(txtSearch.getText());
        } else if (boxValue.equals("TacGia")) {
            docList = new DocumentDAO().getListDocSearchByTACGIA(txtSearch.getText());
        } else if (boxValue.equals("NXB")) {
            docList = new DocumentDAO().getListDocSearchByNXB(txtSearch.getText());
        } else if (boxValue.equals("TrangThai")) {
            docList = new DocumentDAO().getListDocSearchBySTATE(txtSearch.getText());
        }
        DefaultTableModel modelDoc;
        modelDoc = new DefaultTableModel();
//        modelDoc = (DefaultTableModel) tblSearch.getModel();

        modelDoc.setColumnIdentifiers(new Object[]{
            "STT", "MaTL", "TenSach", "TheLoai", "TacGia", "NXB", "SoLuong", "TrangThai"
        });

        for (Document doc : docList) {
            modelDoc.addRow(new Object[]{
                i++, doc.getId(), doc.getName(), doc.getType(), doc.getTacGia(), doc.getNxb(), doc.getSoLuong(), doc.getTrangThai()
            });
        }
        tblDoc.setModel(modelDoc);
        resizeColumnWidth(tblDoc);
    }

//    -----------------------------------------------------------------------------
    public void getReport() {
        int i = 1;
        int cnt = 1;
        com.itextpdf.text.Font fontArial = PrintPDF.createFont("C:\\Windows\\Fonts\\Arial.ttf", 12);
        Date today = new Date();
        String strToday = sdf.format(today);

        String query = "select * from tblTaiLieu";

        try {
            com.itextpdf.text.Document document = new com.itextpdf.text.Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\BaoCaoPRJ\\BaoCaoPRJ\\QuanLyThuVien\\PrintReports\\Management"
                    + "\\Document\\DocumentRP_"+ cnt++ +"_" + strToday + ".pdf"));
            document.open();

            document.add(getPara("DANH SÁCH TÀI LIỆU TRONG THƯ VIỆN"));
            document.add(getPara("Hà Nội, " + new Date().toString()));
            document.add(getPara("\n-----------------------------------------------------------------------------------------\n"));
            document.add(new Paragraph("\n \n"));

            PdfPTable t = new PdfPTable(new float[]{0.5f,1f,1.5f,1f,1.5f,1f,1f,1f});
            PdfPCell cell =new PdfPCell(new Paragraph("Thông Tin Tài Liệu", fontArial));
            cell.setColspan(8);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            t.addCell(cell);
            
            t.addCell(getCell("STT", PdfPCell.ALIGN_CENTER));
            t.addCell(getCell("Mã TL", PdfPCell.ALIGN_CENTER));
            t.addCell(getCell("Tên Tài Liệu", PdfPCell.ALIGN_CENTER));
            t.addCell(getCell("Thể Loại", PdfPCell.ALIGN_CENTER));
            t.addCell(getCell("Tác Giả", PdfPCell.ALIGN_CENTER));
            t.addCell(getCell("NXB", PdfPCell.ALIGN_CENTER));
            t.addCell(getCell("Số Lượng", PdfPCell.ALIGN_CENTER));
            t.addCell(getCell("Trạng Thái", PdfPCell.ALIGN_CENTER));
            
            Connection con = DocumentDAO.getConnection();
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    t.addCell(Integer.toString(i));
                    t.addCell(new Phrase(rs.getString(1), fontArial));
                    t.addCell(new Phrase(rs.getString(2), fontArial));
                    t.addCell(new Phrase(rs.getString(3), fontArial));
                    t.addCell(new Phrase(rs.getString(4), fontArial));
                    t.addCell(new Phrase(rs.getString(5), fontArial));
                    t.addCell(Integer.toString(rs.getInt(6)));
                    t.addCell(new Phrase(rs.getString(7), fontArial));
                    
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
                if ("Windows XP".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DocManageView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocManageView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocManageView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocManageView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>
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
                new DocManageView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox1;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    public static javax.swing.JPanel pnDocMan;
    private javax.swing.JRadioButton radCon;
    private javax.swing.JRadioButton radHet;
    private javax.swing.JTable tblDoc;
    private javax.swing.JTextField txtMaTL;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancel) {
            new AdminView().setVisible(true);
            this.dispose();
        } else if (e.getSource() == btnInsert) {
            btnInsertClick();
        } else if (e.getSource() == btnRefresh) {
            btnRefreshClick();
        } else if (e.getSource() == btnSearch) {
            btnSearchClick();
        } else if (e.getSource() == btnUpdate) {
            btnUpdateClick();
        } else if (e.getSource() == btnDelete) {
            int confirm = JOptionPane.showConfirmDialog(rootPane, "Bạn Có Chắc Chắn Muốn Xóa", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                btnDeleteClick();
            } else if (confirm == JOptionPane.NO_OPTION) {
                // do nothing
            }
        } else if (e.getSource() == btnReset) {
            btnResetClick();
        } else if (e.getSource() == btnPrint) {
            getReport();
        }

    }
}
