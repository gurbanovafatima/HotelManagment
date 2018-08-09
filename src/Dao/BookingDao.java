/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Booking;
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
public class BookingDao implements IBookingDao{

    private ICustomerDao customerDao;
    private DateTimeConverter dateTimeConverter;
    private IRoomDao roomDao;
    public BookingDao() {
        customerDao = new CustomerDao();
        dateTimeConverter = new DateTimeConverter();
        roomDao = new RoomDao();
    }
    
    @Override
    public void Create(Booking booking) {
        String sql = "insert into bookings"
                + "(CustomerId,RoomId,CheckIn,CheckOut,AdultCount,ChildrenCount,BookingStatus)"
                + "Values(?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,booking.getCustomer().getId());
            ps.setInt(2,booking.getRoom().getId());
            ps.setDate(3,dateTimeConverter.convertToSqlDate(booking.getCheckIn()));
            ps.setDate(4,dateTimeConverter.convertToSqlDate(booking.getCheckOut()));
            ps.setInt(5,booking.getAdultCount());
            ps.setInt(6,booking.getChildrenCount());
            ps.setBoolean(7,booking.getStatus());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
    }

    @Override
    public LinkedList<Booking> getBookings() {
        LinkedList<Booking> bookings = new LinkedList<>();
        String sql = "select * from bookings";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                customerDao.findById(rs.getInt("CustomerId"));
                
                Booking booking = new Booking
                (
                    customerDao.findById(rs.getInt("CustomerId")),
                    roomDao.findById(rs.getInt("RoomId")),
                    dateTimeConverter.convertToLocalDateTime(rs.getDate("CheckIn")),
                    dateTimeConverter.convertToLocalDateTime(rs.getDate("CheckOut")),
                    rs.getInt("AdultCount"),
                    rs.getInt("ChildrenCount"),
                    rs.getBoolean("BookingStatus")
                );
                booking.setId(rs.getInt("Id"));
                bookings.add(booking);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        
        return bookings;
    }

    @Override
    public Booking findById(int id) {
        String sql = "select *  from bookings where id = ?";
        Booking booking = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
             while(rs.next()){      
            booking = new Booking
            (
                customerDao.findById(rs.getInt("CustomerId")),
                roomDao.findById(rs.getInt("RoomId")),
                dateTimeConverter.convertToLocalDateTime(rs.getDate("CheckIn")),
                dateTimeConverter.convertToLocalDateTime(rs.getDate("CheckOut")),
                rs.getInt("AdultCount"),
                rs.getInt("ChildrenCount"),
                rs.getBoolean("BookingStatus")
            );
            booking.setId(rs.getInt("Id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        return booking;
    }

    @Override
    public Booking find(Booking booking) {
        String sql = "select *  from bookings where id = ?";
        Booking lastBooking = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,booking.getId());
            rs = ps.executeQuery();
            while(rs.next()){    
            lastBooking = new Booking
            (
                customerDao.findById(rs.getInt("CustomerId")),
                roomDao.findById(rs.getInt("RoomId")),
                dateTimeConverter.convertToLocalDateTime(rs.getDate("CheckIn")),
                dateTimeConverter.convertToLocalDateTime(rs.getDate("CheckOut")),
                rs.getInt("AdultCount"),
                rs.getInt("ChildrenCount"),
                rs.getBoolean("BookingStatus")
                );
                booking.setId(rs.getInt("Id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        return lastBooking; 
    }

    @Override
    public void Update(Booking booking) {
         String sql = "update bookings set CustomerId= ?"
                + ",RoomId = ?,CheckIn= ?,CheckOut= ?,"
                 + "AdultCount = ?,ChildrenCount = ?,BookingStatus=? where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,booking.getCustomer().getId());
            ps.setInt(2,booking.getRoom().getId());
            ps.setDate(3,dateTimeConverter.convertToSqlDate(booking.getCheckIn()));
            ps.setDate(4,dateTimeConverter.convertToSqlDate(booking.getCheckOut()));
            ps.setInt(5,booking.getAdultCount());
            ps.setInt(6,booking.getChildrenCount());
            ps.setBoolean(7,booking.getStatus());
            ps.setInt(8,booking.getId());
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
    }

    @Override
    public void Delete(Booking booking) {
        String sql = "delete  from bookings where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,booking.getId());
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
        String sql = "delete  from bookings where id = ?";
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
  
}
