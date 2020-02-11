/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.AllDetails;
import model.ChiTietMuonTra;
import model.PhieuDKMuonTra;

/**
 *
 * @author Admin
 */
public class MuonTraDAO {

    private static String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private Connection conn;

    //constructor
    public MuonTraDAO() {
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
        Connection conn = null;
        try {
            Class.forName(className);
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLTV;username=sa;password=sa");
            System.out.println("connect Success!");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found!");
        } catch (SQLException e) {
            System.out.println("Error COnnection!");
        }
        return conn;
    }

    public boolean addDangKyMT(PhieuDKMuonTra dk) {
        String query = "INSERT INTO tblDKMuonTra (MaMT, UserID, AdminID, NgayMuon) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, dk.getMaMT());
            ps.setInt(2, dk.getUserID());
            ps.setInt(3, dk.getAdminID());
            ps.setDate(4, new Date(dk.getNgayMuon().getTime()));

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addChiTietMTadmin(ChiTietMuonTra ct) {
        String query = "INSERT INTO tblChiTietMT (MaMT, MaTL, HanTra) VALUES (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ct.getMaMT());
            ps.setString(2, ct.getMaTL());
            ps.setDate(3, new Date(ct.getHanTra().getTime()));

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addChiTietMT(ChiTietMuonTra ct) {
        String query = "INSERT INTO tblChiTietMT (MaMT, MaTL, HanTra, NgayTra, TienPhat, GhiChu) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ct.getMaMT());
            ps.setString(2, ct.getMaTL());
            ps.setDate(3, new Date(ct.getHanTra().getTime()));
            ps.setDate(4, new Date(ct.getNgayTra().getTime()));
            ps.setInt(5, ct.getTienPhat());
            ps.setString(6, ct.getGhiChu());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<ChiTietMuonTra> getlistCTMT() {
        String query = "SELECT * FROM tblChiTietMT";
        ArrayList<ChiTietMuonTra> listCT = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ChiTietMuonTra ct = new ChiTietMuonTra();
                ct.setMaMT(rs.getString(1));
                ct.setMaTL(rs.getString(2));
                ct.setHanTra(rs.getDate(3));
                ct.setNgayTra(rs.getDate(4));
                ct.setTienPhat(rs.getInt(5));
                ct.setGhiChu(rs.getString(6));

                listCT.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listCT;
//ArrayList<AllDetails> listCT = new ArrayList<>();
//        String query = "SELECT tblDKMuonTra.MaMT, TenSach, tbluser.Name, tbladmin.Name, tblDKMuonTra.NgayMuon, tblChiTietMT.HanTra \n"
//                + "FROM tbladmin, tblChiTietMT, tblDKMuonTra, tbluser, tblTaiLieu\n"
//                + "WHERE tblDKMuonTra.MaMT = tblChiTietMT.MaMT and tblChiTietMT.MaTL = tblTaiLieu.MaTL\n"
//                + "and tbluser.UserID = tblDKMuonTra.UserID and tbladmin.AdminID = tblDKMuonTra.AdminID\n"
//                + "and tblChiTietMT.MaMT = '" + maMT + "'";
//
//        try {
//            PreparedStatement ps = conn.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                AllDetails ct = new AllDetails();
//                ct.setMaMT(rs.getString(1));
//                ct.setMaTL(rs.getString(2));
//                ct.setUserName(rs.getString(3));
//                ct.setAdminName(rs.getString(4));
//                ct.setNgayMuon(rs.getDate(5));
//                ct.setHanTra(rs.getDate(6));
//
//                listCT.add(ct);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return listCT;

    }

    public ArrayList<AllDetails> getChiTietMT() {
        String query = "SELECT tblDKMuonTra.MaMT, tblChiTietMT.MaTL, TenSach, tbluser.UserID, tbluser.Name, tbladmin.Name, tblDKMuonTra.NgayMuon, tblChiTietMT.HanTra, NgayTra, TienPhat, GhiChu\n"
                + "FROM tbladmin, tblChiTietMT, tblDKMuonTra, tbluser, tblTaiLieu\n"
                + "WHERE tblDKMuonTra.MaMT = tblChiTietMT.MaMT and tblChiTietMT.MaTL = tblTaiLieu.MaTL\n"
                + "and tbluser.UserID = tblDKMuonTra.UserID and tbladmin.AdminID = tblDKMuonTra.AdminID\n";
        ArrayList<AllDetails> listDetail = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AllDetails dt = new AllDetails();
                dt.setMaMT(rs.getString(1));
                dt.setMaTL(rs.getString(2));
                dt.setDocName(rs.getString(3));
                dt.setUserID(rs.getInt(4));
                dt.setUserName(rs.getString(5));
                dt.setAdminName(rs.getString(6));
                dt.setNgayMuon(rs.getDate(7));
                dt.setHanTra(rs.getDate(8));
                dt.setNgayTra(rs.getDate(9));
                dt.setMoney(rs.getInt(10));
                dt.setNote(rs.getString(11));

                listDetail.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDetail;

    }

    public ArrayList<AllDetails> getChiTietMTByUserID(String userID) {
        String query = "SELECT tblDKMuonTra.MaMT, tblChiTietMT.MaTL, TenSach, tbluser.Name, tbladmin.Name, tblDKMuonTra.NgayMuon, tblChiTietMT.HanTra, NgayTra, TienPhat, GhiChu\n"
                + "FROM tbladmin, tblChiTietMT, tblDKMuonTra, tbluser, tblTaiLieu\n"
                + "WHERE tblDKMuonTra.MaMT = tblChiTietMT.MaMT and tblChiTietMT.MaTL = tblTaiLieu.MaTL\n"
                + "and tbluser.UserID = tblDKMuonTra.UserID and tbladmin.AdminID = tblDKMuonTra.AdminID\n"
                + "and tbluser.UserID = '" + userID + "'";
        ArrayList<AllDetails> listDetail = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AllDetails dt = new AllDetails();
                dt.setMaMT(rs.getString(1));
                dt.setMaTL(rs.getString(2));
                dt.setDocName(rs.getString(3));
//                dt.setUserID(rs.getInt(4));
                dt.setUserName(rs.getString(4));
                dt.setAdminName(rs.getString(5));
                dt.setNgayMuon(rs.getDate(6));
                dt.setHanTra(rs.getDate(7));
                dt.setNgayTra(rs.getDate(8));
                dt.setMoney(rs.getInt(9));
                dt.setNote(rs.getString(10));

                listDetail.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDetail;

    }

    public ArrayList<AllDetails> searchCTMTbyAll(String maMT, String maTL) {
        String query = "SELECT tblDKMuonTra.MaMT, tblChiTietMT.MaTL, TenSach, tbluser.UserID, tbluser.Name, tbladmin.Name, tblDKMuonTra.NgayMuon, tblChiTietMT.HanTra, NgayTra, TienPhat, GhiChu\n"
                + "FROM tbladmin, tblChiTietMT, tblDKMuonTra, tbluser, tblTaiLieu\n"
                + "WHERE tblDKMuonTra.MaMT = tblChiTietMT.MaMT and tblChiTietMT.MaTL = tblTaiLieu.MaTL\n"
                + "and tbluser.UserID = tblDKMuonTra.UserID and tbladmin.AdminID = tblDKMuonTra.AdminID\n"
                + "and tblChiTietMT.MaMT = ? and tblChiTietMT.MaTL = ?;";
        ArrayList<AllDetails> listDetail = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maMT);
            ps.setString(2, maTL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AllDetails dt = new AllDetails();
                dt.setMaMT(rs.getString(1));
                dt.setMaTL(rs.getString(2));
                dt.setDocName(rs.getString(3));
                dt.setUserID(rs.getInt(4));
                dt.setUserName(rs.getString(5));
                dt.setAdminName(rs.getString(6));
                dt.setNgayMuon(rs.getDate(7));
                dt.setHanTra(rs.getDate(8));
                dt.setNgayTra(rs.getDate(9));
                dt.setMoney(rs.getInt(10));
                dt.setNote(rs.getString(11));

                listDetail.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDetail;

    }

    public ArrayList<AllDetails> searchCTMTBymaMT(String maMT) {
        String query = "SELECT tblDKMuonTra.MaMT, tblChiTietMT.MaTL, TenSach, tbluser.UserID, tbluser.Name, tbladmin.Name, tblDKMuonTra.NgayMuon, tblChiTietMT.HanTra, NgayTra, TienPhat, GhiChu\n"
                + "FROM tbladmin, tblChiTietMT, tblDKMuonTra, tbluser, tblTaiLieu\n"
                + "WHERE tblDKMuonTra.MaMT = tblChiTietMT.MaMT and tblChiTietMT.MaTL = tblTaiLieu.MaTL\n"
                + "and tbluser.UserID = tblDKMuonTra.UserID and tbladmin.AdminID = tblDKMuonTra.AdminID\n"
                + "and tblChiTietMT.MaMT = ?;";
        ArrayList<AllDetails> listDetail = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maMT);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AllDetails dt = new AllDetails();
                dt.setMaMT(rs.getString(1));
                dt.setMaTL(rs.getString(2));
                dt.setDocName(rs.getString(3));
                dt.setUserID(rs.getInt(4));
                dt.setUserName(rs.getString(5));
                dt.setAdminName(rs.getString(6));
                dt.setNgayMuon(rs.getDate(7));
                dt.setHanTra(rs.getDate(8));
                dt.setNgayTra(rs.getDate(9));
                dt.setMoney(rs.getInt(10));
                dt.setNote(rs.getString(11));

                listDetail.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDetail;

    }

    public ArrayList<AllDetails> searchCTMTbymaTL(String maTL) {
        String query = "SELECT tblDKMuonTra.MaMT, tblChiTietMT.MaTL, TenSach, tbluser.UserID, tbluser.Name, tbladmin.Name, tblDKMuonTra.NgayMuon, tblChiTietMT.HanTra, NgayTra, TienPhat, GhiChu\n"
                + "FROM tbladmin, tblChiTietMT, tblDKMuonTra, tbluser, tblTaiLieu\n"
                + "WHERE tblDKMuonTra.MaMT = tblChiTietMT.MaMT and tblChiTietMT.MaTL = tblTaiLieu.MaTL\n"
                + "and tbluser.UserID = tblDKMuonTra.UserID and tbladmin.AdminID = tblDKMuonTra.AdminID\n"
                + "and tblChiTietMT.MaTL = ?;";
        ArrayList<AllDetails> listDetail = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maTL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AllDetails dt = new AllDetails();
                dt.setMaMT(rs.getString(1));
                dt.setMaTL(rs.getString(2));
                dt.setDocName(rs.getString(3));
                dt.setUserID(rs.getInt(4));
                dt.setUserName(rs.getString(5));
                dt.setAdminName(rs.getString(6));
                dt.setNgayMuon(rs.getDate(7));
                dt.setHanTra(rs.getDate(8));
                dt.setNgayTra(rs.getDate(9));
                dt.setMoney(rs.getInt(10));
                dt.setNote(rs.getString(11));

                listDetail.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDetail;

    }

    public ArrayList<AllDetails> getlistCTMTByMaMT(String maMT) {
        ArrayList<AllDetails> listCT = new ArrayList<>();
        String query = "SELECT tblDKMuonTra.MaMT, tblChiTietMT.MaTL ,TenSach, tbluser.Name, tbladmin.Name, tblDKMuonTra.NgayMuon, tblChiTietMT.HanTra \n"
                + "FROM tbladmin, tblChiTietMT, tblDKMuonTra, tbluser, tblTaiLieu\n"
                + "WHERE tblDKMuonTra.MaMT = tblChiTietMT.MaMT and tblChiTietMT.MaTL = tblTaiLieu.MaTL\n"
                + "and tbluser.UserID = tblDKMuonTra.UserID and tbladmin.AdminID = tblDKMuonTra.AdminID\n"
                + "and tblChiTietMT.MaMT = '" + maMT + "'";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AllDetails ct = new AllDetails();
                ct.setMaMT(rs.getString(1));
                ct.setMaTL(rs.getString(2));
                ct.setDocName(rs.getString(3));
                ct.setUserName(rs.getString(4));
                ct.setAdminName(rs.getString(5));
                ct.setNgayMuon(rs.getDate(6));
                ct.setHanTra(rs.getDate(7));

                listCT.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listCT;

    }

    public ArrayList<AllDetails> getlistCTMTToPrint(String maMT) {
        ArrayList<AllDetails> listCT = new ArrayList<>();
        String query = "SELECT TenSach, tblChiTietMT.HanTra FROM tblChiTietMT, tblTaiLieu\n"
                + "WHERE tblChiTietMT.MaTL = tblTaiLieu.MaTL and tblChiTietMT.MaMT = '" + maMT + "';";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AllDetails ct = new AllDetails();
                ct.setDocName(rs.getString(1));
                ct.setHanTra(rs.getDate(2));

                listCT.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listCT;

    }

    public ArrayList<AllDetails> getlistTraTLToPrint(String ngayTra, String maMT) {
        ArrayList<AllDetails> listCT = new ArrayList<>();
        String query = "SELECT TenSach, TienPhat, GhiChu  FROM tblChiTietMT, tblTaiLieu\n"
                + "WHERE tblChiTietMT.MaTL = tblTaiLieu.MaTL and NgayTra = '" + ngayTra + "' and MaMT = '" + maMT + "';";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AllDetails ct = new AllDetails();
                ct.setDocName(rs.getString(1));
                ct.setMoney(rs.getInt(2));
                ct.setNote(rs.getString(3));

                listCT.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listCT;

    }

    public ArrayList<AllDetails> getListCTForUser(String userID) {
        String query = "SELECT tblChiTietMT.MaMT, tblChiTietMT.MaTL, tblTaiLieu.TenSach, tbladmin.Name, NgayMuon, HanTra, NgayTra, TienPhat, GhiChu FROM tblDKMuonTra, tblChiTietMT, tblTaiLieu, tbladmin \n"
                + "WHERE tblDKMuonTra.MaMT = tblChiTietMT.MaMT\n"
                + "and tblChiTietMT.MaTL = tblTaiLieu.MaTL\n"
                + "and tbladmin.AdminID = tblDKMuonTra.AdminID\n"
                + "and UserID = ?;";
        ArrayList<AllDetails> listDetail = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AllDetails dt = new AllDetails();
                dt.setMaMT(rs.getString(1));
                dt.setMaTL(rs.getString(2));
                dt.setDocName(rs.getString(3));
                dt.setAdminName(rs.getString(4));
                dt.setNgayMuon(rs.getDate(5));
                dt.setHanTra(rs.getDate(6));
                dt.setNgayTra(rs.getDate(7));
                dt.setMoney(rs.getInt(8));
                dt.setNote(rs.getString(9));

                listDetail.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDetail;

    }

    public ArrayList<AllDetails> getListCTForUserByName(String docName, String userID) {
        String query = "SELECT tblChiTietMT.MaMT, tblChiTietMT.MaTL, tblTaiLieu.TenSach,tbladmin.Name, NgayMuon, HanTra, NgayTra, TienPhat, GhiChu FROM tblDKMuonTra, tblChiTietMT, tblTaiLieu, tbladmin \n"
                + "WHERE tblDKMuonTra.MaMT = tblChiTietMT.MaMT\n"
                + "and tblChiTietMT.MaTL = tblTaiLieu.MaTL\n"
                + "and tbladmin.AdminID = tblDKMuonTra.AdminID\n"
                + "and tblTaiLieu.TenSach like ? and UserID = ?;";
        ArrayList<AllDetails> listDetail = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + docName + "%");
            ps.setString(2, userID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AllDetails dt = new AllDetails();
                dt.setMaMT(rs.getString(1));
                dt.setMaTL(rs.getString(2));
                dt.setDocName(rs.getString(3));
                dt.setAdminName(rs.getString(4));
                dt.setNgayMuon(rs.getDate(5));
                dt.setHanTra(rs.getDate(6));
                dt.setNgayTra(rs.getDate(7));
                dt.setMoney(rs.getInt(8));
                dt.setNote(rs.getString(9));

                listDetail.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDetail;

    }

    public ArrayList<AllDetails> getListCTForUserByMaMT(String maMT, String userID) {
        String query = "SELECT tblChiTietMT.MaMT, tblChiTietMT.MaTL, tblTaiLieu.TenSach, tbladmin.Name, NgayMuon, HanTra, NgayTra, TienPhat, GhiChu FROM tblDKMuonTra, tblChiTietMT, tblTaiLieu, tbladmin \n"
                + "WHERE tblDKMuonTra.MaMT = tblChiTietMT.MaMT\n"
                + "and tblChiTietMT.MaTL = tblTaiLieu.MaTL\n"
                + "and tbladmin.AdminID = tblDKMuonTra.AdminID\n"
                + "and tblChiTietMT.MaMT like ? and UserID = ?;";
        ArrayList<AllDetails> listDetail = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + maMT + "%");
            ps.setString(2, userID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AllDetails dt = new AllDetails();
                dt.setMaMT(rs.getString(1));
                dt.setMaTL(rs.getString(2));
                dt.setDocName(rs.getString(3));
                dt.setAdminName(rs.getString(4));
                dt.setNgayMuon(rs.getDate(5));
                dt.setHanTra(rs.getDate(6));
                dt.setNgayTra(rs.getDate(7));
                dt.setMoney(rs.getInt(8));
                dt.setNote(rs.getString(9));

                listDetail.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDetail;

    }

    public ArrayList<AllDetails> getListCTForUserByMaTL(String maTL, String userID) {
        String query = "SELECT tblChiTietMT.MaMT, tblChiTietMT.MaTL, tblTaiLieu.TenSach,tbladmin.Name, NgayMuon, HanTra, NgayTra, TienPhat, GhiChu FROM tblDKMuonTra, tblChiTietMT, tblTaiLieu, tbladmin \n"
                + "WHERE tblDKMuonTra.MaMT = tblChiTietMT.MaMT\n"
                + "and tblChiTietMT.MaTL = tblTaiLieu.MaTL\n"
                + "and tbladmin.AdminID = tblDKMuonTra.AdminID\n"
                + "and tblChiTietMT.MaTL = ? and UserID = ?;";
        ArrayList<AllDetails> listDetail = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maTL);
            ps.setString(2, userID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AllDetails dt = new AllDetails();
                dt.setMaMT(rs.getString(1));
                dt.setMaTL(rs.getString(2));
                dt.setDocName(rs.getString(3));
                dt.setAdminName(rs.getString(4));
                dt.setNgayMuon(rs.getDate(5));
                dt.setHanTra(rs.getDate(6));
                dt.setNgayTra(rs.getDate(7));
                dt.setMoney(rs.getInt(8));
                dt.setNote(rs.getString(9));

                listDetail.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDetail;

    }

    public ArrayList<PhieuDKMuonTra> getListDKMT() {
        String query = "SELECT * FROM tblDKMuonTra";
        ArrayList<PhieuDKMuonTra> list = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PhieuDKMuonTra dkmt = new PhieuDKMuonTra();
                dkmt.setMaMT(rs.getString(1));
                dkmt.setUserID(rs.getInt(2));
                dkmt.setAdminID(rs.getInt(3));
                dkmt.setNgayMuon(rs.getDate(4));

                list.add(dkmt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateCTMT(String hanTra, String maMT, String maTL) {
        try {
            String query = "UPDATE tblChiTietMT SET HanTra = ? WHERE MaMT = '" + maMT + "' AND MaTL = '" + maTL + "'";//cho bang co them cot MaTL de chon
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, hanTra);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    
    public static int getNumOfMuonTL(String maMT){
        int num = 0;
        Connection con = getConnection();
        String query = "select count(MaMT) from tblChiTietMT where MaMT = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, maMT);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                num = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return num;
    }
    
    public static int getNumOfTraTL(String maMT){
        int num = 0;
        Connection con = getConnection();
        String query = "select count(MaMT) from tblChiTietMT where NgayTra is not null and MaMT = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, maMT);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                num = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return num;
    }
    
    public static void main(String[] args) {
        new MuonTraDAO();
    }

}
