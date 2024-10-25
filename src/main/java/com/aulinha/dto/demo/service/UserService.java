package com.aulinha.dto.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulinha.dto.demo.dto.user.UserInsertDTO;
import com.aulinha.dto.demo.dto.user.UserListDTO;
import com.aulinha.dto.demo.model.User;
import com.aulinha.dto.demo.repository.UserRepository;
import com.aulinha.dto.demo.service.converters.UserDTOConverters;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public void insertUser(UserInsertDTO userDTO){
        User userModel = UserDTOConverters.userInsertDTOToModel(userDTO);
        userRepository.save(userModel);
    }

    public List<UserListDTO> listUsers(){

        List<UserListDTO> usersDTO = new ArrayList<>();
        List<User> usersModel = userRepository.findAll();

        for (int i=0; i<usersModel.size(); i++){
            User userModel = usersModel.get(i);
            UserListDTO userDTO = UserDTOConverters.userListModelToDTO(userModel);
            usersDTO.add(userDTO);
        }

        return usersDTO;
    }

}
