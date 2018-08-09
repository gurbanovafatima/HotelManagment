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
public class Customer {

    @Override
    public String toString() {
        return this.getName() + " " + this.getSurname(); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public boolean equals(Object obj) {
        if(this.getId() == ((Customer)obj).getId()){
            return true;
        }
        return false;
    }
    
    private int id;
    private String surname;
    private String name; 
    private Boolean gender;
    private LocalDateTime date_of_birth;
    private String email;
    private String address;
    private String phoneNumber;
    private String nationality;
    

    public Customer(String surname, String name, Boolean gender, LocalDateTime date_of_birth, String email, 
            String address, String phoneNumber,String nationality) {
 
        this.surname = surname;
        this.name = name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
