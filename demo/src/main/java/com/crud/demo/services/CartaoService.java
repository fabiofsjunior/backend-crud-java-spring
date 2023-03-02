package com.crud.demo.services;

import com.crud.demo.controllers.CartaoRequest;
import com.crud.demo.model.CartaoEntity;
import com.crud.demo.repository.CartaoRepository;
import com.crud.demo.repository.UsuarioRepository;
import com.crud.demo.services.enumeradores.TipoCartao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    private String numeroCartao;


    public List<CartaoEntity> exibirCartoes(){
        List<CartaoEntity> cartoesNaTabela =  cartaoRepository.findAll();
        return cartoesNaTabela;
    }

    public List<CartaoEntity> listarCartoes(Long id){
        List<CartaoEntity> cartaoDoUsuarioId =  this.cartaoRepository.findAllById(Collections.singleton(id));
        return cartaoDoUsuarioId;
    }

    public CartaoEntity criarCartao(CartaoRequest cartaoRequest) {
        var string = cartaoRequest.getTipoCartao().toString();
        var upperCase = string.toUpperCase();
//        var fkUsuarioId = usuarioRepository.findById(cartaoRequest.getFkUsuario()).get();
        var cartaoObjeto = CartaoEntity.builder()
                .tipoCartao(TipoCartao.valueOf(upperCase))
                .nomeCartao(cartaoRequest.getNomeCartao())
                .fkUsuario(cartaoRequest.getFkUsuario())
                .statusCartao(cartaoRequest.isStatusCartao())
                .numeroCartao(gerarNumeroCartao()).build();

        var cartaoCriado = this.cartaoRepository.save(cartaoObjeto);
        return cartaoCriado;
    }

    public void deletarCartao(Long id){
        cartaoRepository.deleteById(id);
    }
    public String gerarNumeroCartao() {

        Random random = new Random();
        int parteAleatoria = random.nextInt(100000000);

        String parteAleatoriaString = String.format("%08d", parteAleatoria);

        // Concatenar a parte aleatória com o prefixo e sufixo
        String numeroGerado = String.format("90.0.%s-0", parteAleatoriaString);

        // Atribuir o número gerado ao atributo numeroCartao
        this.numeroCartao = numeroGerado;

        // Retornar o número gerado
        return this.numeroCartao;
    }
}
