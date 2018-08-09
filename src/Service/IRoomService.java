/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Room;
import java.util.LinkedList;

/**
 *
 * @author hp1
 */
public interface IRoomService {
     public LinkedList<Room> getRooms();
     public void Create(int roomType, int roomView, int roomStatus, String roomNumber);
     public Boolean Delete(Room room);
     public Boolean DeleteByRoomNumber(String roomNumber); 
     public Boolean DeleteById(int id);
     public LinkedList<String> getRoomTypes();
     public LinkedList<String> getRoomViews();
     public LinkedList<String> getRoomStatus();
     public Room findById(int id);
     public Boolean Update(Room room);
}
