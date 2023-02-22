package com.crud.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;


///Classe que representa a Tabela do DB.
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
    @Column(name = "tipo_cartao", length = 255, nullable = false )
    private String tipoCartao;
    @Column(name = "fk_usuario", length = 255, nullable = false )
    private int fk_usuario;

    public CartaoEntity() {
    }

}