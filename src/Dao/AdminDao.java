/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Admin;
import Utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp1
 */
public class AdminDao implements IAdminDao{

    @Override
    public LinkedList<Admin> getAdmins() {
        LinkedList<Admin> admins = new LinkedList<>();
        String sql = "select * from admins";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Admin admin = new Admin
                (  
                     rs.getString("LastName"),
                     rs.getString("FirstName"),
                     rs.getString("Pass"),
                     rs.getString("Username")
                ); 
                admin.setId(rs.getInt("Id"));
                admins.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        
        return admins;
    }

    @Override
    public Admin find(Admin admin) {
        String sql = "select *  from admins where id = ?";
        Admin lastAdmin = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,admin.getId());
            rs = ps.executeQuery();
             while(rs.next()){     
            lastAdmin = new Admin
            (
                 rs.getString("LastName"),
                 rs.getString("FirstName"),
                 rs.getString("Pass"),
                 rs.getString("Username") 
            );
            lastAdmin.setId(rs.getInt("Id"));
             }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        return lastAdmin;
    }

    @Override
    public Admin findById(int id) {
        String sql = "select *  from admins where id = ?";
        Admin admin = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
             while(rs.next()){  
            admin = new Admin
            (
                 rs.getString("LastName"),
                 rs.getString("FirstName"),
                 rs.getString("Pass"),
                 rs.getString("Username") 
            );
            admin.setId(rs.getInt("Id"));
             }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        return admin;
    }

    @Override
    public Admin findByUsername(String username, String pass) {
        String sql = "select *  from admins where username =? and pass =?";
        Admin admin = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,pass);
            rs = ps.executeQuery();
             while(rs.next()){ 
            admin = new Admin
            (
                 rs.getString("LastName"),
                 rs.getString("FirstName"),
                 rs.getString("Pass"),
                 rs.getString("Username") 
            );
            admin.setId(rs.getInt("Id"));
             }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        return admin;
    }
    
}
