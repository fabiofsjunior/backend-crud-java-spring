package com.crud.demo.model;


import com.crud.demo.services.enumeradores.TipoCartao;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Builder
@Table(schema = "public", name = "usuario")
public class UsuarioEntity {
    @Column(name = "id_usuario")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(name = "nome_usuario", length = 255, nullable = false )
    private String nomeUsuario;
    @Column(name = "emailUsuario", length = 255, nullable = false )
    private String emailUsuario;
    @Column(name = "senhaUsuario", length = 255, nullable = false )
    private String senhaUsuario;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name="fk_usuario", nullable=false)
    private Set<CartaoEntity> cartoesUsuario;

    public UsuarioEntity(Long idUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario, Set<CartaoEntity> cartoesUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.cartoesUsuario = cartoesUsuario;
    }
}