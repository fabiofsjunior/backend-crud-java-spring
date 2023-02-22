package com.crud.demo.model;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(schema = "public", name = "usuario")
public class UserEntity {
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


    public UserEntity() {
    }

}