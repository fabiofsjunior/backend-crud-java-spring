package com.crud.demo.controllers;

import com.crud.demo.model.CartaoEntity;
import com.crud.demo.repository.CartaoRepository;
import com.crud.demo.services.CartaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return cartaoService.exibirCartoes();
    }
    @GetMapping("/api/cartao/{id}")
    public List<CartaoEntity> listarCartoes(@PathVariable Long id){
        return cartaoService.listarCartoes(id);
    }
    @PostMapping("/api/cartao")
    @ResponseStatus(HttpStatus.CREATED)
    public CartaoEntity criarCartao(@RequestBody CartaoRequest cartaoRequest){
        return cartaoService.criarCartao(cartaoRequest);
    }
    @PostMapping("/api/cartao/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CartaoEntity criarCartaoPorId(@RequestBody CartaoRequest cartaoRequest){
        return cartaoService.criarCartao(cartaoRequest);
    }
    @DeleteMapping("/api/cartao/{id}")
    public String deletarCartao(@PathVariable Long id){
        cartaoService.deletarCartao(id);
        return "Cartão deletado com sucesso!";
    }
    @PutMapping("/api/cartao/{id}")
    public CartaoEntity alterarCartao(@PathVariable Long id, @RequestBody CartaoRequest cartaoRequest){
        return cartaoService.alterarCartao(id, cartaoRequest);
    }

}