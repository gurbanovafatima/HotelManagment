/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Room;
import java.util.LinkedList;

/**
 *
 * @author hp1
 */
public interface IRoomDao {
    public void Create(Room room);
    public LinkedList<Room> getRooms();
    public Room findByRoomNumber(String roomNumber);
    public Room findById(int id);
    public Room find(Room room);
    public void Update(Room room);
    public void Delete(Room room);
    public void DeleteByRoomNumber(String roomNumber);
    public void DeleteById(int id);
    public LinkedList<String> getRoomTypes();
    public LinkedList<String> getRoomViews();
    public LinkedList<String> getRoomStatus();
}
