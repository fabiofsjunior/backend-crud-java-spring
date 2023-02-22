package com.crud.demo.controllers;


import com.crud.demo.model.UserEntity;
import com.crud.demo.repository.UsarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class UsuarioController {
    @Autowired
    private UsarioRepository usarioRepository;
    @GetMapping("/api/usuario")
    public List<UserEntity> buscarUsuario(){
        return usarioRepository.findAll();
    }
    @PostMapping("/api/usuario")
    public String criarUsuario(){
        return "Usuário criado com sucesso!";
    }
    @DeleteMapping("/api/usuario")
    public String deletarUsuario(){
        return "Usuário deletado com sucesso!";
    }
    @PutMapping("/api/usuario")
    public String alterarUsuario(){
        return "Usuário alterado com sucesso!";
    }

}