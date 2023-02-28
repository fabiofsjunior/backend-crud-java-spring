package com.crud.demo.model;

import com.crud.demo.services.enumeradores.TipoCartao;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(schema = "public", name = "cartao")
public class CartaoEntity {
    @Column(name = "id_cartao")
    @Id
    @JsonProperty("_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCartao;
    @Column(name = "nome_cartao", length = 255, nullable = false )
    private String nomeCartao;
    @Column(name = "numero_cartao", length = 255, nullable = false )
    private String numeroCartao;
    @Column(name = "status_cartao", length = 255, nullable = false )
    private boolean statusCartao;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cartao", length = 255, nullable = false )
    private TipoCartao tipoCartao;

//    @ManyToOne
//    @JoinColumn(name="fk_usuario", nullable=false)
//    private UsuarioEntity fkUsuario;

}