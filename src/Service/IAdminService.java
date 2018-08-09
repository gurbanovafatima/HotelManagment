/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Admin;
import java.util.LinkedList;

/**
 *
 * @author hp1
 */
public interface IAdminService {
     public LinkedList<Admin> getAdmins();
     public Boolean findById(int id);
     public Boolean find(Admin admin);
     public Boolean findByUsername(String username,String pass);
}
