/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author hp1
 */
public class Worker {
    
    private static int ID = 0;
    
    private int id;
    private int workerPositon;
    private String surname;
    private String name; 
    private Boolean gender;
    private LocalDateTime date_of_birth;
    private String email;
    private String address;
    private String phoneNumber;
    private Double salary;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public int getWorkerPositon() {
        return workerPositon;
    }

    public void setWorkerPositon(int workerPositon) {
        this.workerPositon = workerPositon;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.getId() == ((Worker)obj).getId()){
            return true;
        }
        return false;
    }

    public Worker(int position,String surname, String name, Boolean gender, LocalDateTime date_of_birth,
            String email, String address,String phoneNumber, Double salary,String username,String password){
     
        this.workerPositon = position;
        this.surname = surname;
        this.name = name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.username = username;
        this.password= password;
    }
 
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public LocalDateTime getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDateTime date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }    
    
}
