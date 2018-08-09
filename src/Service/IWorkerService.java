/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Worker;
import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 *
 * @author hp1
 */
public interface IWorkerService {
     public LinkedList<Worker> getWorkers();
     public void Create(int position,String surname, String name, Boolean gender, LocalDateTime date_of_birth, String email, String address, 
            String phoneNumber, Double salary,String username,String password);
     public Boolean Delete(Worker worker);
     public Boolean DeleteById(int id); 
     public LinkedList<String> getWorkerPositions();
     public Boolean Update(Worker worker);
     public Boolean findByUsername(String username, String pass);
     public Worker findById(int id);
}
