package com.crud.demo.controllers;


import com.crud.demo.model.UsuarioEntity;
import com.crud.demo.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/api/usuario")
    public List<UsuarioEntity> buscarUsuario(){
        return usuarioService.list();
    }
    @PostMapping("/api/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioEntity criarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.addUsuario(usuarioRequest);
    }
    @DeleteMapping("/api/usuario/{id}") ///@PathVariable mapeia o id recebido do front
    public String deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        return "Usuário deletado com sucesso!";
    }
    @PutMapping("/api/usuario/{id}")
    public UsuarioEntity alterarUsuario(@PathVariable Long id, @RequestBody UsuarioRequest usuarioRequest){
       return usuarioService.alterarUsuario(id, usuarioRequest);
    }

}