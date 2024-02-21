package com.example.online_pharmacy_backend.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.online_pharmacy_backend.model.UserData;

public interface RegisterRepositary extends JpaRepository<UserData , String>{

}
