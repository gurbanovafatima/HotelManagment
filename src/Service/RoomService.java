/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.IRoomDao;
import Dao.RoomDao;
import Model.Room;
import java.util.LinkedList;

/**
 *
 * @author hp1
 */
public class RoomService implements IRoomService {
    

    private IRoomDao roomDao;

    public void setRoomDao(IRoomDao roomDao) {
        this.roomDao = roomDao;
    }

    public RoomService() {
        roomDao = new RoomDao();
    }
    
    
    
    @Override
    public LinkedList<Room> getRooms() {
         return roomDao.getRooms();
    }

    @Override
    public void Create(int roomType, int roomView, int roomStatus, String roomNumber) {
        Room room = new Room(roomType,roomView,roomStatus,roomNumber);
        roomDao.Create(room);
    }

    @Override
    public Boolean Delete(Room room) {
        if(room != null){
            if(roomDao.find(room) != null){
                roomDao.Delete(room);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean DeleteByRoomNumber(String roomNumber) {
        if(roomNumber != null && roomNumber.length() > 0){
            if(roomDao.findByRoomNumber(roomNumber) != null){
                 roomDao.DeleteByRoomNumber(roomNumber);
                return true;
            } 
        }
         return false;
    }

    @Override
    public Boolean DeleteById(int id) {
         if(roomDao.findById(id) != null){
             roomDao.DeleteById(id);
             return true;
         } 
         return false;
    }

    @Override
    public LinkedList<String> getRoomTypes() {
        return roomDao.getRoomTypes();
    }

    @Override
    public LinkedList<String> getRoomViews() {
        return roomDao.getRoomViews();
    }

    @Override
    public LinkedList<String> getRoomStatus() {
        return roomDao.getRoomStatus();
    }

    @Override
    public Room findById(int id) {
        if(roomDao.findById(id) != null){
            return roomDao.findById(id);
        }
        return null;
    }

    @Override
    public Boolean Update(Room room) {
         if(room != null){
            if(roomDao.find(room) != null){
                roomDao.Update(room);
                return true;
            }
        }
        return false;
    }
        
}
