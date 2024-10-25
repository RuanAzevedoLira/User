package com.aulinha.dto.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulinha.dto.demo.dto.user.UserInsertDTO;
import com.aulinha.dto.demo.dto.user.UserListDTO;
import com.aulinha.dto.demo.service.UserService;

@RestController
@RequestMapping("api/users/")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping(value="insert/")
    public String insertUserHandler(@RequestBody UserInsertDTO user){
        
        //System.out.println(user);
        userService.insertUser(user);
        return "Usuário " + user.getUsername() + " cadastrado!";

    }

    @GetMapping
    public List<UserListDTO> listAllUsersHandler(){
        return userService.listUsers();
    }

}
