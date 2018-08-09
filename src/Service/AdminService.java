/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.AdminDao;
import Dao.IAdminDao;
import Model.Admin;
import java.util.LinkedList;

/**
 *
 * @author hp1
 */
public class AdminService implements IAdminService {

    private IAdminDao adminDao;

    public AdminService() {
        adminDao  = new AdminDao();
    }
    
    
    @Override
    public LinkedList<Admin> getAdmins() {
        return adminDao.getAdmins();
    }

    @Override
    public Boolean findById(int id) {
        if(id > 0){
            if(adminDao.findById(id) != null){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean find(Admin admin) {
        if(admin.getId() > 0){
            if(adminDao.findById(admin.getId()) != null){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean findByUsername(String username, String pass) {
        if((username != null  && username.length() > 0) && (pass != null  && pass.length() > 0)) 
        {
            if(adminDao.findByUsername(username, pass) != null){
                return true;
            }
        }
        return false;
    }
    
}
