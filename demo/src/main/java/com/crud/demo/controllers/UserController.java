package com.crud.demo.controllers;

import com.crud.demo.entitys.UserEntity;
import com.crud.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/user")
    public List<UserEntity> buscarUsuario(){
        return userRepository.findAll();
    }
    @PostMapping("/user")
    public String criarUsuario(){
        return "Usuário criado com sucesso!";
    }
    @DeleteMapping("/user")
    public String deletarUsuario(){
        return "Usuário deletado com sucesso!";
    }
    @PutMapping("/user")
    public String alterarUsuario(){
        return "Usuário alterado com sucesso!";
    }

}