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
    public UsuarioEntity addUsuario(UsuarioRequest usuarioRequest) {
        ///Recebeu o Request do FRONT, e Criou uma Entity pra salvar no banco.
        var dadosUsuario = UsuarioEntity.builder()
                .nomeUsuario(usuarioRequest.getNomeUsuario())
                .emailUsuario(usuarioRequest.getEmailUsuario())
                .senhaUsuario(usuarioRequest.getSenhaUsuario()).build();

        var usuarioCriado = this.usuarioRepository.save(dadosUsuario);
        return usuarioCriado;
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioEntity alterarUsuario(Long id, UsuarioRequest usuarioRequest) {
        var dadosAlteradosUsuario = usuarioRepository.save(UsuarioEntity.builder()
                .idUsuario(id)
                .nomeUsuario(usuarioRequest.getNomeUsuario())
                .emailUsuario(usuarioRequest.getEmailUsuario())
                .senhaUsuario(usuarioRequest.getSenhaUsuario())
                .build());

        return dadosAlteradosUsuario;
    }
}
