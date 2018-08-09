/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Booking;
import java.util.LinkedList;

/**
 *
 * @author hp1
 */
public interface IBookingDao {
    public void Create(Booking booking);
    public LinkedList<Booking> getBookings();
    public Booking findById(int id);
    public Booking find(Booking booking);
    public void Update(Booking booking);
    public void Delete(Booking booking);
    public void DeleteById(int id);
}
