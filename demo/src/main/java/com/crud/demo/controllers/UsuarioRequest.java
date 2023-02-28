package com.crud.demo.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRequest {

    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;

}
