/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.BookingDao;
import Dao.IBookingDao;
import Model.Booking;
import Model.Customer;
import Model.Room;
import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 *
 * @author hp1
 */
public class BookingService implements IBookingService{

    private IBookingDao bookingDao;

    public void setBookingDao(IBookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public BookingService() {
        bookingDao = new BookingDao();
    }
    
    
    @Override
    public LinkedList<Booking> getBookings (){
        return bookingDao.getBookings();
    }

    @Override
    public void Create(Customer customer, Room room, LocalDateTime checkIn, LocalDateTime checkOut, int adultCount, 
            int childrenCount,Boolean status) {
           if(customer != null && room != null){
               Booking booking = new Booking(customer,room,checkIn,checkOut,adultCount,childrenCount,status);
               bookingDao.Create(booking);
           } 
    }

    @Override
    public Boolean Delete(Booking booking) {
          if(booking != null){
              if(bookingDao.find(booking) != null){
                  bookingDao.Delete(booking);
                  return true;
              }
          }
          return false;
    }

    @Override
    public Boolean DeleteById(int id) {
        if(bookingDao.findById(id) != null){
            bookingDao.DeleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Booking findById(int id) {
        if(bookingDao.findById(id) != null){
            return bookingDao.findById(id);
        }
        return null;
    }

    @Override
    public Boolean Update(Booking booking) {
        if(booking != null){
            if(bookingDao.find(booking) != null){
                bookingDao.Update(booking);
                return true;
            }
        }
        return false;
    }
    
}
