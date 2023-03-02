package com.crud.demo.controllers;

import com.crud.demo.model.CartaoEntity;
import com.crud.demo.services.enumeradores.TipoCartao;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartaoRequest {
    private String idCartao;
    private String nomeCartao;
    private TipoCartao tipoCartao;
    private String numeroCartao;
    private boolean statusCartao;
    private CartaoEntity fkUsuario;

}
