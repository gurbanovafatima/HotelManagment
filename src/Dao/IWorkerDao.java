/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Worker;
import java.util.LinkedList;

/**
 *
 * @author hp1
 */
public interface IWorkerDao {
    public void Create(Worker worker);
    public LinkedList<Worker> getWorkers();
    public Worker findById(int id);
    public Worker find(Worker worker);
    public void Update(Worker worker);
    public void Delete(Worker worker);
    public void DeleteById(int id);
    public LinkedList<String> getWorkerPositions();
    public Worker findByUsername(String username,String pass) ;
}
