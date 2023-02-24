package com.crud.demo.controllers;

import lombok.Data;

@Data
public class UsuarioRequest {

    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;
}
