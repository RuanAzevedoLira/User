package com.aulinha.dto.demo.service.converters;

import com.aulinha.dto.demo.dto.user.UserInsertDTO;
import com.aulinha.dto.demo.dto.user.UserListDTO;
import com.aulinha.dto.demo.model.User;

public class UserDTOConverters {
    
    public static User userInsertDTOToModel(UserInsertDTO userDTO){
        User userModel = new User();
        userModel.setUsername(userDTO.getUsername());
        userModel.setPassword(userDTO.getPassword());
        userModel.setEmail(userDTO.getEmail());
        userModel.setCpf(userDTO.getCpf());
        userModel.setAge(userDTO.getAge());
        userModel.setHeight(userDTO.getHeight());

        return userModel;
    }

    public static UserListDTO userListModelToDTO(User userModel){

        UserListDTO userDTO = new UserListDTO();
        userDTO.setUsername(userModel.getUsername());
        userDTO.setEmail(userModel.getEmail());

        return userDTO;
    }

}
