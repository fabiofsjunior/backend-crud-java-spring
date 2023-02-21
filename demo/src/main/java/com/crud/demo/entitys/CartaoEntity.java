package com.crud.demo.entitys;
import jakarta.persistence.*;


///Classe que representa a Tabela do DB.
@Entity
@Table(schema = "public", name = "cartao")
public class CartaoEntity {
    @Column(name = "id_cartao")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCartao;
    @Column(name = "nome_cartao")
    private String nomeCartao;
    @Column(name = "status_cartao")
    private String statusCartao;
    @Column(name = "tipo_cartao")
    private String tipoCartao;
    @Column(name = "fk_usuario")
    private String fk_usuario;

    public CartaoEntity() {
    }

    public CartaoEntity(Long idCartao, String nomeCartao, String statusCartao, String tipoCartao, String fk_usuario) {
        this.idCartao = idCartao;
        this.nomeCartao = nomeCartao;
        this.statusCartao = statusCartao;
        this.tipoCartao = tipoCartao;
        this.fk_usuario = fk_usuario;
    }

    public Long getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(Long idCartao) {
        this.idCartao = idCartao;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public String getStatusCartao() {
        return statusCartao;
    }

    public void setStatusCartao(String statusCartao) {
        this.statusCartao = statusCartao;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public String getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(String fk_usuario) {
        this.fk_usuario = fk_usuario;
    }
}