package com.crud.demo.controllers;


import com.crud.demo.model.CartaoEntity;
import com.crud.demo.repository.CartaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
@AllArgsConstructor
public class CartaoController {
    @Autowired
    private CartaoRepository cartaoRepository;

    @GetMapping("/cartao")
    public List<CartaoEntity> buscarCartao(){
        return cartaoRepository.findAll();
    }
    @PostMapping("/cartao")
    public String criarCartao(){
        return "Cartão criado com sucesso!";
    }
    @DeleteMapping("/cartao")
    public String deletarCartao(){
        return "Cartão deletado com sucesso!";
    }
    @PutMapping("/cartao")
    public String alterarCartao(){
        return "Cartão alterado com sucesso!";
    }

}