package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/User/")
public class UserController {

    
    @Autowired
    private UserService userService;

    @GetMapping("all/")
    public List<User> getDeputado(){
        return userService.findAll();
    }

    @GetMapping("id/{id}/")
    public User getUserById (@PathVariable ("id") Long id){
        try {
            return  userService.findById(id);
        } catch (ResourceNotFoundException e) {
            return null;
        }
    }

    @GetMapping("nome/{nome}/")
    public User getUserByName (@PathVariable ("nome") String nome){
        try {
            return  userService.findByNome(nome);
        } catch (ResourceNotFoundException e) {
            return null;
        }
    }

    @PostMapping(value = "add/")
    public void insiraUser(@RequestBody User user){
        userService.insertUser(user);
    }

    @PutMapping("update/{id}/")
    public void updateNome (@PathVariable ("id") Long id, @RequestBody String nome){
        try {
            userService.updateNome(id, nome);
        } catch (ResourceNotFoundException e) {

        }
    }

    @DeleteMapping("{id}/")
    public void deleteUser(@PathVariable Long id){
        try {
            userService.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("nome/{nome}")
    public void deleteUserByNome(@PathVariable String nome){
        try {
            userService.deleteByNome(nome);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
