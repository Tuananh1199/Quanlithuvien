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
import java.util.ArrayList;
import javax.swing.JTextField;
import model.AllDetails;
import model.User;
//import view.UserLoginFrame;

/**
 *
 * @author Admin
 */
public class UserDAO {

    private static String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    private Connection conn;
//static mothod

    public static Connection getConnection() {//day la constructor
        Connection conn = null;
        try {
            Class.forName(className);
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLTV;username=sa;password=sa");
            System.out.println("connect Success!");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found!");
        } catch (SQLException e) {
            System.out.println("Error Connection!");
        }
        return conn;
    }

    public boolean addNewUser(User user) {
        Connection con = getConnection();
        String sql = "INSERT INTO tbluser(Name, DateOfBirth, Email, Phone, Address, Password) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setDate(2, new Date(user.getBirth().getTime()));
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getPassword());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateUsr(String id, String ten, String birth, String sdt,
            String email, String diaChi, String pass) {
        Connection con = getConnection();
        String sql = "UPDATE tbluser SET  Name = ?, DateOfBirth = ?, Phone = ?, "
                + "Email = ?, Address = ?, Password = ? WHERE UserID = '" + id + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, ten);
            ps.setString(2, birth);
            ps.setString(3, sdt);
            ps.setString(4, email);
            ps.setString(5, diaChi);
            ps.setString(6, pass);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean dateleUsr(String id) {
        boolean status = false;
        Connection con = getConnection();
        String sql = "DELETE FROM tbluser WHERE UserID = '" + id + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            status = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

//    //------------------Luu Thong Tin Dang Nhap????--------------------
//    public ArrayList<User> getListUserLoginAcc() {
//        JTextField mail = null;
//        Connection conn = getConnection();
//        String mysql = "SELECT UserId, Name FROM tbluser WHERE Email = '"+mail+"'";
//        ArrayList<User> listUser = new ArrayList<>();
//        
//        try {
//            PreparedStatement ps = conn.prepareStatement(mysql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                User user = new User();
//                user.setId(rs.getInt(1));
//                user.setName(rs.getString(2));
//                            
//                listUser.add(user);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listUser;
//    }
//    --------------------------UserId, Name, DateOfBirth, Email, Phone, Address---------------------------------------
    public ArrayList<User> getListUser() {
        String mysql = "SELECT *  FROM tbluser";
        ArrayList<User> listUser = new ArrayList<>();
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(mysql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setBirth(rs.getDate(3));
                user.setEmail(rs.getString(4));
                user.setPhone(rs.getString(5));
                user.setAddress(rs.getString(6));
                user.setPassword(rs.getString(7));
                listUser.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }

    public ArrayList<User> getListSearchByID(String id) {
        String mysql = "SELECT *  FROM tbluser WHERE UserID LIKE ?";
        ArrayList<User> listUser = new ArrayList<>();
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(mysql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setBirth(rs.getDate(3));
                user.setEmail(rs.getString(4));
                user.setPhone(rs.getString(5));
                user.setAddress(rs.getString(6));
                user.setPassword(rs.getString(7));
                listUser.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }

    public ArrayList<User> getListSearchByTen(String ten) {
        String mysql = "SELECT *  FROM tbluser WHERE Name LIKE ?";
        ArrayList<User> listUser = new ArrayList<>();
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(mysql);
            ps.setString(1, "%" + ten + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setBirth(rs.getDate(3));
                user.setEmail(rs.getString(4));
                user.setPhone(rs.getString(5));
                user.setAddress(rs.getString(6));
                user.setPassword(rs.getString(7));
                listUser.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }

    public ArrayList<User> getListSearchByDiaChi(String dchi) {
        String mysql = "SELECT *  FROM tbluser WHERE Address LIKE ?";
        ArrayList<User> listUser = new ArrayList<>();
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(mysql);
            ps.setString(1, "%" + dchi + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setBirth(rs.getDate(3));
                user.setEmail(rs.getString(4));
                user.setPhone(rs.getString(5));
                user.setAddress(rs.getString(6));
                user.setPassword(rs.getString(7));
                listUser.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }

    public ArrayList<User> getListSearchBySDT(String sdt) {
        String mysql = "SELECT *  FROM tbluser WHERE Phone LIKE ?";
        ArrayList<User> listUser = new ArrayList<>();
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(mysql);
            ps.setString(1, "%" + sdt + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setBirth(rs.getDate(3));
                user.setEmail(rs.getString(4));
                user.setPhone(rs.getString(5));
                user.setAddress(rs.getString(6));
                user.setPassword(rs.getString(7));
                listUser.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }

    public ArrayList<AllDetails> getSLTaiLieuDaMuon() {
        ArrayList<AllDetails> list = new ArrayList<>();
        String query = "SELECT tbluser.UserID ,tbluser.Name, count(MaTL) FROM  tbluser left join \n"
                + "(tblChiTietMT left join tblDKMuonTra on tblChiTietMT.MaMT = tblDKMuonTra.MaMT)\n"
                + "on tbluser.UserID = tblDKMuonTra.UserID\n"
                + "group by tbluser.UserID, tbluser.Name;";
        Connection con = getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AllDetails dt = new AllDetails();
                dt.setUserID(rs.getInt(1));
                dt.setUserName(rs.getString(2));
                dt.setSoLuong(rs.getInt(3));

                list.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<AllDetails> getSLTaiLieuChuaTra() {
        ArrayList<AllDetails> list = new ArrayList<>();
        String query = "SELECT tbluser.UserID, tbluser.Name, count(MaTL) as sl FROM  tbluser left join \n"
                + "(tblChiTietMT left join tblDKMuonTra on tblChiTietMT.MaMT = tblDKMuonTra.MaMT)\n"
                + "on tbluser.UserID = tblDKMuonTra.UserID\n"
                + "and NgayTra is null\n"
                + "group by tbluser.UserID, tbluser.Name\n"
                + "order by sl desc;";

        Connection con = getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AllDetails dt = new AllDetails();
                dt.setUserID(rs.getInt(1));
                dt.setUserName(rs.getString(2));
                dt.setSoLuong(rs.getInt(3));

                list.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {
        new UserDAO();
    }

}
