package com.aulinha.dto.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private String email;
    private String cpf;
    private Short age;
    private Double height;

}
