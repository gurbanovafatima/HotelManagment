/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Customer;
import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 *
 * @author hp1
 */
public interface ICustomerService {
     public LinkedList<Customer> getCustomers();
     public void Create(String surname, String name, Boolean gender, LocalDateTime date_of_birth, String email, 
            String address, String phoneNumber, String nationality);
     public Boolean Delete(Customer customer);
     public Boolean DeleteById(int id); 
     public Customer findById(int id);
     public Boolean Update(Customer customer);
}
