package com.crud.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
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

    public UsuarioEntity(Long idUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
    }
}