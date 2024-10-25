package com.aulinha.dto.demo.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserInsertDTO {
    private String username;
    private String password;
    private String email;
    private String cpf;
    private Short age;
    private Double height;
}
