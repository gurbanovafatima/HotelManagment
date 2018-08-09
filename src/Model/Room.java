/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hp1
 */
public class Room {
    
    private int id;
    private int roomType;
    private int roomView;
    private int roomStatus;
    private String roomNumber;

    @Override
    public String toString() {
        return this.getRoomNumber(); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public boolean equals(Object obj) {
        if(this.getId() == ((Room)obj).getId()){
            return true;
        }
        return false;
    }
    
    public Room(int roomType, int roomView, int roomStatus, String roomNumber) {
        this.roomType = roomType;
        this.roomView = roomView;
        this.roomStatus = roomStatus;
        this.roomNumber = roomNumber;
    }
    
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public int getRoomView() {
        return roomView;
    }

    public void setRoomView(int roomView) {
        this.roomView = roomView;
    }

    public int getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(int roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber){
        this.roomNumber = roomNumber;
    }
    
}
