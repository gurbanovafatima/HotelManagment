/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.IWorkerDao;
import Dao.WorkerDao;
import Model.Worker;
import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 *
 * @author hp1
 */
public class WorkerService implements IWorkerService{

    private IWorkerDao workerDao;

    public void setWorkerDao(IWorkerDao workerDao) {
        this.workerDao = workerDao;
    }

    public WorkerService() {
          workerDao = new WorkerDao();
    }
    
    
    @Override
    public LinkedList<Worker> getWorkers() {
        return workerDao.getWorkers();
    }

    @Override
    public void Create(int position,String surname, String name, Boolean gender, LocalDateTime date_of_birth, String email, 
            String address, String phoneNumber, Double salary,String username,String password) {
        if((surname != null && surname.length() > 0 ) && (name != null && name.length() > 0 ) 
            && (email != null && email.length() > 0 ) && (address != null && address.length() > 0)
            && (phoneNumber != null && phoneNumber.length() > 0 ))
        {
            Worker worker= new Worker(position,surname,name,gender,date_of_birth,email,address,
                    phoneNumber,salary,username,password);
            workerDao.Create(worker);
        }
    }

    @Override
    public Boolean Delete(Worker worker) {
         if(worker != null){
             if(workerDao.find(worker) != null){
                 workerDao.Delete(worker);
                 return true;
             }
         }
         return false;
    }

    @Override
    public Boolean DeleteById(int id) {
        if(workerDao.findById(id) != null){
            workerDao.DeleteById(id);
            return true;
        }
        return false; 
    }

    @Override
    public LinkedList<String> getWorkerPositions() {
        return workerDao.getWorkerPositions();
    }

    @Override
    public Boolean Update(Worker worker) {
        if(worker != null){
            if(workerDao.find(worker) != null){
                workerDao.Update(worker);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Boolean findByUsername(String username, String pass) {
        if((username != null  && username.length() > 0) && (pass != null  && pass.length() > 0)) 
        {
            if(workerDao.findByUsername(username, pass) != null){
                return true;
            }
        }
        return false;
    }

    @Override
    public Worker findById(int id) {
        if(workerDao.findById(id) != null){
            return workerDao.findById(id);
        }
        return null;
    }
    
    
}
