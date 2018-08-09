/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Customer;
import java.util.LinkedList;

/**
 *
 * @author hp1
 */
public interface ICustomerDao {
    public void Create(Customer customer);
    public LinkedList<Customer> getCustomers();
    public Customer findById(int id);
    public Customer find(Customer customer);
    public void Update(Customer customer);
    public void Delete(Customer customer);
    public void DeleteById(int id);
}
