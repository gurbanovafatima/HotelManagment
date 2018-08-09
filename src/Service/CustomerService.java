/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.CustomerDao;
import Dao.ICustomerDao;
import Model.Customer;
import java.time.LocalDateTime;
import java.util.LinkedList;


/**
 *
 * @author hp1
 */
public class CustomerService  implements ICustomerService{
      
    private ICustomerDao customerDao;

    public void setCustomerDao(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public CustomerService() {
        customerDao = new CustomerDao();
    }

    @Override
    public LinkedList<Customer> getCustomers() {
          return customerDao.getCustomers();
    }
    

    @Override
    public void Create(String surname, String name, Boolean gender, LocalDateTime date_of_birth, String email, String address, String phoneNumber, String nationality) {
        if((surname != null && surname.length() > 0 ) && (name != null && name.length() > 0 ) 
           && (email != null && email.length() > 0 ) && (address != null && address.length() > 0)
            && (phoneNumber != null && phoneNumber.length() > 0 ) && (nationality != null && nationality.length() > 0))
        {
            Customer customer= new Customer(surname,name,gender,date_of_birth,email,address,
                    phoneNumber,nationality);
            customerDao.Create(customer);
        }
    }

    @Override
    public Boolean Delete(Customer customer) {
         if(customer != null){
             if(customerDao.find(customer) != null){
                 customerDao.Delete(customer);
                 return true;
             }
         }
         return false;
    }

    @Override
    public Boolean DeleteById(int id) {
        if(customerDao.findById(id) != null){
            customerDao.DeleteById(id);
            return true;
        }
        return false; 
    }

    @Override
    public Customer findById(int id) {
        if(customerDao.findById(id) != null){
            return customerDao.findById(id);
        }
        return null;
    }

    @Override
    public Boolean Update(Customer customer) {
        if(customer != null){
            if(customerDao.find(customer) != null){
                customerDao.Update(customer);
                return true;
            }
        }
        return false;
    }
    
}
