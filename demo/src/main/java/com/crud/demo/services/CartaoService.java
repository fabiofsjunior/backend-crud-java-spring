package com.crud.demo.services;

import com.crud.demo.controllers.CartaoRequest;
import com.crud.demo.model.CartaoEntity;
import com.crud.demo.model.UsuarioEntity;
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
        List<CartaoEntity> cartaoDoUsuarioId = (List<CartaoEntity>) this.cartaoRepository.findByFkUsuario(id);
        return cartaoDoUsuarioId;
    }

    public CartaoEntity criarCartao(CartaoRequest cartaoRequest) {
        var cartaoObjeto = CartaoEntity.builder()
                .tipoCartao(cartaoRequest.getTipoCartao())
                .nomeCartao(cartaoRequest.getNomeCartao())
                .fkUsuario(cartaoRequest.getFkUsuario())
                .statusCartao(cartaoRequest.isStatusCartao())
                .numeroCartao(gerarNumeroCartao()).build();

        var cartaoCriado = this.cartaoRepository.save(cartaoObjeto);
        return cartaoCriado;
    }
    public CartaoEntity criarCartaoPorId(CartaoRequest cartaoRequest) {
        var cartaoObjeto = CartaoEntity.builder()
                .tipoCartao(cartaoRequest.getTipoCartao())
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

    public CartaoEntity alterarCartao(Long id, CartaoRequest cartaoRequest){

        var dadosAlteradosCartao = cartaoRepository.save(CartaoEntity.builder()
                .idCartao(id)
                .tipoCartao(cartaoRequest.getTipoCartao())
                .nomeCartao(cartaoRequest.getNomeCartao())
                .fkUsuario(cartaoRequest.getFkUsuario())
                .statusCartao(cartaoRequest.isStatusCartao())
                .numeroCartao(cartaoRequest.getNumeroCartao()).build());
        return dadosAlteradosCartao;
    }
    public String gerarNumeroCartao() {

        Random random = new Random();
        int parteAleatoria = random.nextInt(100000000);

        String parteAleatoriaString = String.format("%08d", parteAleatoria);

        // Concatenar a parte aleat??ria com o prefixo e sufixo
        String numeroGerado = String.format("90.0.%s-0", parteAleatoriaString);

        // Atribuir o n??mero gerado ao atributo numeroCartao
        this.numeroCartao = numeroGerado;

        // Retornar o n??mero gerado
        return this.numeroCartao;
    }
}
