package com.crud.demo.controllers;


import com.crud.demo.model.UsuarioEntity;
import com.crud.demo.repository.UsarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    private UsarioRepository usarioRepository;
    @GetMapping("/api/usuario")
    public List<UsuarioEntity> buscarUsuario(){
        return usarioRepository.findAll();
    }
    @PostMapping("/api/usuario")
    public UsuarioEntity criarUsuario(UsuarioRequest usuarioRequest){
        ///Recebeu o Request do FRONT, e Criou uma Entity pra salvar no banco.
        var dadosUsuario = UsuarioEntity.builder()
                .nomeUsuario(usuarioRequest.getNomeUsuario())
                .emailUsuario(usuarioRequest.getEmailUsuario())
                .senhaUsuario(usuarioRequest.getSenhaUsuario()).build();

        var usuarioCriado = usarioRepository.save(dadosUsuario);

        return usuarioCriado;
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