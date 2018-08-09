/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Admin;
import java.util.LinkedList;

/**
 *
 * @author hp1
 */
public interface IAdminDao {
    public LinkedList<Admin> getAdmins();
    public Admin find(Admin admin);
    public Admin findById(int id);
    public Admin findByUsername(String username,String pass);
}
