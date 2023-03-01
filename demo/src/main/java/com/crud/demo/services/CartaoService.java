package com.crud.demo.services;

import com.crud.demo.model.CartaoEntity;
import com.crud.demo.model.UsuarioEntity;
import com.crud.demo.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;

    public List<CartaoEntity> exibirCartoes(){
        List<CartaoEntity> cartoesNaTabela =  cartaoRepository.findAll();
        return cartoesNaTabela;
    }

    public List<CartaoEntity> listarCartoes(Long id){
        List<CartaoEntity> cartaoDoUsuarioId =  this.cartaoRepository.findAllById(Collections.singleton(id));
        return cartaoDoUsuarioId;
    }
}
