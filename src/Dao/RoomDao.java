/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Room;
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
public class RoomDao  implements IRoomDao{

    @Override
    public void Create(Room room) {
        String sql = "insert into rooms"
                + "(RoomType,RoomView,RoomStatus,RoomNumber)"
                + " Values(?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,room.getRoomType());
            ps.setInt(2,room.getRoomView());
            ps.setInt(3,room.getRoomStatus());
            ps.setString(4,room.getRoomNumber());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
    }

    @Override
    public LinkedList<Room> getRooms() {
        LinkedList<Room> rooms = new LinkedList<>();
        String sql = "select * from rooms";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Room room = new Room
                (
                    
                    rs.getInt("RoomType"),
                    rs.getInt("RoomView"),
                    rs.getInt("RoomStatus"),
                    rs.getString("RoomNumber")
                );
                room.setId(rs.getInt("Id"));
                rooms.add(room);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        
        return rooms;
    }

    @Override
    public Room findByRoomNumber(String roomNumber) {
        String sql = "select *  from rooms where RoomNumber = ?";
        Room room = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setString(1,roomNumber);
            rs = ps.executeQuery();
            while(rs.next()){
            room = new Room
            (
                  rs.getInt("RoomType"),
                  rs.getInt("RoomView"),
                  rs.getInt("RoomStatus"),
                  rs.getString("RoomNumber")
            );
            room.setId(rs.getInt("Id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        return room;
    }

    @Override
    public Room find(Room room) {
        String sql = "select *  from rooms where id = ?";
        Room lastRoom = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,room.getId());
            rs = ps.executeQuery();
            while(rs.next()){
            lastRoom = new Room
            (
                  rs.getInt("RoomType"),
                  rs.getInt("RoomView"),
                  rs.getInt("RoomStatus"),
                  rs.getString("RoomNumber")
            );
            lastRoom.setId(rs.getInt("Id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        return lastRoom;
    }

    @Override
    public void Update(Room room) {
        String sql = "update rooms set RoomType= ?"
                + ",RoomView = ?,RoomStatus= ?,RoomNumber= ?"
                + "where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,room.getRoomType());
            ps.setInt(2, room.getRoomView());
            ps.setInt(3, room.getRoomStatus());
            ps.setString(4,room.getRoomNumber());
            ps.setInt(5, room.getId());
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
    }

    @Override
    public void Delete(Room room) {
        String sql = "delete  from rooms where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,room.getId());
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
    }

    @Override
    public void DeleteByRoomNumber(String roomNumber) {
        String sql = "delete  from rooms where RoomNumber = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setString(1,roomNumber);
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
        String sql = "delete  from rooms where id = ?";
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
    public Room findById(int id) {
        String sql = "select *  from rooms where id = ?";
        Room room = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){    
            room = new Room
            (
                  rs.getInt("RoomType"),
                  rs.getInt("RoomView"),
                  rs.getInt("RoomStatus"),
                  rs.getString("RoomNumber")
            );
            room.setId(rs.getInt("Id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        return room;
    }

    @Override
    public LinkedList<String> getRoomTypes() {
        LinkedList<String> roomTypes = new LinkedList<>();
        String sql = "select * from room_type";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                roomTypes.add(rs.getString("RoomType")); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        
        return roomTypes;
    }

    @Override
    public LinkedList<String> getRoomViews() {
        LinkedList<String> roomViews = new LinkedList<>();
        String sql = "select * from room_view";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                roomViews.add(rs.getString("RoomView")); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        
        return roomViews;
    }

    @Override
    public LinkedList<String> getRoomStatus() {
        LinkedList<String> roomStatus = new LinkedList<>();
        String sql = "select * from room_status";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                roomStatus.add(rs.getString("RoomStatus")); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        
        return roomStatus;
    }
}
