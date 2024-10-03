package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    // /*API*/
    // private final String url = "https://www.camara.leg.br/SitCamaraWS/Deputados.asmx/ObterDeputados";

    // @Autowired
    // private RestTemplate restTemplate;

    // public String getAllData(){
    //     return restTemplate.getForObject(this.url, String.class);
    // }

    /*POST*/
    public void insertUser(User user){
        userRepository.save(user);
    }

    /*GET*/
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User  findById (Long id) throws ResourceNotFoundException{
        Optional<User > opUser  = userRepository.findById(id);

        if(opUser.isEmpty()){
            throw new ResourceNotFoundException("User não encontrado"); 
        }
        return opUser .get(); 
    }

    public User findByNome(String nome) throws ResourceNotFoundException{
        return userRepository.findByNome(nome);
    }

    /*PUT*/
        public void updateNome(Long id, String nome) throws ResourceNotFoundException{
            Optional<User> opUser  = userRepository.findById(id);
     
            if (opUser.isEmpty()) {
                throw new ResourceNotFoundException("User não encontrado"); 
            }
     
            User user = opUser.get();
            user.setNome(nome);
            userRepository.save(user);
        }

    /*DELETE*/
        public void deleteById(Long id) throws ResourceNotFoundException{
            Optional<User> opUser  = userRepository.findById(id);
     
            if (opUser .isEmpty()) {
                throw new ResourceNotFoundException("User não encontrado"); 
            }
     
            User user  = opUser .get();
            userRepository.delete(user);
        }

        public void deleteByNome(String nome) throws ResourceNotFoundException {
            userRepository.deleteByNome(nome);
        }
    
}

