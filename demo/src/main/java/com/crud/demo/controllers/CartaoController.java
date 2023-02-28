package com.crud.demo.controllers;

import com.crud.demo.model.CartaoEntity;
import com.crud.demo.repository.CartaoRepository;
import com.crud.demo.services.CartaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CartaoController {
    @Autowired
    private CartaoService cartaoService;

    @GetMapping("/api/cartao")
    public List<CartaoEntity> exibirCartoes(){
        return cartaoService.listarCartoes();
    }
    @PostMapping("/api/cartao")
    public String criarCartao(){
        return "Cartão criado com sucesso!";
    }
    @DeleteMapping("/api/cartao")
    public String deletarCartao(){
        return "Cartão deletado com sucesso!";
    }
    @PutMapping("/api/cartao")
    public String alterarCartao(){
        return "Cartão alterado com sucesso!";
    }

}