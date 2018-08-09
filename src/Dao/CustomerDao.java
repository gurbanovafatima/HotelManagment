/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Customer;
import Utils.DBConnection;
import Utils.DateTimeConverter;
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
public class CustomerDao implements ICustomerDao {

    
    private DateTimeConverter dateTimeConverter;
    public CustomerDao() {
        dateTimeConverter = new DateTimeConverter();
    }

    
    
    @Override
    public void Create(Customer customer) {
        String sql = "insert into customers"
                + "(FirstName,LastName,Gender,BirthDate,Email,Address,PhoneNumber,Nationality)"
                + "Values(?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setString(1,customer.getName());
            ps.setString(2, customer.getSurname());
            ps.setBoolean(3, customer.getGender());
            ps.setDate(4,dateTimeConverter.convertToSqlDate(customer.getDate_of_birth()));
            ps.setString(5, customer.getEmail());
            ps.setString(6, customer.getAddress());
            ps.setString(7,customer.getPhoneNumber());
            ps.setString(8,customer.getNationality());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
    }

    @Override
    public LinkedList<Customer> getCustomers() {
        LinkedList<Customer> customers = new LinkedList<>();
        String sql = "select * from customers";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Customer customer = new Customer
                (
                    rs.getString("LastName"),
                    rs.getString("FirstName"),
                    rs.getBoolean("Gender"),
                    dateTimeConverter.convertToLocalDateTime(rs.getDate("BirthDate")),
                    rs.getString("Email"),
                    rs.getString("Address"),
                    rs.getString("PhoneNumber"),
                    rs.getString("Nationality")
                );
                customer.setId(rs.getInt("Id"));
                customers.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        
        return customers;
    }

    @Override
    public void Update(Customer customer) {
        String sql = "update customers set FirstName = ?"
                + ",LastName = ?,Gender = ?,BirthDate = ?,Email =?,Address = ?,PhoneNumber =?,Nationality = ?"
                + "where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setString(1,customer.getName());
            ps.setString(2, customer.getSurname());
            ps.setBoolean(3, customer.getGender());
            ps.setDate(4, dateTimeConverter.convertToSqlDate(customer.getDate_of_birth()));
            ps.setString(5, customer.getEmail());
            ps.setString(6, customer.getAddress());
            ps.setString(7,customer.getPhoneNumber());
            ps.setString(8,customer.getNationality());
            ps.setInt(9, customer.getId());
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
    }   

    @Override
    public void Delete(Customer customer) {
        String sql = "delete  from customers where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,customer.getId());
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
    }

    @Override
    public void DeleteById(int id) {
        String sql = "delete  from customers where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
    }

    @Override
    public Customer findById(int id) {
        String sql = "select *  from customers where id = ?";
        Customer customer = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
       //     rs.first();
            while(rs.next()){
            customer = new Customer
            (
                rs.getString("LastName"),
                rs.getString("FirstName"),
                rs.getBoolean("Gender"),
                dateTimeConverter.convertToLocalDateTime(rs.getDate("BirthDate")),
                rs.getString("Email"),
                rs.getString("Address"),
                rs.getString("PhoneNumber"),
                rs.getString("Nationality")  
            );
            customer.setId(   rs.getInt("Id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        return customer;
    }

    @Override
    public Customer find(Customer customer) {
        String sql = "select *  from customers where id = ?";
        Customer lastCustomer = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,customer.getId());
            rs = ps.executeQuery();
            while(rs.next()){
            lastCustomer = new Customer
            (
                
                rs.getString("LastName"),
                rs.getString("FirstName"),
                rs.getBoolean("Gender"),
                dateTimeConverter.convertToLocalDateTime(rs.getDate("BirthDate")),
                rs.getString("Email"),
                rs.getString("Address"),
                rs.getString("PhoneNumber"),
                rs.getString("Nationality")  
            );
            lastCustomer.setId(rs.getInt("Id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        return lastCustomer;
    }
}
