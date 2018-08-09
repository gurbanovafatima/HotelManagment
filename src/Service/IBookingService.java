/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Booking;
import Model.Customer;
import Model.Room;
import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 *
 * @author hp1
 */
public interface IBookingService {
     public LinkedList<Booking> getBookings();
     public void Create(Customer customer, Room room, LocalDateTime checkIn, LocalDateTime checkOut, 
            int adultCount, int childrenCount,Boolean status);
     public Boolean Delete(Booking booking);
     public Boolean DeleteById(int id); 
     public Booking findById(int id);
     public Boolean Update(Booking booking);
}
