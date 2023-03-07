package com.crud.demo.repository;
import com.crud.demo.model.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoEntity, Long>{
List<CartaoEntity> findByFkUsuario(Long fkUsuario);
}