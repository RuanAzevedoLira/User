package com.aulinha.dto.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulinha.dto.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /// os métodos 
    /// .save .findAll .findById .delete e .deleteById
    /// já estão implementados pelo JPA, portanto
    /// não é necessário implementá-los 

    /// criar métodos personalizados, definindo apenas a
    /// assinatura, e o JPA vai implementar pra nós
    /// utilizando findBy... e deleteBy...
    public User findByCpf(String cpf);
    public void deleteByCpf(String cpf);
    
}
