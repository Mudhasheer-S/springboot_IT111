package com.example.online_pharmacy_backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.online_pharmacy_backend.model.UserData;
import com.example.online_pharmacy_backend.service.RegisterService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class RegisterController {

    private RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/userData")
    public UserData postMethodName(@RequestBody UserData register) {

        return registerService.saveRegisterDetail(register);
    }

    @GetMapping("/userData")
    public List<UserData> getMethodName(@RequestParam("username") String userName) {
        List<UserData> list = new ArrayList<>();

        list.add(registerService.getByUsername(userName).orElse(null));
        ;

        return list;
    }

    @GetMapping("/userDatas")
    public List<UserData> getAllDatas() {

        return registerService.getAllDatas();
    }

    // http://localhost:8080/userData/${UserId}

    @PutMapping("userData/{username}")
    public ResponseEntity<UserData> putMethodName(@PathVariable String username, @RequestBody UserData register) {
        if (registerService.updateRegister(username, register) == true) {
            return new ResponseEntity<>(HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("userData/{username}")
    public ResponseEntity<UserData> delete(@PathVariable String username) {
        if (registerService.deleteRegister(username) == true) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
