package com.example.online_pharmacy_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserData {
    
    @Id
    private String username;

    private String name,password;
    private String dob,email,gender;
    private int age,phone_number;


    
    public UserData(String username, String name, String password, String dob, String email, String gender, int age,
            int phone_number) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.dob = dob;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.phone_number = phone_number;
    }

    public UserData() {
    }

    public UserData(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    
}
