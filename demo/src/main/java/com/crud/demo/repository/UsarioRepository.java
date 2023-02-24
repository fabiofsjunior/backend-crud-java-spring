package com.crud.demo.repository;
import com.crud.demo.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsarioRepository extends JpaRepository<UsuarioEntity, Long>{


}