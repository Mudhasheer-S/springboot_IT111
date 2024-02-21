package com.example.online_pharmacy_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.online_pharmacy_backend.model.UserData;
import com.example.online_pharmacy_backend.repositary.RegisterRepositary;

@Service
public class RegisterService {

    private RegisterRepositary registerRepositary;

    public RegisterService(RegisterRepositary registerRepositary) {
        this.registerRepositary = registerRepositary;
    }

    public UserData saveRegisterDetail(UserData register) {
        return registerRepositary.save(register);
    }

    public Optional<UserData> getByUsername(String username) {
        return registerRepositary.findById(username);
    }

    public List<UserData> getAllDatas() {
        return registerRepositary.findAll();
    }

    public boolean updateRegister(String username, UserData register) {
        if (this.getByUsername(username) == null) {
            return false;
        }
        try {
            registerRepositary.save(register);
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    public boolean deleteRegister(String username) {
        if (this.getByUsername(username) == null) {
            return false;
        }
        try {
            registerRepositary.deleteById(username);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
