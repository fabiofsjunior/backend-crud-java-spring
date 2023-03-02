package com.crud.demo.model;

import com.crud.demo.services.enumeradores.TipoCartao;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@Table(schema = "public", name = "cartao")
public class CartaoEntity {
    @Column(name = "id_cartao")
    @Id
    @JsonProperty("_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCartao;
    @Column(name = "nome_cartao", length = 255)
    private String nomeCartao;
    @Column(name = "numero_cartao", length = 255 )
    private String numeroCartao;
    @Column(name = "status_cartao", length = 255, nullable = false )
    private boolean statusCartao;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cartao", length = 255  )
    private TipoCartao tipoCartao;

//    @ManyToOne
//    @JoinColumn(name="fk_usuario")
    @Column(name = "fk_usuario")
    private Long fkUsuario;

    public CartaoEntity(Long idCartao, String nomeCartao, String numeroCartao, boolean statusCartao, TipoCartao tipoCartao, Long fkUsuario) {
        this.idCartao = idCartao;
        this.nomeCartao = nomeCartao;
        this.numeroCartao = numeroCartao;
        this.statusCartao = statusCartao;
        this.tipoCartao = tipoCartao;
        this.fkUsuario = fkUsuario;
    }
}