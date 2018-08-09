/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Worker;
import Utils.DBConnection;
import Utils.DateTimeConverter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 *
 * @author hp1
 */
public class WorkerDao implements IWorkerDao {  
    
    
    private DateTimeConverter dateTimeConverter;
    public WorkerDao() {
        dateTimeConverter = new DateTimeConverter();
    }
    
    @Override
    public void Create(Worker worker) {
        String sql = "insert into workers"
                + "(WorkerPosition,FirstName,LastName,Gender,BirthDate,Email,Address,PhoneNumber,"
                + "Salary,Username,Pass)"
                + "Values(?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,worker.getWorkerPositon());
            ps.setString(2,worker.getName());
            ps.setString(3, worker.getSurname());
            ps.setBoolean(4, worker.getGender());
            ps.setDate(5, dateTimeConverter.convertToSqlDate(worker.getDate_of_birth()));
            ps.setString(6, worker.getEmail());
            ps.setString(7, worker.getAddress());
            ps.setString(8,worker.getPhoneNumber());
            ps.setDouble(9,worker.getSalary());
            ps.setString(10,worker.getUsername());
            ps.setString(11,worker.getPassword());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
    }

    @Override
    public LinkedList<Worker> getWorkers() {
        LinkedList<Worker> workers = new LinkedList<>();
        String sql = "select * from workers";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Worker worker = new Worker
                (
                    
                    rs.getInt("WorkerPosition"),
                    rs.getString("LastName"),
                    rs.getString("FirstName"),
                    rs.getBoolean("Gender"),
                    dateTimeConverter.convertToLocalDateTime(rs.getDate("BirthDate")),
                    rs.getString("Email"),
                    rs.getString("Address"),
                    rs.getString("PhoneNumber"),
                    rs.getDouble("Salary"),
                    rs.getString("Username"),
                    rs.getString("Pass")
                );
                worker.setId(rs.getInt("Id"));
                workers.add(worker);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        
        return workers;
    }

    @Override
    public Worker findById(int id) {
        String sql = "select *  from workers where id = ?";
        Worker worker = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            rs.first();
            worker = new Worker
            (
                  rs.getInt("WorkerPosition"),
                  rs.getString("LastName"),
                  rs.getString("FirstName"),
                  rs.getBoolean("Gender"),
                  dateTimeConverter.convertToLocalDateTime(rs.getDate("BirthDate")),
                  rs.getString("Email"),
                  rs.getString("Address"),
                  rs.getString("PhoneNumber"),
                  rs.getDouble("Salary"),
                  rs.getString("Username"),
                  rs.getString("Pass")
            );
            worker.setId(rs.getInt("Id"));
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        return worker;
    }

    @Override
    public Worker find(Worker worker) {
        String sql = "select *  from workers where id = ?";
        Worker lastWorker = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,worker.getId());
            rs = ps.executeQuery();
            while(rs.next()){
            lastWorker = new Worker
            (
                  rs.getInt("WorkerPosition"),
                  rs.getString("LastName"),
                  rs.getString("FirstName"),
                  rs.getBoolean("Gender"),
                  dateTimeConverter.convertToLocalDateTime(rs.getDate("BirthDate")),
                  rs.getString("Email"),
                  rs.getString("Address"),
                  rs.getString("PhoneNumber"),
                  rs.getDouble("Salary"),
                  rs.getString("Username"),
                  rs.getString("Pass")
            );
            lastWorker.setId(rs.getInt("Id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        return lastWorker;
    }

    @Override
    public void Update(Worker worker) {
        String sql = "update workers set  WorkerPosition = ?,FirstName = ?"
                + ",LastName = ?,Gender = ?,BirthDate = ?,Email =?,Address = ?,PhoneNumber =?,Salary = ?,Username = ?,"
                 + "Pass =? where Id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,worker.getWorkerPositon());
            ps.setString(2,worker.getName());
            ps.setString(3, worker.getSurname());
            ps.setBoolean(4, worker.getGender());
            ps.setDate(5,dateTimeConverter.convertToSqlDate(worker.getDate_of_birth()));
            ps.setString(6, worker.getEmail());
            ps.setString(7, worker.getAddress());
            ps.setString(8,worker.getPhoneNumber());
            ps.setDouble(9,worker.getSalary());
            ps.setString(10, worker.getUsername());
            ps.setString(11, worker.getPassword());
            ps.setInt(12,worker.getId());
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        
    }

    @Override
    public void Delete(Worker worker) {
        String sql = "delete  from workers where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,worker.getId());
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
        String sql = "delete  from workers where id = ?";
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
    public LinkedList<String> getWorkerPositions() {
        LinkedList<String> workerPositions = new LinkedList<>();
        String sql = "select * from worker_positions";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                workerPositions.add(rs.getString("PositionName")); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        
        return workerPositions;
    }
    
    @Override
    public Worker findByUsername(String username,String pass) {
        String sql = "select *  from workers where username = ? and pass = ?";
        Worker worker = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getDbConnection().connectDb();
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2, pass);
            rs = ps.executeQuery();
             while(rs.next()){  
            worker = new Worker
            (
                 rs.getInt("WorkerPosition"),
                  rs.getString("LastName"),
                  rs.getString("FirstName"),
                  rs.getBoolean("Gender"),
                  dateTimeConverter.convertToLocalDateTime(rs.getDate("BirthDate")),
                  rs.getString("Email"),
                  rs.getString("Address"),
                  rs.getString("PhoneNumber"),
                  rs.getDouble("Salary"),
                  rs.getString("Username"),
                  rs.getString("Pass") 
            );
            worker.setId(rs.getInt("Id"));
             }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           DBConnection.getDbConnection().CloseConnections(null, conn, ps);
        }
        return worker;
    }

   
    
}
