package com.crud.demo.services;

import com.crud.demo.controllers.UsuarioRequest;
import com.crud.demo.model.UsuarioEntity;
import com.crud.demo.repository.UsuarioRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public List<UsuarioEntity> list(){
        List<UsuarioEntity> usuariosNaTabela =  this.usuarioRepository.findAll();
        return usuariosNaTabela;
    }
    public UsuarioEntity addUsuario(UsuarioEntity usuarioRequest) {
        ///Recebeu o Request do FRONT, e Criou uma Entity pra salvar no banco.
        var dadosUsuario = usuarioRequest.builder()
                .nomeUsuario(usuarioRequest.getNomeUsuario())
                .emailUsuario(usuarioRequest.getEmailUsuario())
                .senhaUsuario(usuarioRequest.getSenhaUsuario()).build();

        var usuarioCriado = this.usuarioRepository.save(dadosUsuario);
        return usuarioCriado;
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }
}
