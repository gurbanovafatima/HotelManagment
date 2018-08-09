/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author hp1
 */
public class Booking {
    private int id;
    private Customer customer;
    private Room room;
    private LocalDateTime checkIn ;
    private LocalDateTime checkOut;
    private int adultCount;
    private int childrenCount;
    private Boolean status;

  

    @Override
    public boolean equals(Object obj) {
        if(this.getId() == ((Booking)obj).getId()){
            return true;
        }
        return false;
    }

    public Booking() {
    }

    
    
    public Booking(Customer customer, Room room, LocalDateTime checkIn, LocalDateTime checkOut, 
            int adultCount, int childrenCount,Boolean status) {
        
      
        this.customer = customer;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.adultCount = adultCount;
        this.childrenCount = childrenCount;
        this.status = status;
    }
  
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn (LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }
}
