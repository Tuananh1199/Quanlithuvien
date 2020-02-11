/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Document;

/**
 *
 * @author Admin
 */
public class DocumentDAO {

    private static String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private Connection conn;

    public DocumentDAO() {//day la constructor
        try {
            Class.forName(className);
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLTV;username=sa;password=sa");
            System.out.println("connect Success!");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found!");
        } catch (SQLException e) {
            System.out.println("Error COnnection!");
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(className);
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLTV;username=sa;password=sa");
            System.out.println("connect Success!");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found!");
        } catch (SQLException e) {
            System.out.println("Error COnnection!");
        }
        return con;
    }

    public boolean addDocWithExelData(Document d) {
        String mysql = "INSERT INTO tblTaiLieu (MaTL, TenSach, TheLoai, TacGia, NXB, SoLuong, TrangThai) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(mysql);
            ps.setString(1, d.getId());
            ps.setString(2, d.getName());
            ps.setString(3, d.getType());
            ps.setString(4, d.getTacGia());
            ps.setString(5, d.getNxb());
            ps.setInt(6, d.getSoLuong());
            ps.setString(7, d.getTrangThai());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addNewDoc(Document d) {
        String mysql = "INSERT INTO tblTaiLieu (MaTL, TenSach, TheLoai, TacGia, NXB, SoLuong, TrangThai) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(mysql);
            ps.setString(1, d.getId());
            ps.setString(2, d.getName());
            ps.setString(3, d.getType());
            ps.setString(4, d.getTacGia());
            ps.setString(5, d.getNxb());
            ps.setInt(6, d.getSoLuong());
            ps.setString(7, d.getTrangThai());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Document> getListDocument() {
        String query = "SELECT * FROM tblTaiLieu";
        ArrayList<Document> listDoc = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Document doc = new Document();
                doc.setId(rs.getString(1));
                doc.setName(rs.getString(2));
                doc.setType(rs.getString(3));
                doc.setTacGia(rs.getString(4));
                doc.setNxb(rs.getString(5));
                doc.setSoLuong(rs.getInt(6));
                doc.setTrangThai(rs.getString(7));

                listDoc.add(doc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDoc;
    }

    public ArrayList<Document> getListDocByState() {
        String query = "SELECT MaTL, TenSach, TacGia FROM tblTaiLieu WHERE TrangThai = 'Còn'";
        ArrayList<Document> listDoc = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Document doc = new Document();
                doc.setId(rs.getString(1));
                doc.setName(rs.getString(2));
//                doc.setType(rs.getString(3));
                doc.setTacGia(rs.getString(3));

                listDoc.add(doc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDoc;
    }

    public ArrayList<Document> getListDocSearchByNAME(String name) {
        String query = "SELECT * FROM tblTaiLieu WHERE TenSach like ?";
        ArrayList<Document> listDoc = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Document doc = new Document();
                doc.setId(rs.getString(1));
                doc.setName(rs.getString(2));
                doc.setType(rs.getString(3));
                doc.setTacGia(rs.getString(4));
                doc.setNxb(rs.getString(5));
                doc.setSoLuong(rs.getInt(6));
                doc.setTrangThai(rs.getString(7));

                listDoc.add(doc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDoc;
    }

    public ArrayList<Document> getListDocSearchByMATL(String maTL) {
        String query = "SELECT * FROM tblTaiLieu WHERE MaTL like ?";
        ArrayList<Document> listDoc = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + maTL + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Document doc = new Document();
                doc.setId(rs.getString(1));
                doc.setName(rs.getString(2));
                doc.setType(rs.getString(3));
                doc.setTacGia(rs.getString(4));
                doc.setNxb(rs.getString(5));
                doc.setSoLuong(rs.getInt(6));
                doc.setTrangThai(rs.getString(7));

                listDoc.add(doc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDoc;
    }

    public ArrayList<Document> getListDocSearchByTYPE(String type) {
        String query = "SELECT * FROM tblTaiLieu WHERE TheLoai like ?";
        ArrayList<Document> listDoc = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + type + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Document doc = new Document();
                doc.setId(rs.getString(1));
                doc.setName(rs.getString(2));
                doc.setType(rs.getString(3));
                doc.setTacGia(rs.getString(4));
                doc.setNxb(rs.getString(5));
                doc.setSoLuong(rs.getInt(6));
                doc.setTrangThai(rs.getString(7));

                listDoc.add(doc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDoc;
    }

    public ArrayList<Document> getListDocSearchByTACGIA(String tacgia) {
        String query = "SELECT * FROM tblTaiLieu WHERE TacGia like ?";
        ArrayList<Document> listDoc = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + tacgia + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Document doc = new Document();
                doc.setId(rs.getString(1));
                doc.setName(rs.getString(2));
                doc.setType(rs.getString(3));
                doc.setTacGia(rs.getString(4));
                doc.setNxb(rs.getString(5));
                doc.setSoLuong(rs.getInt(6));
                doc.setTrangThai(rs.getString(7));

                listDoc.add(doc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDoc;
    }

    public ArrayList<Document> getListDocSearchByNXB(String nxb) {
        String query = "SELECT * FROM tblTaiLieu WHERE NXB like ?";
        ArrayList<Document> listDoc = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + nxb + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Document doc = new Document();
                doc.setId(rs.getString(1));
                doc.setName(rs.getString(2));
                doc.setType(rs.getString(3));
                doc.setTacGia(rs.getString(4));
                doc.setNxb(rs.getString(5));
                doc.setSoLuong(rs.getInt(6));
                doc.setTrangThai(rs.getString(7));

                listDoc.add(doc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDoc;
    }

    public ArrayList<Document> getListDocSearchBySTATE(String state) {
        String query = "SELECT * FROM tblTaiLieu WHERE TrangThai like ?";
        ArrayList<Document> listDoc = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + state + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Document doc = new Document();
                doc.setId(rs.getString(1));
                doc.setName(rs.getString(2));
                doc.setType(rs.getString(3));
                doc.setTacGia(rs.getString(4));
                doc.setNxb(rs.getString(5));
                doc.setSoLuong(rs.getInt(6));
                doc.setTrangThai(rs.getString(7));

                listDoc.add(doc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDoc;
    }

    public ArrayList<Document> thongKeTheLoai() {
        String query = "SELECT TheLoai, SUM(SoLuong) FROM tblTaiLieu GROUP BY TheLoai";
        ArrayList<Document> listDoc = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Document d = new Document();
                d.setType(rs.getString(1));
                d.setSoLuong(rs.getInt(2));

                listDoc.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDoc;
    }

    public ArrayList<Document> thongKeTacGia() {
        String query = "SELECT TacGia, SUM(SoLuong) FROM tblTaiLieu GROUP BY TacGia";
        ArrayList<Document> listDoc = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Document d = new Document();
                d.setTacGia(rs.getString(1));
                d.setSoLuong(rs.getInt(2));

                listDoc.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDoc;
    }

    public ArrayList<Document> thongKeNXB() {
        String query = "SELECT NXB, SUM(SoLuong) FROM tblTaiLieu GROUP BY NXB";
        ArrayList<Document> listDoc = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Document d = new Document();
                d.setNxb(rs.getString(1));
                d.setSoLuong(rs.getInt(2));

                listDoc.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDoc;
    }

    public ArrayList<Document> thongKeTrangThai() {
        String query = "SELECT TrangThai, SUM(SoLuong) FROM tblTaiLieu WHERE TrangThai = 'Con' GROUP BY TrangThai";
        ArrayList<Document> listDoc = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Document d = new Document();
                d.setTrangThai(rs.getString(1));
                d.setSoLuong(rs.getInt(2));

                listDoc.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDoc;
    }

    public ArrayList<Document> thongKeTongSoTL() {
        String query = "SELECT SUM(SoLuong) FROM tblTaiLieu";
        ArrayList<Document> listDoc = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Document d = new Document();
                d.setSoLuong(rs.getInt(1));

                listDoc.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDoc;
    }

    public static ResultSet getRStForNxbTheLoai() {
        ResultSet rs = null;
        String query = "select NXB ,\n"
                + "	sum(case TheLoai when N'Toán Học' then SoLuong else 0 end) as [Toán Học],\n"
                + "	sum(case TheLoai when N'Vật Lý' then SoLuong else 0 end) as [Vật Lý],\n"
                + "	sum(case TheLoai when N'Hóa Học' then SoLuong else 0 end) as [Hóa Học],\n"
                + "	sum(case TheLoai when N'Tin Học' then SoLuong else 0 end) as [Tin Học],\n"
                + "	sum(case TheLoai when N'Tiếng Anh' then SoLuong else 0 end) as [Tiếng Anh],\n"
                + "	sum(case TheLoai when N'Triết Học' then SoLuong else 0 end) as [Triết Học],\n"
                + "	sum(case TheLoai when N'Truyện' then SoLuong else 0 end) as [Truyện]\n"
                + "from tblTaiLieu\n"
                + "group by NXB\n"
                + "order by NXB;";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

    public static ResultSet getRStForTacGiaTheLoai() {
        ResultSet rs = null;
        String query = "select TacGia ,\n"
                + "	sum(case TheLoai when N'Toán Học' then SoLuong else 0 end) as [Toán Học],\n"
                + "	sum(case TheLoai when N'Vật Lý' then SoLuong else 0 end) as [Vật Lý],\n"
                + "	sum(case TheLoai when N'Hóa Học' then SoLuong else 0 end) as [Hóa Học],\n"
                + "	sum(case TheLoai when N'Tin Học' then SoLuong else 0 end) as [Tin Học],\n"
                + "	sum(case TheLoai when N'Tiếng Anh' then SoLuong else 0 end) as [Tiếng Anh],\n"
                + "	sum(case TheLoai when N'Triết Học' then SoLuong else 0 end) as [Triết Học],\n"
                + "	sum(case TheLoai when N'Truyện' then SoLuong else 0 end) as [Truyện]\n"
                + "from tblTaiLieu\n"
                + "group by TacGia\n"
                + "order by TacGia;";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

    public static ResultSet getRStForTacGiaNxb() {
        ResultSet rs = null;
        String query = "select TacGia ,\n"
                + "	sum(case NXB when N'DHBKHN' then SoLuong else 0 end) as [DHBKHN],\n"
                + "	sum(case NXB when N'DHQG' then SoLuong else 0 end) as [DHQG],\n"
                + "	sum(case NXB when N'Kim Đồng' then SoLuong else 0 end) as [Kim Đồng],\n"
                + "	sum(case NXB when N'NXBDG' then SoLuong else 0 end) as [NXB.DanGian],\n"
                + "	sum(case NXB when N'NXBGD' then SoLuong else 0 end) as [NXB.GiaoDuc]\n"
                + "from tblTaiLieu\n"
                + "group by TacGia\n"
                + "order by TacGia;";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

    public static void main(String[] args) {
        new DocumentDAO();
    }

}
